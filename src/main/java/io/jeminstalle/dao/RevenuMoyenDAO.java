package io.jeminstalle.dao;

import io.jeminstalle.domain.RevenuMoyen;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.codahale.metrics.annotation.Timed;

import java.util.List;

public interface RevenuMoyenDAO extends ElasticsearchRepository<RevenuMoyen, String> {

	@Timed
    List<RevenuMoyen> findByNomcommune(String nomcommune);

}
