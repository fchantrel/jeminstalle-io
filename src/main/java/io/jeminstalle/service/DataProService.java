package io.jeminstalle.service;

import io.jeminstalle.domain.DataPro;

/**
 * Created by fchantrel on 31/03/2015.
 */
public interface DataProService {

    DataPro getDataPro(String activite, String ou);
}