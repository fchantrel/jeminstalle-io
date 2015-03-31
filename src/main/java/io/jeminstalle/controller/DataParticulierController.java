package io.jeminstalle.controller;

import io.jeminstalle.domain.DataParticulier;
import io.jeminstalle.service.DataParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("DataParticulierController")
@RequestMapping(value = "/dataparticulier")
public class DataParticulierController {

    @Autowired
    private DataParticulierService dataParticulierService;

    @RequestMapping(value = "/ville/{nom}", method = RequestMethod.GET)
    public DataParticulier findDataByNom(@PathVariable("nom") String nom) {
        return dataParticulierService.getDataParticulierByName(nom);
    }


}
