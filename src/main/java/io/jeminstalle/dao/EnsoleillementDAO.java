package io.jeminstalle.dao;

import io.jeminstalle.domain.Ensoleillement;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.codahale.metrics.annotation.Timed;

public interface EnsoleillementDAO extends ElasticsearchRepository<Ensoleillement, String> {

	@Timed
    Ensoleillement findByNodepartement(String nodepartement);

}
