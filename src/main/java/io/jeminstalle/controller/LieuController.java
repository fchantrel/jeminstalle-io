package io.jeminstalle.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jeminstalle.domain.Lieu;
import io.jeminstalle.service.LieuService;

/**
 * The Class LieuController.
 */
@RestController("LieuController")
@RequestMapping(value = "/lieux")
public class LieuController {

	/** The Lieu service. */
	@Autowired
	private LieuService LieuService;
	
	/**
	 * Gets the all Lieux.
	 *
	 * @return the all Lieux
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Lieu> getAllLieux() {
		return LieuService.getAllLieux();
	}
	
	/**
	 * Gets the Lieu by id.
	 *
	 * @param id the id
	 * @return the Lieu by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Lieu getLieuById(@PathVariable("id") Long id) {
		return LieuService.getLieuById(id);
	}
	
	/**
	 * Find Lieux by nom de ville.
	 *
	 * @param nomVille 
	 * @return the collection
	 */
	@RequestMapping(value = "/ville/{nom}", method = RequestMethod.GET)
	public Collection<Lieu> findLieuxByNom(@PathVariable("nom") String nomVille) {
		return LieuService.findLieuxByNom(nomVille);
	}
	
	/**
	 * Adds the Lieu.
	 *
	 * @param Lieu the Lieu
	 * @return the Lieu
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
	public Lieu addLieu(@RequestBody Lieu Lieu) {
		return LieuService.addLieu(Lieu);
	}

	/**
	 * Delete Lieu.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteLieu(@PathVariable("id") Long id) {
		
		LieuService.deleteLieu(id);
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Lieu updateLieu(@PathVariable("id") Long id, @RequestBody Lieu Lieu) {
		
		return LieuService.updateLieu(id, Lieu);
	}
	

	/**
	 * Gets the Lieu service.
	 *
	 * @return the Lieu service
	 */
	public LieuService getLieuService() {
		return LieuService;
	}

	/**
	 * Sets the Lieu service.
	 *
	 * @param LieuService the new Lieu service
	 */
	public void setLieuService(LieuService LieuService) {
		this.LieuService = LieuService;
	}
	
}
