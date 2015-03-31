package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by raphael on 31/03/2015.
 */

@Document(indexName = "jeminstalle", type = "nucleaire", shards = 1, replicas = 0, refreshInterval = "-1")
public class Nucleaire {

    @Id
    private String id;
    private String libelledepartement;
    private String nbcentrale;
    private String numdep;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelledepartement() {
        return libelledepartement;
    }

    public void setLibelledepartement(String libelledepartement) {
        this.libelledepartement = libelledepartement;
    }

    public String getNbcentrale() {
        return nbcentrale;
    }

    public void setNbcentrale(String nbcentrale) {
        this.nbcentrale = nbcentrale;
    }

    public String getNumdep() {
        return numdep;
    }

    public void setNumdep(String numdep) {
        this.numdep = numdep;
    }
}
