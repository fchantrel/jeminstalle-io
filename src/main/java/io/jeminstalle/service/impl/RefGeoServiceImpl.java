package io.jeminstalle.service.impl;

import io.jeminstalle.dao.RefGeoDao;
import io.jeminstalle.domain.RefGeo;
import io.jeminstalle.service.RefGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class RefGeoServiceImpl implements RefGeoService {

    @Autowired
    private RefGeoDao refGeoDao;

    @Override
    public RefGeo getRefGeoByName(String name) {
        return refGeoDao.findByName(name).get(0);
    }
}
