package io.jeminstalle.dao.impl;

import io.jeminstalle.dao.ProDAO;
import io.jeminstalle.domain.DenombrementES;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class ProDAOImpl implements ProDAO {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String findByCoordonneesAndRubrique(String latitude, String longitude, String rubrique, String distanceKM, String maxResultat) {


        // FIXME : Refaire le query en priorisant les coordonnées !!

        String s = "{ \"query\": { \"multi_match\": { \"query\": \"" + rubrique + "\", \"fields\": [ \"epj.denom\", \"parutions.parutionrubriques.rubrique.content^10\"] } }, \"filter\": { \"geo_distance\" : { \"distance\" : \"" + distanceKM + "km\", \"proGeoCoord\" : { \"lat\" : " + latitude + ", \"lon\" : " + longitude + " } } } } ";
        String retour = restTemplate.getForObject("http://192.168.160.227:9200/slev8epj/blocsepj/_search?size=" + maxResultat, String.class, s);
        return retour;
    }

	@Override
	public int findByRegionAndActivite(String region, String activite, String maxResultat) {
	
	    String s = "{\"query\": {\"bool\": {\"must\": [{\"multi_match\": {\"query\":\"" + activite + "\",\"fields\": [\"epj.denom\",\"epj.cpldenom\",\"parutions.parutionrubriques.rubrique.content\"]}},{\"multi_match\": {\"query\":\"" + region + "\",\"fields\": [\"parutions.parutionrubriques.pjreg\"]}}]}}}";
	    
	    System.out.println("Requete : " + s);
	    
	    DenombrementES retour = restTemplate.getForObject("http://localhost:9200/slev8epj/blocsepj/_count", DenombrementES.class, s);
	    
	    System.out.println("Retour : " + retour.getCount());
	    
	    return retour.getCount();
	}
	
	@Override
	public int findByDepartementAndActivite(String departement, String activite, String maxResultat) {
	
	    String s = "{\"query\": {\"bool\": {\"must\": [{\"multi_match\": {\"query\":" + activite + ",\"fields\": [\"epj.denom\",\"epj.cpldenom\",\"parutions.parutionrubriques.rubrique.content\"]}},{\"multi_match\": {\"query\":" + departement + ",\"fields\": [\"parutions.parutionrubriques.pjdep\"]}}]}}}";
	    
	    DenombrementES retour = restTemplate.getForObject("http://localhost:9200/slev8epj/blocsepj/_count", DenombrementES.class, s);
	    
	    return retour.getCount();
	}
	
	@Override
	public int findByCommuneAndActivite(String commune, String activite, String maxResultat) {
	
	    String s = "{\"query\": {\"bool\": {\"must\": [{\"multi_match\": {\"query\":" + activite + ",\"fields\": [\"epj.denom\",\"epj.cpldenom\",\"parutions.parutionrubriques.rubrique.content\"]}},{\"multi_match\": {\"query\":" + commune + ",\"fields\": [\"parutions.parutionrubriques.pjdeploc\"]}}]}}}";
	    
	    DenombrementES retour = restTemplate.getForObject("http://localhost:9200/slev8epj/blocsepj/_count", DenombrementES.class, s);
	    
	    return retour.getCount();
	}
}
