package io.jeminstalle.dao;

import io.jeminstalle.domain.Pollution;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.codahale.metrics.annotation.Timed;

import java.util.List;

public interface PollutionDAO extends ElasticsearchRepository<Pollution, String> {

	@Timed
    List<Pollution> findByNodepartement(String nodepartement);

}
