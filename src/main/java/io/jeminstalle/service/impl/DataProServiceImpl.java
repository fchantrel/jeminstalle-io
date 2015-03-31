package io.jeminstalle.service.impl;

import io.jeminstalle.dao.*;
import io.jeminstalle.domain.*;
import io.jeminstalle.service.DataProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fchantrel on 31/03/2015.
 */
@Service
public class DataProServiceImpl implements DataProService {

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
    public DataPro getDataPro(String activite, String ou) {

        DataPro dp = new DataPro();

        RefGeo refGeo = refGeoDao.findByName(ou).get(0);
        
        dp.setPopulation(refGeo.getPopulation());
        dp.setActivite(activite);
        dp.setOu(ou);
        dp.setNbPro(10);
        dp.setRatio(1.123);
        
        /**
        String departement = refGeo.getZipcode().substring(0, 2);
        Pollution pollution = pollutionDAO.findByNodepartement(departement).get(0);
        Couverture4G couverture4G = couverture4GDAO.findByCodedepartement(departement);
        Ensoleillement ensoleillement = ensoleillementDAO.findByNodepartement(departement);
        RevenuMoyen revenuMoyen = revenuMoyenDAO.findByNomcommune(ou).get(0);
        Precipitation precipitation = precipitationDAO.findByNodepartement(departement);
        Nucleaire nucleaire = nucleaireDAO.findByNumdep(departement);
*/

        //proDAO.findByCoordonneesAndRubrique(String.valueOf(refGeo.getLatitude()), String.valueOf(refGeo.getLongitude()), "restaurant");

        return dp;
    }
}
