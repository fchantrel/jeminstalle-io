package io.jeminstalle.dao;

import io.jeminstalle.domain.RevenuMoyen;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RevenuMoyenDAO extends ElasticsearchRepository<RevenuMoyen, String> {

    RevenuMoyen findByNomcommune(String nomcommune);

}
