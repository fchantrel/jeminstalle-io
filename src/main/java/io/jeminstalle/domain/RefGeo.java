package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by raphael on 31/03/2015.
 */
@Document(indexName = "jeminstalle_io_geo", type = "ref_geo")
public class RefGeo {

    private Date timestamp;
    private float density;
    private String idGeoZone;
    private String identifiant;
    private String inseeCode;
    private float latitude;
    private float longitude;

    @Id
    private String name;

    private String nomCommune;

    private String nomVoie;
    private String numeroVoie;
    private String normalizedTitle;
    private String title;
    private int population;
    private float surface;
    private String zipCode;
    private String zoneType;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public String getIdGeoZone() {
        return idGeoZone;
    }

    public void setIdGeoZone(String idGeoZone) {
        this.idGeoZone = idGeoZone;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getInseeCode() {
        return inseeCode;
    }

    public void setInseeCode(String inseeCode) {
        this.inseeCode = inseeCode;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getNumeroVoie() {
        return numeroVoie;
    }

    public void setNumeroVoie(String numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public String getNormalizedTitle() {
        return normalizedTitle;
    }

    public void setNormalizedTitle(String normalizedTitle) {
        this.normalizedTitle = normalizedTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "RefGeo{" +
                "timestamp=" + timestamp +
                ", density=" + density +
                ", idGeoZone='" + idGeoZone + '\'' +
                ", identifiant='" + identifiant + '\'' +
                ", inseeCode='" + inseeCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                ", nomCommune='" + nomCommune + '\'' +
                ", nomVoie='" + nomVoie + '\'' +
                ", numeroVoie='" + numeroVoie + '\'' +
                ", normalizedTitle='" + normalizedTitle + '\'' +
                ", title='" + title + '\'' +
                ", population=" + population +
                ", surface=" + surface +
                ", zipCode='" + zipCode + '\'' +
                ", zoneType='" + zoneType + '\'' +
                '}';
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }
}
