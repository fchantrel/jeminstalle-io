package io.jeminstalle.dao;

import io.jeminstalle.domain.Starbus;

import java.util.List;

import com.codahale.metrics.annotation.Timed;

public interface StarbusDAO {

	@Timed
    List<Starbus> findByLatitudeAndLongitude(double latitude, double longitude, String amplitude);

}
