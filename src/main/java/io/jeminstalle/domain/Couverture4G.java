package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by raphael on 31/03/2015.
 */
@Document(indexName = "jeminstalle", type = "couverture_4g", shards = 1, replicas = 0, refreshInterval = "-1")
public class Couverture4G {

    @Id
    private String id;

    private String codedepartement;
    private String coderegion;

    private String couvbouygues;
    private String couvorange;
    private String couvfree;
    private String couvsfr;


    private String surfbouygues;
    private String surforange;
    private String surffree;
    private String surfsfr;


    public String getCodedepartement() {
        return codedepartement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCodedepartement(String codedepartement) {
        this.codedepartement = codedepartement;
    }

    public String getCoderegion() {
        return coderegion;
    }

    public void setCoderegion(String coderegion) {
        this.coderegion = coderegion;
    }

    public String getCouvbouygues() {
        return couvbouygues;
    }

    public void setCouvbouygues(String couvbouygues) {
        this.couvbouygues = couvbouygues;
    }

    public String getCouvorange() {
        return couvorange;
    }

    public void setCouvorange(String couvorange) {
        this.couvorange = couvorange;
    }

    public String getCouvfree() {
        return couvfree;
    }

    public void setCouvfree(String couvfree) {
        this.couvfree = couvfree;
    }

    public String getCouvsfr() {
        return couvsfr;
    }

    public void setCouvsfr(String couvsfr) {
        this.couvsfr = couvsfr;
    }

    public String getSurfbouygues() {
        return surfbouygues;
    }

    public void setSurfbouygues(String surfbouygues) {
        this.surfbouygues = surfbouygues;
    }

    public String getSurforange() {
        return surforange;
    }

    public void setSurforange(String surforange) {
        this.surforange = surforange;
    }

    public String getSurffree() {
        return surffree;
    }

    public void setSurffree(String surffree) {
        this.surffree = surffree;
    }

    public String getSurfsfr() {
        return surfsfr;
    }

    public void setSurfsfr(String surfsfr) {
        this.surfsfr = surfsfr;
    }
}
