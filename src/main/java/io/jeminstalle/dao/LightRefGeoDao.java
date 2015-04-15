package io.jeminstalle.dao;

import io.jeminstalle.domain.LightRefGeo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.codahale.metrics.annotation.Timed;

import java.util.List;

/**
 * Created by fchantrel on 31/03/2015.
 */
public interface LightRefGeoDao extends ElasticsearchRepository<LightRefGeo, String> {

    // FIXME : réussir à faire un size=1 (top et first ne fonctionnent pas)
	@Timed
    List<LightRefGeo> findByInseecode(String name);
    
    // FIXME : réussir à faire un size=1 (top et first ne fonctionnent pas)
	@Timed
	List<LightRefGeo> findByName(String name);

	@Timed
    List<LightRefGeo> findByLatitudeAndLongitude(float latitude, float longitude);
    
}
