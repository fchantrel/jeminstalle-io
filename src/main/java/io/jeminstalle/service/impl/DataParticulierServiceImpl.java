package io.jeminstalle.service.impl;

import io.jeminstalle.dao.*;
import io.jeminstalle.domain.*;
import io.jeminstalle.service.DataParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Autowired
    private ProDAO proDAO;

    @Override
    public DataParticulier getDataParticulierByName(String name) {

        DataParticulier dp = new DataParticulier();

        RefGeo refGeo = refGeoDao.findByName(name).get(0);

        String departement = refGeo.getZipcode().substring(0, 2);
        Pollution pollution = pollutionDAO.findByNodepartement(departement).get(0);
        Couverture4G couverture4G = couverture4GDAO.findByCodedepartement(departement);
        Ensoleillement ensoleillement = ensoleillementDAO.findByNodepartement(departement);
        RevenuMoyen revenuMoyen = revenuMoyenDAO.findByNomcommune(name).get(0);
        Precipitation precipitation = precipitationDAO.findByNodepartement(departement);
        Nucleaire nucleaire = nucleaireDAO.findByNumdep(departement);


        proDAO.findByCoordonneesAndRubrique(String.valueOf(refGeo.getLatitude()), String.valueOf(refGeo.getLongitude()), "restaurant");


        // FIXME
        List<Pro> boulangeries = dp.getBoulangeries();
        Pro p1 = new Pro();
        p1.setDenomination("super boulangerie");
        p1.setEpj("5697348734");
        p1.setLatitude("48.124723");
        p1.setLongitude("-1.689444");
        boulangeries.add(p1);


        List<Pro> pharmacies = dp.getPharmacies();
        Pro p2 = new Pro();
        p2.setDenomination("super pharmacie");
        p2.setEpj("3385767");
        p2.setLatitude("48.224723");
        p2.setLongitude("-1.789444");
        pharmacies.add(p2);


        List<Pro> ecoles = dp.getEcoles();
        Pro p3 = new Pro();
        p3.setDenomination("super pharmacie");
        p3.setEpj("338995767");
        p3.setLatitude("48.324723");
        p3.setLongitude("-1.689444");
        ecoles.add(p3);


        List<Pro> bars = dp.getBars();
        Pro p4 = new Pro();
        p4.setDenomination("super bar");
        p4.setEpj("111222");
        p4.setLatitude("48.324723");
        p4.setLongitude("-1.889444");
        bars.add(p4);


        //////

        dp.setRefGeo(refGeo);
        dp.setPollution(pollution);
        dp.setCouverture4G(couverture4G);
        dp.setRevenuMoyen(revenuMoyen);
        dp.setPrecipitation(precipitation);
        dp.setNucleaire(nucleaire);

        return dp;
    }
}
