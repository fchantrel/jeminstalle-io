package io.jeminstalle.dao;

public interface ProDAO {

    String findByCoordonneesAndRubrique(String latitude, String longitude, String rubrique, String distanceKM, String maxResultat);

    int findByRegionAndActivite(String region, String activite, String maxResultat);
    
    int findByDepartementAndActivite(String region, String activite, String maxResultat);
    
    int findByCommuneAndActivite(String region, String activite, String maxResultat);
}
