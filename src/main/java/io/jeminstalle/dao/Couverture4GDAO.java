package io.jeminstalle.dao;

import io.jeminstalle.domain.Couverture4G;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface Couverture4GDAO extends ElasticsearchRepository<Couverture4G, String> {

    Couverture4G findByCodedepartement(String codedepartement);

}
