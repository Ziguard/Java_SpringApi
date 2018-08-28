package com.tp.javableu.controllers;

import com.tp.javableu.services.Interface.ISaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveController {

    @Autowired
    private ISaveService saveService;

    @RequestMapping(value ="save")
    private void save()
    {
        saveService.save();
    }
}
