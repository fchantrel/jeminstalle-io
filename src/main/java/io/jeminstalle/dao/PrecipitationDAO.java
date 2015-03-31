package io.jeminstalle.dao;

import io.jeminstalle.domain.Precipitation;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PrecipitationDAO extends ElasticsearchRepository<Precipitation, String> {

    Precipitation findByNodepartement(String nodepartement);

}
