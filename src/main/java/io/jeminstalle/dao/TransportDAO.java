package io.jeminstalle.dao;

import io.jeminstalle.domain.Transport;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TransportDAO extends ElasticsearchRepository<Transport, String> {

    List<Transport> findByLatitudeAndLongitude(float latitude, float longitude);

}
