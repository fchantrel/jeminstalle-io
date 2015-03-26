package io.jeminstalle.dao;

import java.util.Collection;

import io.jeminstalle.domain.Lieu;

/**
 * The Interface LieuDao.
 */
public interface LieuDao {
	
	/**
	 * Gets all Lieux.
	 *
	 * @return all Lieux
	 */
	public Collection<Lieu> getAllLieux();
	
	/**
	 * Gets the Lieu by id.
	 *
	 * @param id the id
	 * @return the Lieu by id
	 */
	public Lieu getLieuById(Long id);
	
	/**
	 * Find Lieux by nom.
	 *
	 * @param author the author
	 * @return the collection of Lieux found
	 */
	public Collection<Lieu> findLieuxByNom(String author);
	
	/**
	 * Adds the Lieu.
	 *
	 * @param newLieu the new Lieu
	 * @return the Lieu added
	 */
	public Lieu addLieu(Lieu newLieu);
	
	/**
	 * Delete Lieu.
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
