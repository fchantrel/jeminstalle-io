package io.jeminstalle.dao;

import io.jeminstalle.domain.Nucleaire;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NucleaireDAO extends ElasticsearchRepository<Nucleaire, String> {

    Nucleaire findByNumdep(String numdepœ);

}
