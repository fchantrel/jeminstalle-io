package io.jeminstalle.dao;

import com.codahale.metrics.annotation.Timed;

public interface ProDAO {

	@Timed
    String findByCoordonneesAndRubrique(String latitude, String longitude, String rubrique, String distanceKM, String maxResultat);

	@Timed
    int findByRegionAndActivite(String region, String activite, String maxResultat);
    
	@Timed
    int findByDepartementAndActivite(String region, String activite, String maxResultat);
    
	@Timed
    int findByCommuneAndActivite(String region, String activite, String maxResultat);
}
