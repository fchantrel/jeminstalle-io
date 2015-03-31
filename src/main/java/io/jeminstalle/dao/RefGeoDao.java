package io.jeminstalle.dao;

import io.jeminstalle.domain.RefGeo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by raphael on 31/03/2015.
 */
public interface RefGeoDao extends ElasticsearchRepository<RefGeo, String> {

    List<RefGeo> findByName(String name);

}
