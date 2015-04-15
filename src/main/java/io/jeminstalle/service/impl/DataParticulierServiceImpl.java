package io.jeminstalle.service.impl;

import io.jeminstalle.dao.Couverture4GDAO;
import io.jeminstalle.dao.EnsoleillementDAO;
import io.jeminstalle.dao.LightRefGeoDao;
import io.jeminstalle.dao.NucleaireDAO;
import io.jeminstalle.dao.PollutionDAO;
import io.jeminstalle.dao.PrecipitationDAO;
import io.jeminstalle.dao.ProDAO;
import io.jeminstalle.dao.RevenuMoyenDAO;
import io.jeminstalle.dao.StarbusDAO;
import io.jeminstalle.domain.Couverture4G;
import io.jeminstalle.domain.DataParticulier;
import io.jeminstalle.domain.Ensoleillement;
import io.jeminstalle.domain.LightRefGeo;
import io.jeminstalle.domain.Nucleaire;
import io.jeminstalle.domain.Pollution;
import io.jeminstalle.domain.Precipitation;
import io.jeminstalle.domain.RevenuMoyen;
import io.jeminstalle.domain.Starbus;
import io.jeminstalle.service.DataParticulierService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codahale.metrics.annotation.Timed;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class DataParticulierServiceImpl implements DataParticulierService {

    @Autowired
    private LightRefGeoDao refGeoDao;

    @Autowired
    private PollutionDAO pollutionDAO;

    @Autowired
    private StarbusDAO starbusDAO;

    @Autowired
    private Couverture4GDAO couverture4GDAO;

    @Autowired
    private EnsoleillementDAO ensoleillementDAO;

    @Autowired
    private RevenuMoyenDAO revenuMoyenDAO;

    @Autowired
    private PrecipitationDAO precipitationDAO;

    @Autowired
    private NucleaireDAO nucleaireDAO;

    @Autowired
    private ProDAO proDAO;

    //FIXME
    private LightRefGeo getRefGeoContainsZipCodeOnly(List<LightRefGeo> refGeoList) {
        for (LightRefGeo refGeo : refGeoList) {
            if (refGeo.getZipcode() != null) {
                return refGeo;
            }
        }
        // FIXME
        LightRefGeo rg = null;
        if((refGeoList != null)&&(refGeoList.size() > 0)){
        	rg = refGeoList.get(0);
        	rg.setZipcode("75000");
        }
        
        return rg;
    }

    @Override
    @Timed(name="DataParticulierServiceImpl.getDataParticulierByName")
    public DataParticulier getDataParticulierByName(String name) {

        List<LightRefGeo> refGeos = refGeoDao.findByName(name);
        LightRefGeo refGeo = getRefGeoContainsZipCodeOnly(refGeos);
        DataParticulier dp = new DataParticulier();
        if(refGeo == null) {
        	System.out.println("Lieu non trouve pour la chaine saisie : " + name);
        } else {
        	dp = getDataParticulier(refGeo, name, refGeo.getLatitude(), refGeo.getLongitude());
        }

        return dp;
    }


    @Override
    @Timed(name="DataParticulierServiceImpl.getDataParticulierByPosition")
    public DataParticulier getDataParticulierByPosition(String latitude, String longitude) {

        List<LightRefGeo> refGeos = refGeoDao.findByLatitudeAndLongitude(Float.valueOf(latitude), Float.valueOf(longitude));
        LightRefGeo refGeo = getRefGeoContainsZipCodeOnly(refGeos);

        DataParticulier dp = getDataParticulier(refGeo, refGeo.getName(), refGeo.getLatitude(), refGeo.getLongitude());

        return dp;
    }


    private DataParticulier getDataParticulier(LightRefGeo refGeo, String commune, float latitude, float longitude) {

        String distanceKM = "5";
        String maxResultat = "30";

        String departement = refGeo.getZipcode().substring(0, 2);

        DataParticulier dp = new DataParticulier();

        Pollution pollution = new Pollution();
        try{
            pollution = pollutionDAO.findByNodepartement(departement).get(0);
        } catch(Exception e){
        	pollution = new Pollution();
        	System.out.println("Pollution non trouvée pour le departement : " + departement);
        }

        Couverture4G couverture4G = couverture4GDAO.findByCodedepartement(departement);
        
        Ensoleillement ensoleillement = new Ensoleillement();
        try{
        	ensoleillement = ensoleillementDAO.findByNodepartement(departement);
        } catch(Exception e){
        	pollution = new Pollution();
        	System.out.println("Ensoleillement non trouvée pour le departement : " + departement);
        }
        
        RevenuMoyen revenuMoyen = new RevenuMoyen();
        try{
        	revenuMoyen = revenuMoyenDAO.findByNomcommune(commune).get(0);
        } catch(Exception e){
        	System.out.println("RevenuMoyen non trouvée pour departement : " + departement);
        }
        
        Precipitation precipitation = precipitationDAO.findByNodepartement(departement);
        
        Nucleaire nucleaire = nucleaireDAO.findByNumdep(departement);

        try{
            List<Starbus> starbuses = starbusDAO.findByLatitudeAndLongitude(latitude, longitude, distanceKM);
            dp.getStarbuses().addAll(starbuses);
        } catch (Exception e){
        	e.printStackTrace();
        }
        dp.setPollution(pollution);
        dp.setCouverture4G(couverture4G);
        dp.setRevenuMoyen(revenuMoyen);
        if(precipitation != null){
        	precipitation.convertirEnMm();
        } else {
        	System.out.println("Precipitations non trouvé pour le departement : " + departement);
        }
        
        dp.setPrecipitation(precipitation);
        dp.setNucleaire(nucleaire);
        dp.setEnsoleillement(ensoleillement);

        String boulangeriesJSON = proDAO.findByCoordonneesAndRubrique(String.valueOf(latitude), String.valueOf(longitude), "boulangerie", distanceKM, maxResultat);
        String pharmacieJSON = proDAO.findByCoordonneesAndRubrique(String.valueOf(latitude), String.valueOf(longitude), "pharmacie", distanceKM, maxResultat);
        String barJSON = proDAO.findByCoordonneesAndRubrique(String.valueOf(latitude), String.valueOf(longitude), "bar", distanceKM, maxResultat);
        String ecoleJSON = proDAO.findByCoordonneesAndRubrique(String.valueOf(latitude), String.valueOf(longitude), "ecole primaire", distanceKM, maxResultat);

        dp.setBoulangeries(boulangeriesJSON);
        dp.setPharmacies(pharmacieJSON);
        dp.setBars(barJSON);
        dp.setEcoles(ecoleJSON);

        dp.setRefGeo(refGeo);

        return dp;

    }
}
