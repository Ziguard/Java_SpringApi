package com.tp.javableu.services;

import com.tp.javableu.services.Interface.IHelloService;
import org.springframework.stereotype.Service;


@Service
public class HelloService implements IHelloService {

    @Override
    public String hello() {
        return "helloWorld";
    }
}
