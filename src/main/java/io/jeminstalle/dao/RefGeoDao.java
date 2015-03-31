package io.jeminstalle.dao;

import io.jeminstalle.domain.RefGeo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by raphael on 31/03/2015.
 */
public interface RefGeoDao extends ElasticsearchRepository<RefGeo, String> {

    RefGeo findByNomCommune(String name);

}
