package io.jeminstalle.service;

import java.util.Collection;

import io.jeminstalle.domain.Lieu;

/**
 * The Interface LieuService.
 */
public interface LieuService {
	
	/**
	 * Gets all Lieux.
	 *
	 * @return all Lieux
	 */
	public Collection<Lieu> getAllLieux();
	
	/**
	 * Gets the book by id.
	 *
	 * @param id the id
	 * @return the book by id
	 */
	public Lieu getLieuById(Long id);
	
	/**
	 * Find Lieux by nom.
	 *
	 * @param nom le nom de la ville
	 * @return the collection of Lieux found
	 */
	public Collection<Lieu> findLieuxByNom(String nom);
	
	/**
	 * Adds the lieu.
	 *
	 * @param newLieu the new lieu
	 * @return the lieu added
	 */
	public Lieu addLieu(Lieu newLieu);
	
	/**
	 * Delete lieu.
	 *
	 * @param lieuId the lieu id
	 */
	public void deleteLieu(Long lieuId);
	
	/**
	 * Update lieu.
	 *
	 * @param updatedLieu the updated lieu
	 * @return the lieu
	 */
	public Lieu updateLieu(Long lieuId, Lieu updatedLieu);

}
