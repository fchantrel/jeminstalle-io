package io.jeminstalle.dao;

import io.jeminstalle.domain.LightRefGeo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by fchantrel on 31/03/2015.
 */
public interface LightRefGeoDao extends ElasticsearchRepository<LightRefGeo, String> {

    // FIXME : réussir à faire un size=1 (top et first ne fonctionnent pas)
    List<LightRefGeo> findByInseecode(String name);
    
}
