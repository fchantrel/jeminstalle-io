package io.jeminstalle.dao;

import io.jeminstalle.domain.Precipitation;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.codahale.metrics.annotation.Timed;

public interface PrecipitationDAO extends ElasticsearchRepository<Precipitation, String> {

	@Timed
    Precipitation findByNodepartement(String nodepartement);

}
