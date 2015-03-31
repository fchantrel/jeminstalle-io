package io.jeminstalle.service.impl;

import io.jeminstalle.dao.PolutionDAO;
import io.jeminstalle.dao.RefGeoDao;
import io.jeminstalle.domain.DataParticulier;
import io.jeminstalle.domain.Pollution;
import io.jeminstalle.domain.RefGeo;
import io.jeminstalle.service.DataParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by raphael on 31/03/2015.
 */
@Service
public class DataParticulierServiceImpl implements DataParticulierService {

    @Autowired
    private RefGeoDao refGeoDao;

    @Autowired
    private PolutionDAO polutionDAO;


    @Override
    public DataParticulier getDataParticulierByName(String name) {

        DataParticulier dp = new DataParticulier();

        RefGeo refGeo = refGeoDao.findByName(name).get(0);

        String departement = refGeo.getZipcode().substring(0, 2);

        // FIXME
        //Pollution pollution = polutionDAO.findByNodepartement(departement).get(0);

        Pollution pollution = new Pollution();
        pollution.setId("yqLHtOr5TMOlstMYDLCs7g");
        pollution.setNodepartement("35");
        pollution.setClassement("29");
        pollution.setLibelledepartement("Ille-et-Vilaine");
        pollution.setNbsitespolues(12L);


        dp.setRefGeo(refGeo);
        dp.setPollution(pollution);


        return dp;
    }
}
