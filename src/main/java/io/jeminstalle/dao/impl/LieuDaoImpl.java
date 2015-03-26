package io.jeminstalle.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.jeminstalle.dao.LieuDao;
import io.jeminstalle.domain.Lieu;

/**
 * The Class LieuDaoImpl.
 */
@Repository("LieuDao")
public class LieuDaoImpl implements LieuDao {

	/** The library. */
	private List<Lieu> library;
	
	/**
	 * Instantiates a new Lieu dao impl.
	 */
	public LieuDaoImpl() {
		this.library = new ArrayList<>();
		
		this.library.add(new Lieu(new Long(1), "Rennes", "jolie ville", 10000));
		this.library.add(new Lieu(new Long(2), "Chantepie", "pas loin", 3000));
		this.library.add(new Lieu(new Long(3), "Nantes", "les pas bretons", 5000));
		this.library.add(new Lieu(new Long(4), "Paris", "the capitale", 50000));
		this.library.add(new Lieu(new Long(5), "Bordeaux", "bien quand il fait beau", 5000));
		
	}
	
	/* (non-Javadoc)
	 * @see io.jeminstalle.dao.LieuDao#getAllLieux()
	 */
	@Override
	public Collection<Lieu> getAllLieux() {
		return this.library;
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.dao.LieuDao#getLieuById(java.lang.Long)
	 */
	@Override
	public Lieu getLieuById(Long id) {
		
		for (Lieu Lieu : this.library) {
			
			if (Lieu.getId().equals(id)) {
				return Lieu;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.dao.LieuDao#findLieuxByName(java.lang.String)
	 */
	@Override
	public Collection<Lieu> findLieuxByNom(String nom) {
		
		Collection<Lieu> result = new ArrayList<>();
		
		for (Lieu Lieu : this.library) {
			
			//TODO: put in lowercase
			if (Lieu.getLibelle().equals(nom)) {
				result.add(Lieu);
			}
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.dao.LieuDao#addLieu(io.jeminstalle.domain.Lieu)
	 */
	@Override
	public Lieu addLieu(Lieu newLieu) {
		
		this.library.add(newLieu);
		
		return newLieu;
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.dao.LieuDao#deleteLieu(java.lang.Long)
	 */
	@Override
	public void deleteLieu(Long LieuId) {
		
		Lieu LieuToDelete = this.getLieuById(LieuId);
		
		this.library.remove(LieuToDelete);
	}

	/* (non-Javadoc)
	 * @see io.jeminstalle.dao.LieuDao#updateLieu(io.jeminstalle.domain.Lieu)
	 */
	@Override
	public Lieu updateLieu(Long LieuId, Lieu updatedLieu) {
		
		for (Lieu Lieu : this.library) {
			
			if (Lieu.getId().equals(LieuId)) {
				
				int LieuIndex = this.library.indexOf(Lieu);
				
				this.library.set(LieuIndex, updatedLieu);
				
				return updatedLieu;
			}
		}
		
		return null;
	}
	
	

}
