package io.jeminstalle.controller;

import io.jeminstalle.domain.DataParticulier;
import io.jeminstalle.service.DataParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("DataParticulierController")
@RequestMapping(value = "/dataparticulier")
public class DataParticulierController {

    @Autowired
    private DataParticulierService dataParticulierService;

    @RequestMapping(value = "/ville/{nom}", method = RequestMethod.GET)
    public DataParticulier findDataByNom(@PathVariable("nom") String nom) {
        return dataParticulierService.getDataParticulierByName(nom);
    }

    @RequestMapping(value = "/position", method = RequestMethod.GET)
    public DataParticulier findDataByPosition(@RequestParam(value = "latitude") String latitude,
                                              @RequestParam(value = "longitude") String longitude) {
        return dataParticulierService.getDataParticulierByPosition(latitude, longitude);
    }


}
