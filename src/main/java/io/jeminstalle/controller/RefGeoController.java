package io.jeminstalle.controller;

import io.jeminstalle.domain.LightRefGeo;
import io.jeminstalle.service.RefGeoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("RefGeoController")
@RequestMapping(value = "/refgeo")
public class RefGeoController {

    @Autowired
    private RefGeoService refGeoService;


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public LightRefGeo getRefGeoByName(@PathVariable("name") String name) {
        return refGeoService.getRefGeoByName(name);
    }

}
