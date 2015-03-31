package io.jeminstalle.service;

import io.jeminstalle.domain.RefGeo;

/**
 * The Interface RefGeoService.
 */
public interface RefGeoService {

    /**
     * Recupère la ref geo par nom de commune.
     *
     * @param communeName le nom de la commune
     * @return la ref geo
     */
    public RefGeo getRefGeoByCommuneName(String communeName);


}
