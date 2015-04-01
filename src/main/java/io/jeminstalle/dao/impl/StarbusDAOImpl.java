package io.jeminstalle.dao.impl;

import io.jeminstalle.dao.StarbusDAO;
import io.jeminstalle.domain.Starbus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class StarbusDAOImpl implements StarbusDAO {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public List<Starbus> findByLatitudeAndLongitude(double latitude, double longitude, String amplitude) {

        CriteriaQuery geoLocationCriteriaQuery = new CriteriaQuery(
                new Criteria("location").within(new GeoPoint(latitude, longitude), amplitude + "km"));
        List<Starbus> starbuses = elasticsearchTemplate.queryForList(geoLocationCriteriaQuery, Starbus.class);

        return starbuses;
    }


}
