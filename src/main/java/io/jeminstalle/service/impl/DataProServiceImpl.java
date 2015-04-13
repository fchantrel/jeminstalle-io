package io.jeminstalle.service.impl;

import io.jeminstalle.dao.Couverture4GDAO;
import io.jeminstalle.dao.EnsoleillementDAO;
import io.jeminstalle.dao.LightRefGeoDao;
import io.jeminstalle.dao.NucleaireDAO;
import io.jeminstalle.dao.PollutionDAO;
import io.jeminstalle.dao.PrecipitationDAO;
import io.jeminstalle.dao.ProDAO;
import io.jeminstalle.dao.RevenuMoyenDAO;
import io.jeminstalle.domain.DataPro;
import io.jeminstalle.domain.LightRefGeo;
import io.jeminstalle.service.DataProService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

/**
 * Created by fchantrel on 31/03/2015.
 */
@Service
@EnableAutoConfiguration
public class DataProServiceImpl implements DataProService {
	
	@Autowired
	private CounterService counterService;

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
    	
    	counterService.increment("counter.calls.getDataPro");

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
		
			counterService.increment("counter.calls.getDataProByRegion");
	
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
	            
	        	int nbProParActiviteParRegion = proDAO.findByRegionAndActivite(ou, activite, "1");
	        	
	            dp.setNbPro(nbProParActiviteParRegion);
	            if(dp.getPopulation() > 0) {
	            	double ratio = ((double)(nbProParActiviteParRegion)) / ((double)dp.getPopulation()) * 1000; 
		            dp.setRatio(ratio);
	            } else {
	            	dp.setRatio(0.123);
	            }
	        } catch(Exception e){
	        	e.printStackTrace();
	        }
	
	        return dp;
	    }
	
	@Override
    public DataPro getDataProByDepartement(String activite, String ou) {

		counterService.increment("counter.calls.getDataProByDepartement");
		
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
            
        	int nbProParActiviteParDepartement = proDAO.findByDepartementAndActivite(ou, activite, "1");
        	
            dp.setNbPro(nbProParActiviteParDepartement);
            if(dp.getPopulation() > 0) {
            	double ratio = ((double)(nbProParActiviteParDepartement)) / ((double)dp.getPopulation()) * 1000; 
	            dp.setRatio(ratio);
            } else {
            	dp.setRatio(0.123);
            }
        } catch(Exception e){
        	e.printStackTrace();
        }

        return dp;
    }
	
	@Override
    public DataPro getDataProByCommune(String activite, String ou) {
		
		counterService.increment("counter.calls.getDataProByCommune");

        DataPro dp = new DataPro();
        dp.setActivite(activite);
        dp.setOu(ou);
        
        String ouTrouve = ou;
        try{
        	List<LightRefGeo> lstRefGeo = lightRefGeoDao.findByInseecode(ou);
        	if(lstRefGeo.size() > 0){
        		LightRefGeo refGeo = lstRefGeo.get(0);
        		dp.setPopulation(refGeo.getPopulation());
        		
        		if(refGeo.getName() != null){
        			ouTrouve = refGeo.getName();
        		}
        	} else {
        		System.out.println("Pas de lieu trouve pour le code insee : " + ou);
        		dp.setPopulation(10000);
        	}
        	
        	int nbProParActiviteParCommune = proDAO.findByCommuneAndActivite(ouTrouve, activite, "1");
        	
            dp.setNbPro(nbProParActiviteParCommune);
            if(dp.getPopulation() > 0) {
            	double ratio = ((double)(nbProParActiviteParCommune)) / ((double)dp.getPopulation()) * 1000; 
	            dp.setRatio(ratio);
            } else {
            	dp.setRatio(0.123);
            }
        } catch(Exception e){
        	e.printStackTrace();
        }

        return dp;
    }
}
