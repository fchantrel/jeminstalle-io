package io.jeminstalle.dao;

import io.jeminstalle.domain.Starbus;

import java.util.List;

public interface StarbusDAO {

    List<Starbus> findByLatitudeAndLongitude(double latitude, double longitude, String amplitude);

}
