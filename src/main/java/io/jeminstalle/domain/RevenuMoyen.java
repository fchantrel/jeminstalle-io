package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by raphael on 31/03/2015.
 */

@Document(indexName = "jeminstalle", type = "revenu_moyen", shards = 1, replicas = 0, refreshInterval = "-1")
public class RevenuMoyen {

    @Id
    private String id;
    private String classement;
    private String codeinsee;
    private String nomcommune;
    private String revenu;

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

    public String getCodeinsee() {
        return codeinsee;
    }

    public void setCodeinsee(String codeinsee) {
        this.codeinsee = codeinsee;
    }

    public String getNomcommune() {
        return nomcommune;
    }

    public void setNomcommune(String nomcommune) {
        this.nomcommune = nomcommune;
    }

    public String getRevenu() {
        return revenu;
    }

    public void setRevenu(String revenu) {
        this.revenu = revenu;
    }
}
