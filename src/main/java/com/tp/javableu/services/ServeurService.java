package com.tp.javableu.services;

import com.tp.javableu.model.Serveur;
import com.tp.javableu.repositories.ServeurRepository;
import com.tp.javableu.services.Interface.IServeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServeurService implements IServeurService {

    @Autowired
    private ServeurRepository serveurRepository;

    @Override
    public ArrayList<Serveur> getAllServeur() {
        return (ArrayList<Serveur>) serveurRepository.findAll();
    }

    @Override
    public Serveur getServeur(Integer serveurId) {
        return serveurRepository.findOne(serveurId);
    }
}
