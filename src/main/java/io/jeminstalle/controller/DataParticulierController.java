package io.jeminstalle.controller;

import io.jeminstalle.domain.Lieu;
import io.jeminstalle.service.LieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Classe DataParticulierController.
 */
@RestController("DataParticulierController")
@RequestMapping(value = "/dataparticulier")
public class DataParticulierController {

    /**
     * le service LieuService.
     */
    @Autowired
    private LieuService LieuService;

    /**
     * Recupere tous les Lieux.
     *
     * @return the all Lieux
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Lieu> getAllLieux() {
        return LieuService.getAllLieux();
    }

    /**
     * Recupere un Lieu par son id.
     *
     * @param id the id
     * @return the Lieu by id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Lieu getLieuById(@PathVariable("id") Long id) {
        return LieuService.getLieuById(id);
    }

    /**
     * Recherche texte de Lieu de type ville.
     *
     * @param nomVille
     * @return the collection
     */
    @RequestMapping(value = "/ville/{nom}", method = RequestMethod.GET)
    public Collection<Lieu> findLieuxByNom(@PathVariable("nom") String nomVille) {
    	//LieuService.getLieuById(id)
        return LieuService.findLieuxByNom(nomVille);
    }

    /**
     * Ajoute un Lieu.
     *
     * @param Lieu the Lieu
     * @return the Lieu
     */
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public Lieu addLieu(@RequestBody Lieu Lieu) {
        return LieuService.addLieu(Lieu);
    }

    /**
     * Supprime un Lieu.
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
     * Gets LieuService.
     *
     * @return the Lieu service
     */
    public LieuService getLieuService() {
        return LieuService;
    }

    /**
     * Sets LieuService.
     *
     * @param LieuService the new Lieu service
     */
    public void setLieuService(LieuService LieuService) {
        this.LieuService = LieuService;
    }

}
