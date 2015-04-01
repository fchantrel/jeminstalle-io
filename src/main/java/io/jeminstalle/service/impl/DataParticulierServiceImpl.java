package io.jeminstalle.service.impl;

import io.jeminstalle.dao.*;
import io.jeminstalle.domain.*;
import io.jeminstalle.service.DataParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class DataParticulierServiceImpl implements DataParticulierService {

    @Autowired
    private RefGeoDao refGeoDao;

    @Autowired
    private PollutionDAO pollutionDAO;

    @Autowired
    private TransportDAO transportDAO;

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
    private RefGeo getRefGeoContainsZipCodeOnly(List<RefGeo> refGeoList) {
        for (RefGeo refGeo : refGeoList) {
            if (refGeo.getZipcode() != null) {
                return refGeo;
            }
        }
        // FIXME
        RefGeo rg = refGeoList.get(0);
        rg.setZipcode("75000");
        return rg;
    }

    @Override
    public DataParticulier getDataParticulierByName(String name) {

        List<RefGeo> refGeos = refGeoDao.findByName(name);
        RefGeo refGeo = getRefGeoContainsZipCodeOnly(refGeos);

        DataParticulier dp = getDataParticulier(refGeo, name, refGeo.getLatitude(), refGeo.getLongitude());

        return dp;
    }


    @Override
    public DataParticulier getDataParticulierByPosition(String latitude, String longitude) {

        List<RefGeo> refGeos = refGeoDao.findByLatitudeAndLongitude(Float.valueOf(latitude), Float.valueOf(longitude));
        RefGeo refGeo = getRefGeoContainsZipCodeOnly(refGeos);

        DataParticulier dp = getDataParticulier(refGeo, refGeo.getName(), refGeo.getLatitude(), refGeo.getLongitude());

        return dp;
    }


    private DataParticulier getDataParticulier(RefGeo refGeo, String commune, float latitude, float longitude) {

        String departement = refGeo.getZipcode().substring(0, 2);

        DataParticulier dp = new DataParticulier();

        Pollution pollution = pollutionDAO.findByNodepartement(departement).get(0);
        Couverture4G couverture4G = couverture4GDAO.findByCodedepartement(departement);
        Ensoleillement ensoleillement = ensoleillementDAO.findByNodepartement(departement);
        RevenuMoyen revenuMoyen = revenuMoyenDAO.findByNomcommune(commune).get(0);
        Precipitation precipitation = precipitationDAO.findByNodepartement(departement);
        Nucleaire nucleaire = nucleaireDAO.findByNumdep(departement);

        //List<Transport> transports = transportDAO.findByLatitudeAndLongitude(latitude, longitude);
        //dp.getTransports().addAll(transports);

        Transport t = new Transport();
        t.setLigne("ligne A");
        t.setNom("arret 1");
        t.setLongitude(-1.679444f);
        t.setLatitude(48.11472f);
        dp.getTransports().add(t);

        t = new Transport();
        t.setLigne("ligne A");
        t.setNom("arret 2");
        t.setLongitude(-1.689444f);
        t.setLatitude(48.11472f);
        dp.getTransports().add(t);

        t = new Transport();
        t.setLigne("ligne A");
        t.setNom("arret 3");
        t.setLongitude(-1.699444f);
        t.setLatitude(48.12472f);
        dp.getTransports().add(t);

        t = new Transport();
        t.setLigne("ligne B");
        t.setNom("arret 1");
        t.setLongitude(-1.599444f);
        t.setLatitude(48.22472f);
        dp.getTransports().add(t);

        t = new Transport();
        t.setLigne("ligne B");
        t.setNom("arret 2");
        t.setLongitude(-1.609444f);
        t.setLatitude(48.23472f);
        dp.getTransports().add(t);

        t = new Transport();
        t.setLigne("ligne B");
        t.setNom("arret 3");
        t.setLongitude(-1.619444f);
        t.setLatitude(48.24472f);
        dp.getTransports().add(t);


        dp.setPollution(pollution);
        dp.setCouverture4G(couverture4G);
        dp.setRevenuMoyen(revenuMoyen);
        precipitation.convertirEnMm();
        dp.setPrecipitation(precipitation);
        dp.setNucleaire(nucleaire);
        dp.setEnsoleillement(ensoleillement);


        String distanceKM = "12";
        String maxResultat = "10";

        String boulangeriesJSON = proDAO.findByCoordonneesAndRubrique(String.valueOf(latitude), String.valueOf(longitude), "boulangerie", distanceKM, maxResultat);

        System.out.println(boulangeriesJSON);

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
