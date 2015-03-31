package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "jeminstalle", type = "polution", shards = 1, replicas = 0, refreshInterval = "-1")
public class Pollution {

    @Id
    private String id;

    private String classement;

    private String nodepartement;

    private String libelledepartement;

    private Long nbsitespolues;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassement() {
        return classement;
    }

    public void setClassement(String classement) {
        this.classement = classement;
    }

    public String getNodepartement() {
        return nodepartement;
    }

    public void setNodepartement(String nodepartement) {
        this.nodepartement = nodepartement;
    }

    public String getLibelledepartement() {
        return libelledepartement;
    }

    public void setLibelledepartement(String libelledepartement) {
        this.libelledepartement = libelledepartement;
    }

    public Long getNbsitespolues() {
        return nbsitespolues;
    }

    public void setNbsitespolues(Long nbsitespolues) {
        this.nbsitespolues = nbsitespolues;
    }
}