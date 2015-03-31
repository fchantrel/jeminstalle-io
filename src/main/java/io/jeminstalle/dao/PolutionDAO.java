package io.jeminstalle.dao;

import io.jeminstalle.domain.Pollution;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PolutionDAO extends ElasticsearchRepository<Pollution, String> {

    List<Pollution> findByNodepartement(String nodepartement);

}
