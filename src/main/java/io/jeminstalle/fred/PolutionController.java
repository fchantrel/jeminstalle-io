package io.jeminstalle.fred;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.jeminstalle.dao.PollutionDAO;
import io.jeminstalle.domain.Pollution;

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
	private PollutionDAO repository;
	
    /**
     * Recupere tous les Polution.
     *
     * @return the all Polution
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Pollution> getAllLieux() {
    	
    	System.out.println("Polutions found with findAll():");
    	System.out.println("-------------------------------");
    	for (Pollution pollution : this.repository.findAll()) {
    	System.out.println(pollution);
    	}
    	System.out.println();
    	
    	List<Pollution> retour = new ArrayList<Pollution>();
    	retour.add(new Pollution());
    	
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
