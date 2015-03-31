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
    public String findByCoordonneesAndRubrique(String latitude, String longitude, String rubrique) {

        String s = "{ \"query\": { \"multi_match\": { \"query\": \"restaurant\", \"fields\": [ \"epj.denom\", \"parutions.parutionrubriques.rubrique.content^10\"] } }, \"filter\": { \"geo_distance\" : { \"distance\" : \"12km\", \"proGeoCoord\" : { \"lat\" : 48.86, \"lon\" : 2.27 } } } } ";
        String retour = restTemplate.getForObject("http://192.168.160.227:9200/slev8epj/blocsepj/_search?size=1", String.class, s);

        System.out.println(retour);

        return "";
    }
}
