package io.jeminstalle.service.impl;

import io.jeminstalle.dao.RefGeoDao;
import io.jeminstalle.domain.RefGeo;
import io.jeminstalle.service.RefGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class RefGeoServiceImpl implements RefGeoService {

    @Autowired
    private RefGeoDao refGeoDao;

    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public RefGeo getRefGeoByCommuneName(String communeName) {

//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(matchAllQuery())
//                .withFilter(boolFilter().must(termFilter("id", documentId)))
//                .build();


        RefGeo refGeo = refGeoDao.findByNomCommune(communeName);

        System.out.println(refGeo);


        return refGeo;
    }
}
