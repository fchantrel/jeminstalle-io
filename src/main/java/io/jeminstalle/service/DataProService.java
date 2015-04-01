package io.jeminstalle.service;

import io.jeminstalle.domain.DataPro;

/**
 * Created by fchantrel on 31/03/2015.
 */
public interface DataProService {

    DataPro getDataPro(String activite, String ou);
    
    DataPro getDataProByRegion(String activite, String ou);
    
    DataPro getDataProByDepartement(String activite, String ou);
    
    DataPro getDataProByCommune(String activite, String ou);
}