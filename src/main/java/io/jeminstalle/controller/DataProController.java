package io.jeminstalle.controller;

import io.jeminstalle.domain.DataPro;
import io.jeminstalle.service.DataProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fchantrel on 31/03/2015.
 */
@RestController("DataProController")
@RequestMapping(value = "/datapro")
public class DataProController {

    @Autowired
    private DataProService dataProService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataPro findData(@RequestParam("activite") String activite, @RequestParam("ou") String ou) {
        return dataProService.getDataPro(activite, ou);
    }


}
