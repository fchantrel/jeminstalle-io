package io.jeminstalle.controller;

import io.jeminstalle.domain.DataParticulier;
import io.jeminstalle.service.DataParticulierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;


@RestController("DataParticulierController")
@RequestMapping(value = "/dataparticulier")
public class DataParticulierController {

    @Autowired
    private DataParticulierService dataParticulierService;

    @RequestMapping(value = "/ville/{nom}", method = RequestMethod.GET)
    @Timed
    public DataParticulier findDataByNom(@PathVariable("nom") String nom) {
        return dataParticulierService.getDataParticulierByName(nom);
    }

    @RequestMapping(value = "/position", method = RequestMethod.GET)
    @Timed
    public DataParticulier findDataByPosition(@RequestParam(value = "latitude") String latitude,
                                              @RequestParam(value = "longitude") String longitude) {
        return dataParticulierService.getDataParticulierByPosition(latitude, longitude);
    }


}
