package io.jeminstalle.dao;

import io.jeminstalle.domain.Ensoleillement;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EnsoleillementDAO extends ElasticsearchRepository<Ensoleillement, String> {

    Ensoleillement findByNodepartement(String nodepartement);

}
