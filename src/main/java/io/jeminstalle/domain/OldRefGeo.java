package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by raphael on 31/03/2015.
 */
@Document(indexName = "jeminstalle_io_geo", type = "ref_geo")
public class OldRefGeo {

    private String timestamp;
    @Id
    private String id_geozone;
    private String name;
    private String zone_type;
    private String zipcode;
    private int population;
    private float density;
    private float latitude;
    private float longitude;
    private String inseecode;
    private float surface;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getId_geozone() {
        return id_geozone;
    }

    public void setId_geozone(String id_geozone) {
        this.id_geozone = id_geozone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZone_type() {
        return zone_type;
    }

    public void setZone_type(String zone_type) {
        this.zone_type = zone_type;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getInseecode() {
        return inseecode;
    }

    public void setInseecode(String inseecode) {
        this.inseecode = inseecode;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }
}
