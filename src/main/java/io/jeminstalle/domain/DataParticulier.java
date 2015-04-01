package io.jeminstalle.domain;

import java.util.ArrayList;
import java.util.List;

public class DataParticulier {

    private RefGeo refGeo;
    private Pollution pollution;
    private Couverture4G couverture4G;
    private RevenuMoyen revenuMoyen;
    private Precipitation precipitation;
    private Nucleaire nucleaire;
    private Ensoleillement ensoleillement;

    private List<Transport> transports = new ArrayList<>();

    private String boulangeries;
    private String pharmacies;
    private String ecoles;
    private String bars;


    public Ensoleillement getEnsoleillement() {
        return ensoleillement;
    }

    public void setEnsoleillement(Ensoleillement ensoleillement) {
        this.ensoleillement = ensoleillement;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    public String getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(String pharmacies) {
        this.pharmacies = pharmacies;
    }

    public String getEcoles() {
        return ecoles;
    }

    public void setEcoles(String ecoles) {
        this.ecoles = ecoles;
    }

    public String getBars() {
        return bars;
    }

    public void setBars(String bars) {
        this.bars = bars;
    }

    public String getBoulangeries() {
        return boulangeries;
    }

    public void setBoulangeries(String boulangeries) {
        this.boulangeries = boulangeries;
    }

    public RefGeo getRefGeo() {
        return refGeo;
    }

    public void setRefGeo(RefGeo refGeo) {
        this.refGeo = refGeo;
    }

    public Pollution getPollution() {
        return pollution;
    }

    public void setPollution(Pollution pollution) {
        this.pollution = pollution;
    }


    public Couverture4G getCouverture4G() {
        return couverture4G;
    }

    public void setCouverture4G(Couverture4G couverture4G) {
        this.couverture4G = couverture4G;
    }

    public RevenuMoyen getRevenuMoyen() {
        return revenuMoyen;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    public Nucleaire getNucleaire() {
        return nucleaire;
    }

    public void setNucleaire(Nucleaire nucleaire) {
        this.nucleaire = nucleaire;
    }

    public void setRevenuMoyen(RevenuMoyen revenuMoyen) {
        this.revenuMoyen = revenuMoyen;
    }

}
