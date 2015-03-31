package io.jeminstalle.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProDAO {

    String findByCoordonneesAndRubrique(String latitude, String longitude, String rubrique);

}
