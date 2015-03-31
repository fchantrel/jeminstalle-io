package io.jeminstalle.service.impl;

import io.jeminstalle.dao.*;
import io.jeminstalle.domain.*;
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
    private PollutionDAO pollutionDAO;

    @Autowired
    private Couverture4GDAO couverture4GDAO;

    @Autowired
    private EnsoleillementDAO ensoleillementDAO;

    @Autowired
    private RevenuMoyenDAO revenuMoyenDAO;

    @Autowired
    private PrecipitationDAO precipitationDAO;

    @Autowired
    private NucleaireDAO nucleaireDAO;


    @Override
    public DataParticulier getDataParticulierByName(String name) {

        DataParticulier dp = new DataParticulier();

        RefGeo refGeo = refGeoDao.findByName(name).get(0);

        String departement = refGeo.getZipcode().substring(0, 2);
        Pollution pollution = pollutionDAO.findByNodepartement(departement).get(0);
        Couverture4G couverture4G = couverture4GDAO.findByCodedepartement(departement);
        Ensoleillement ensoleillement = ensoleillementDAO.findByNodepartement(departement);
        RevenuMoyen revenuMoyen = revenuMoyenDAO.findByNomcommune(name);
        Precipitation precipitation = precipitationDAO.findByNodepartement(departement);
        Nucleaire nucleaire = nucleaireDAO.findByNumdep(departement);

        dp.setRefGeo(refGeo);
        dp.setPollution(pollution);
        dp.setCouverture4G(couverture4G);
        dp.setRevenuMoyen(revenuMoyen);
        dp.setPrecipitation(precipitation);
        dp.setNucleaire(nucleaire);

        return dp;
    }
}
