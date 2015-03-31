package io.jeminstalle.service.impl;

import io.jeminstalle.dao.RefGeoDao;
import io.jeminstalle.domain.RefGeo;
import io.jeminstalle.service.RefGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class RefGeoServiceImpl implements RefGeoService {

    @Autowired
    private RefGeoDao refGeoDao;

    @Override
    public List<RefGeo> getRefGeoByName(String name) {

        List<RefGeo> refGeo = refGeoDao.findByName(name);
        return refGeo;
    }
}
