package io.jeminstalle.dao;

import io.jeminstalle.domain.RevenuMoyen;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface RevenuMoyenDAO extends ElasticsearchRepository<RevenuMoyen, String> {

    List<RevenuMoyen> findByNomcommune(String nomcommune);

}
