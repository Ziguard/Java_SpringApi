package com.tp.javableu.controllers;

import com.tp.javableu.model.Serveur;
import com.tp.javableu.services.Interface.IServeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ServeurController {

    @Autowired
    private IServeurService serveurService;

    @RequestMapping(value = "/serveur/{id}", method = GET)
    @ResponseBody
    public Serveur getServeur(@PathVariable(value="id")Integer serveurId)
    {
        return serveurService.getServeur(serveurId);
    }

    @RequestMapping(value = "serveurs")
    public  List<Serveur> getServeurs()
    {
        return serveurService.getAllServeur();
    }
}
