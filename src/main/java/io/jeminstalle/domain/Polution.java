package io.jeminstalle.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "jeminstalle", type = "polution", shards = 1, replicas = 0, refreshInterval = "-1")
public class Polution {
	
	@Id
	private String classement;
	
	@JsonProperty("no_departement")
	private String noDepartement;
	@JsonProperty("libelle_departement")
	private String libelleDepartement;
	@JsonProperty("nb_sites_polues")
	private Long nbSitesPolues;
	
	public String getClassement() {
		return classement;
	}

	public void setClassement(String classement) {
		this.classement = classement;
	}

	
	public Polution() {
	}

	public Polution(String classement, String no_departement, String libelle_departement, Long nb_sites_polues) {
		this.classement = classement;
		this.noDepartement = no_departement;
		this.libelleDepartement = libelle_departement;
		this.nbSitesPolues = nb_sites_polues;
	}


	@Override
	public String toString() {
		return String.format("Polution[classement=%s, no_departement='%s', libelle_departement='%s']",
				this.classement, this.noDepartement, this.libelleDepartement);
	}
}