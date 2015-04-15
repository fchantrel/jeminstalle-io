package io.jeminstalle.dao;

import io.jeminstalle.domain.Couverture4G;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.codahale.metrics.annotation.Timed;

public interface Couverture4GDAO extends ElasticsearchRepository<Couverture4G, String> {

	@Timed
    Couverture4G findByCodedepartement(String codedepartement);

}
