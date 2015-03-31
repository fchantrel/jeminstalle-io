package io.jeminstalle.service;

import io.jeminstalle.domain.RefGeo;

import java.util.List;

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
    public List<RefGeo> getRefGeoByName(String communeName);


}
