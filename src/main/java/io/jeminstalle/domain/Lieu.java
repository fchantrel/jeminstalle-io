package io.jeminstalle.domain;

/**
 * Classe Lieu.
 *
 * @author fchantrel
 */
public class Lieu {
	
	/** The id. */
	private Long id;
	
	/** The libelle. */
	private String libelle;
	
	/** The commentaire. */
	private String commentaire;
	
	/** The superficie. */
	private Integer superficie;
	
	/**
	 * Instantiates a new Lieu.
	 */
	public Lieu() {
	}
	
	/**
	 * Instantiates a new Lieu with arguments.
	 *
	 * @param id the Lieu id
	 * @param libelle le libelle du Lieu
	 * @param commentaire le commentaire du Lieu
	 * @param superficie la superficie du Lieu
	 */
	public Lieu(Long id, String libelle, String commentaire, Integer superficie) {
		this.id = id;
		this.libelle = libelle;
		this.commentaire = commentaire;
		this.superficie = superficie;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the libelle.
	 *
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 *
	 * @param libelle the new libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the comentaire.
	 *
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Sets the commentaire.
	 *
	 * @param commentaire the new commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * Gets the superficie.
	 *
	 * @return the superficie
	 */
	public Integer getSuperficie() {
		return superficie;
	}

	/**
	 * Sets the superficie.
	 *
	 * @param superficie the new superficie
	 */
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}

	
}
