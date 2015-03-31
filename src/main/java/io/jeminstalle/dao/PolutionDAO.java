package io.jeminstalle.dao;

import io.jeminstalle.domain.Polution;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PolutionDAO extends
		ElasticsearchRepository<Polution, String> {
	public List<Polution> findByNoDepartement(String noDepartement);
}
