package io.jeminstalle.dao;

import io.jeminstalle.domain.Nucleaire;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.codahale.metrics.annotation.Timed;

public interface NucleaireDAO extends ElasticsearchRepository<Nucleaire, String> {

	@Timed
    Nucleaire findByNumdep(String numdepœ);

}
