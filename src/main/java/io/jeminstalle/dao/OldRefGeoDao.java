package io.jeminstalle.dao;

import io.jeminstalle.domain.OldRefGeo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by raphael on 31/03/2015.
 */
public interface OldRefGeoDao extends ElasticsearchRepository<OldRefGeo, String> {

    // FIXME : réussir à faire un size=1 (top et first ne fonctionnent pas)
    List<OldRefGeo> findByName(String name);

    List<OldRefGeo> findByLatitudeAndLongitude(float latitude, float longitude);

}
