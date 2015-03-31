package io.jeminstalle.dao;

public interface ProDAO {

    String findByCoordonneesAndRubrique(String latitude, String longitude, String rubrique, String distanceKM, String maxResultat);

}
