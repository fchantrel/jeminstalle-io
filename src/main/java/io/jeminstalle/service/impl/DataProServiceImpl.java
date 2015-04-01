package io.jeminstalle.service.impl;

import io.jeminstalle.dao.*;
import io.jeminstalle.domain.*;
import io.jeminstalle.service.DataProService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fchantrel on 31/03/2015.
 */
@Service
public class DataProServiceImpl implements DataProService {

    @Autowired
    private LightRefGeoDao lightRefGeoDao;

    @Autowired
    private PollutionDAO pollutionDAO;

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

    @Override
    public DataPro getDataPro(String activite, String ou) {

        DataPro dp = new DataPro();
        dp.setActivite(activite);
        dp.setOu(ou);
        
        try{
        	List<LightRefGeo> lstRefGeo = lightRefGeoDao.findByInseecode(ou);
        	if(lstRefGeo.size() > 0){
        		LightRefGeo refGeo = lstRefGeo.get(0);
        		dp.setPopulation(refGeo.getPopulation());
        		System.out.println("Lieu trouve pour le code insee : " + ou);
        	} else {
        		System.out.println("Pas de lieu trouve pour le code insee : " + ou);
        		dp.setPopulation(10000);
        	}
            
            dp.setNbPro(10);
            dp.setRatio(1.123);
        } catch(Exception e){
        	e.printStackTrace();
        }
        
        /**
        String departement = refGeo.getZipcode().substring(0, 2);
        Pollution pollution = pollutionDAO.findByNodepartement(departement).get(0);
        Couverture4G couverture4G = couverture4GDAO.findByCodedepartement(departement);
        Ensoleillement ensoleillement = ensoleillementDAO.findByNodepartement(departement);
        RevenuMoyen revenuMoyen = revenuMoyenDAO.findByNomcommune(ou).get(0);
        Precipitation precipitation = precipitationDAO.findByNodepartement(departement);
        Nucleaire nucleaire = nucleaireDAO.findByNumdep(departement);
*/

        //proDAO.findByCoordonneesAndRubrique(String.valueOf(refGeo.getLatitude()), String.valueOf(refGeo.getLongitude()), "restaurant");

        return dp;
    }

	@Override
	    public DataPro getDataProByRegion(String activite, String ou) {
	
	        DataPro dp = new DataPro();
	        dp.setActivite(activite);
	        dp.setOu(ou);
	        
	        try{
	        	List<LightRefGeo> lstRefGeo = lightRefGeoDao.findByInseecode(ou);
	        	if(lstRefGeo.size() > 0){
	        		LightRefGeo refGeo = lstRefGeo.get(0);
	        		dp.setPopulation(refGeo.getPopulation());
	        	} else {
	        		System.out.println("Pas de lieu trouve pour le code insee : " + ou);
	        		dp.setPopulation(10000);
	        	}
	            
	            dp.setNbPro(10);
	            dp.setRatio(1.123);
	        } catch(Exception e){
	        	e.printStackTrace();
	        }
	
	        return dp;
	    }
	
	@Override
    public DataPro getDataProByDepartement(String activite, String ou) {

        DataPro dp = new DataPro();
        dp.setActivite(activite);
        dp.setOu(ou);
        
        try{
        	List<LightRefGeo> lstRefGeo = lightRefGeoDao.findByInseecode(ou);
        	if(lstRefGeo.size() > 0){
        		LightRefGeo refGeo = lstRefGeo.get(0);
        		dp.setPopulation(refGeo.getPopulation());
        	} else {
        		System.out.println("Pas de lieu trouve pour le code insee : " + ou);
        		dp.setPopulation(10000);
        	}
            
            dp.setNbPro(10);
            dp.setRatio(1.123);
        } catch(Exception e){
        	e.printStackTrace();
        }

        return dp;
    }
	
	@Override
    public DataPro getDataProByCommune(String activite, String ou) {

        DataPro dp = new DataPro();
        dp.setActivite(activite);
        dp.setOu(ou);
        
        try{
        	List<LightRefGeo> lstRefGeo = lightRefGeoDao.findByInseecode(ou);
        	if(lstRefGeo.size() > 0){
        		LightRefGeo refGeo = lstRefGeo.get(0);
        		dp.setPopulation(refGeo.getPopulation());
        	} else {
        		System.out.println("Pas de lieu trouve pour le code insee : " + ou);
        		dp.setPopulation(10000);
        	}
            
            dp.setNbPro(10);
            dp.setRatio(1.123);
        } catch(Exception e){
        	e.printStackTrace();
        }

        return dp;
    }
}
