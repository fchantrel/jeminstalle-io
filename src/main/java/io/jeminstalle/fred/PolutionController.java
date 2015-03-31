package io.jeminstalle.fred;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.jeminstalle.dao.PolutionDAO;
import io.jeminstalle.domain.Polution;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe PolutionController.
 */
@RestController("PolutionController")
@RequestMapping(value = "/polutions")
public class PolutionController {

	@Autowired
	private PolutionDAO repository;
	
    /**
     * Recupere tous les Polution.
     *
     * @return the all Polution
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Polution> getAllLieux() {
    	
    	System.out.println("Polutions found with findAll():");
    	System.out.println("-------------------------------");
    	for (Polution polution : this.repository.findAll()) {
    	System.out.println(polution);
    	}
    	System.out.println();
    	
    	List<Polution> retour = new ArrayList<Polution>();
    	retour.add(new Polution());
    	
    	return retour;
    }

    /**
     * Recupere un Lieu par son id.
     *
     * @param id the id
     * @return the Lieu by id
     */
    /**
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Polution getLieuById(@PathVariable("id") Long id) {
    	
        return LieuService.getLieuById(id);
    }*/

}
