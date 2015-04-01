package io.jeminstalle.domain;

/**
 * Created by fchantrel on 31/03/2015.
 */
public class DataPro {
	
	private double  ratio;
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	public int getNbPro() {
		return nbPro;
	}
	public void setNbPro(int nbPro) {
		this.nbPro = nbPro;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	public String getOu() {
		return ou;
	}
	public void setOu(String ou) {
		this.ou = ou;
	}
	private int nbPro;
	private int population;
	private String activite;
	private String ou;
	

}
