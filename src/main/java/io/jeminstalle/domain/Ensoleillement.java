package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by raphael on 31/03/2015.
 */

@Document(indexName = "jeminstalle", type = "ensoleillement", shards = 1, replicas = 0, refreshInterval = "-1")
public class Ensoleillement {

    @Id
    private String id;
    private String classement;
    private String ensoleillement;
    private String libelledepartement;
    private String nodepartement;

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

    public String getEnsoleillement() {
        return ensoleillement;
    }

    public void setEnsoleillement(String ensoleillement) {
        this.ensoleillement = ensoleillement;
    }

    public String getLibelledepartement() {
        return libelledepartement;
    }

    public void setLibelledepartement(String libelledepartement) {
        this.libelledepartement = libelledepartement;
    }

    public String getNodepartement() {
        return nodepartement;
    }

    public void setNodepartement(String nodepartement) {
        this.nodepartement = nodepartement;
    }
}
