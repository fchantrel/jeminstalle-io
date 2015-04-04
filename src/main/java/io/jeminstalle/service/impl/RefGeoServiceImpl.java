package io.jeminstalle.service.impl;

import io.jeminstalle.dao.LightRefGeoDao;
import io.jeminstalle.domain.LightRefGeo;
import io.jeminstalle.service.RefGeoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class RefGeoServiceImpl implements RefGeoService {

    @Autowired
    private LightRefGeoDao refGeoDao;

    @Override
    public LightRefGeo getRefGeoByName(String name) {

        // FIXME : on ne retourne que les references qui ont un zipcode
        List<LightRefGeo> refGeoList = refGeoDao.findByName(name);

        for (LightRefGeo refGeo : refGeoList) {
            if (refGeo.getZipcode() != null) {
                return refGeo;
            }
        }

        // FIXME
        LightRefGeo rg = refGeoList.get(0);
        rg.setZipcode("75000");
        return rg;
    }
}
