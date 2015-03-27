package io.jeminstalle.dao;

import java.util.Collection;

import io.jeminstalle.domain.Lieu;

/**
 * Interface LieuDao.
 */
public interface LieuDao {
	
	/**
	 * Recupere les Lieux.
	 *
	 * @return all Lieux
	 */
	public Collection<Lieu> getAllLieux();
	
	/**
	 * Recupere un Lieu par son id.
	 *
	 * @param id the id
	 * @return the Lieu by id
	 */
	public Lieu getLieuById(Long id);
	
	/**
	 * Recupere un Lieu par son nom.
	 *
	 * @param nom the nom
	 * @return the collection of Lieux found
	 */
	public Collection<Lieu> findLieuxByNom(String nom);
	
	/**
	 * Ajoute un Lieu.
	 *
	 * @param newLieu the new Lieu
	 * @return the Lieu added
	 */
	public Lieu addLieu(Lieu newLieu);
	
	/**
	 * Supprime un Lieu.
	 *
	 * @param LieuId the Lieu id
	 */
	public void deleteLieu(Long LieuId);
	
	/**
	 * Update Lieu.
	 *
	 * @param updatedLieu the updated Lieu
	 * @return the Lieu
	 */
	public Lieu updateLieu(Long LieuId, Lieu updatedLieu);

}
