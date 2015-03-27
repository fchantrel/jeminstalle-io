package io.jeminstalle.service;

import java.util.Collection;

import io.jeminstalle.domain.Lieu;

/**
 * The Interface LieuService.
 */
public interface LieuService {
	
	/**
	 * Recupere tous les Lieux.
	 *
	 * @return all Lieux
	 */
	public Collection<Lieu> getAllLieux();
	
	/**
	 * Recupere un Lieu par son id.
	 *
	 * @param id the id
	 * @return the book by id
	 */
	public Lieu getLieuById(Long id);
	
	/**
	 * Recupere des Lieux par un nom.
	 *
	 * @param nom le nom du lieu
	 * @return the collection of Lieux found
	 */
	public Collection<Lieu> findLieuxByNom(String nom);
	
	/**
	 * Ajoute le lieu.
	 *
	 * @param newLieu the new lieu
	 * @return the lieu added
	 */
	public Lieu addLieu(Lieu newLieu);
	
	/**
	 * Supprime un lieu.
	 *
	 * @param lieuId the lieu id
	 */
	public void deleteLieu(Long lieuId);
	
	/**
	 * Update du lieu.
	 *
	 * @param updatedLieu the updated lieu
	 * @return the lieu
	 */
	public Lieu updateLieu(Long lieuId, Lieu updatedLieu);

}
