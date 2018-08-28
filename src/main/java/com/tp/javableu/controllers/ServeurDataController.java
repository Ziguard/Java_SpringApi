package com.tp.javableu.controllers;

import com.tp.javableu.model.ServeurData;
import com.tp.javableu.services.Interface.IServeurDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ServeurDataController {

    @Autowired
    private IServeurDataService serveurDataService;

    @RequestMapping(value="/serveurdata/{id}",method = GET)
    @ResponseBody
    public ServeurData getServeurData(@PathVariable(value ="id") Integer serveurId){
        ServeurData result =  serveurDataService.getServeurDataById(serveurId);
        return result;
    }
}
