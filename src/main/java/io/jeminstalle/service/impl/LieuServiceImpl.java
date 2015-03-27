package io.jeminstalle.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jeminstalle.dao.LieuDao;
import io.jeminstalle.domain.Lieu;
import io.jeminstalle.service.LieuService;

/**
 * Classe LieuServiceImpl.
 */
@Service("lieuService")
public class LieuServiceImpl implements LieuService {
	
	/** The Lieu dao. */
	@Autowired
	private LieuDao lieuDao;

	/* (non-Javadoc)
	 * @see io.jeminstalle.service.LieuService#getAllLieux()
	 */
	@Override
	public Collection<Lieu> getAllLieux() {
		return lieuDao.getAllLieux();
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.service.LieuService#getLieuById(java.lang.Long)
	 */
	@Override
	public Lieu getLieuById(Long id) {
		return lieuDao.getLieuById(id);
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.service.LieuService#findLieuxByNom(java.lang.String)
	 */
	@Override
	public Collection<Lieu> findLieuxByNom(String nom) {
		return lieuDao.findLieuxByNom(nom);
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.service.LieuService#addLieu(io.jeminstalle.domain.Lieu)
	 */
	@Override
	public Lieu addLieu(Lieu newLieu) {
		return lieuDao.addLieu(newLieu);
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.service.LieuService#deleteLieu(java.lang.Long)
	 */
	@Override
	public void deleteLieu(Long lieuId) {
		lieuDao.deleteLieu(lieuId);
	}
	
	/* (non-Javadoc)
	 * @see io.jeminstalle.service.LieuService#updateLieu(io.jeminstalle.domain.Lieu)
	 */
	@Override
	public Lieu updateLieu(Long lieuId, Lieu updatedLieu) {
		return lieuDao.updateLieu(lieuId, updatedLieu);
	}

	/**
	 * Gets the Lieu dao.
	 *
	 * @return the Lieu dao
	 */
	public LieuDao getLieuDao() {
		return lieuDao;
	}

	/**
	 * Sets the Lieu dao.
	 *
	 * @param LieuDao the new Lieu dao
	 */
	public void setLieuDao(LieuDao lieuDao) {
		this.lieuDao = lieuDao;
	}

}
