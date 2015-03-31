package io.jeminstalle.dao.impl;

import io.jeminstalle.dao.ProDAO;
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
}
