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
    public RefGeo getRefGeoByName(String name) {

        // FIXME : on ne retourne que les references qui ont un zipcode
        List<RefGeo> refGeoList = refGeoDao.findByName(name);

        for (RefGeo refGeo : refGeoList) {
            if (refGeo.getZipcode() != null) {
                return refGeo;
            }
        }

        // FIXME
        RefGeo rg = refGeoList.get(0);
        rg.setZipcode("75000");
        return rg;
    }
}
