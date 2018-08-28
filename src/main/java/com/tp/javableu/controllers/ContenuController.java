package com.tp.javableu.controllers;

import com.tp.javableu.model.Contenu;
import com.tp.javableu.services.Interface.IContenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ContenuController {
    @Autowired
    private IContenuService contenuService;

    @RequestMapping(value = "/contenu/{id}", method = GET)
    @ResponseBody
    public Contenu getContenu(@PathVariable(value="id")Integer contenuId)
    {
        return contenuService.getContenu(contenuId);
    }

    @RequestMapping(value = "/contenu")
    @ResponseBody
    public List<Contenu> getAllContenu()
    {
        return contenuService.getAllContenu();
    }

    @RequestMapping(value = "/cpu/{id}",method = GET)
    @ResponseBody
    public Contenu getCpus(@PathVariable(value = "id") Integer serveurId){
        return contenuService.getContenuCpu(serveurId);
    }
}
