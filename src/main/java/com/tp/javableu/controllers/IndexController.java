package com.tp.javableu.controllers;

import com.tp.javableu.services.Interface.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping(value = "index")
    public String index()
    {
        return helloService.hello();
    }
}
