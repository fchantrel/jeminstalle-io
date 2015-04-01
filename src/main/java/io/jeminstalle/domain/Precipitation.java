package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by raphael on 31/03/2015.
 */

@Document(indexName = "jeminstalle", type = "precipitation", shards = 1, replicas = 0, refreshInterval = "-1")
public class Precipitation {

    @Id
    private String id;
    private String classement;
    private String precipitation; // en metre cube pour le departement
    private String libelledepartement;
    private String nodepartement;


    public void convertirEnMm() {
        double metreCubeEauParKMMetreCarreSurface = Double.valueOf(precipitation) / 5000; // surface moyenne departement
        double metreCubeEauParMetreCarre = metreCubeEauParKMMetreCarreSurface / (1000 * 1000);
        double litreEauParMetreCarre = metreCubeEauParMetreCarre * 1000;
        precipitation = String.valueOf(litreEauParMetreCarre);
    }

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

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
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
