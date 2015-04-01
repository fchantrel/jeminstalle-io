package io.jeminstalle.dao.impl;

import io.jeminstalle.dao.ProDAO;
import io.jeminstalle.domain.DenombrementES;
import org.apache.commons.lang3.StringUtils;
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

        String s = "{ \"query\": { \"multi_match\": { \"query\": \"" + rubrique + "\", \"fields\": [ \"epj.denom\", \"parutions.parutionrubriques.rubrique.content^10\"] } }, \"filter\": { \"geo_distance\" : { \"distance\" : \"" + distanceKM + "km\", \"proGeoCoord\" : { \"lat\" : " + latitude + ", \"lon\" : " + longitude + " } } } } ";
        String retour = restTemplate.postForObject("http://" + IP.IP + ":9200/slev8epj/blocsepj/_search?size=" + maxResultat, s, String.class);
        return retour;
    }

    @Override
    public int findByRegionAndActivite(String region, String activite, String maxResultat) {
        String s = "{\"query\": {\"bool\": {\"must\": [{\"multi_match\": {\"query\":\"" + activite + "\",\"fields\": [\"epj.denom\",\"epj.cpldenom\",\"parutions.parutionrubriques.rubrique.content\"]}},{\"multi_match\": {\"query\":\"" + region + "\",\"fields\": [\"parutions.parutionrubriques.pjreg\"]}}]}}}";
        DenombrementES retour = restTemplate.postForObject("http://" + IP.IP + ":9200/slev8epj/blocsepj/_count", s, DenombrementES.class);

        return retour.getCount();
    }

    @Override
    public int findByDepartementAndActivite(String departement, String activite, String maxResultat) {

        String codeDepartement = "0" + departement;
        String s = "{\"query\": {\"bool\": {\"must\": [{\"multi_match\": {\"query\":\"" + activite + "\",\"fields\": [\"epj.denom\",\"epj.cpldenom\",\"parutions.parutionrubriques.rubrique.content\"]}},{\"multi_match\": {\"query\":\"" + codeDepartement + "\",\"fields\": [\"parutions.parutionrubriques.pjdep\"]}}]}}}";
        DenombrementES retour = restTemplate.postForObject("http://" + IP.IP + ":9200/slev8epj/blocsepj/_count", s, DenombrementES.class);

        return retour.getCount();
    }

    @Override
    public int findByCommuneAndActivite(String commune, String activite, String maxResultat) {

        String communeFormatee = StringUtils.stripAccents(commune);
        if (communeFormatee.length() < 1) {
            communeFormatee = "cesson sevigne";
        }

        String s = "{\"query\": {\"bool\": {\"must\": [{\"multi_match\": {\"query\":\"" + activite + "\",\"fields\": [\"epj.denom\",\"epj.cpldenom\",\"parutions.parutionrubriques.rubrique.content\"]}},{\"multi_match\": {\"query\":\"" + communeFormatee + "\",\"fields\": [\"epj.libloc\"]}}]}}}";
        DenombrementES retour = new DenombrementES();
        try {
            retour = restTemplate.postForObject("http://" + IP.IP + ":9200/slev8epj/blocsepj/_count", s, DenombrementES.class);
        } catch (Exception e) {
            System.out.println("Libelle commune : " + communeFormatee);
            System.out.println("Requete : " + s);
            e.printStackTrace();
        }
        return retour.getCount();
    }
}
