package com.tp.javableu.services;

import com.tp.javableu.model.Contenu;
import com.tp.javableu.model.Serveur;
import com.tp.javableu.repositories.ContenuRepository;
import com.tp.javableu.repositories.ServeurRepository;
import com.tp.javableu.services.Interface.IContenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContenuService implements IContenuService {

    @Autowired
    ContenuRepository contenuRepository;
    @Autowired
    ServeurService serveurService;

    @Override
    public Contenu getContenu(Integer idColunm) {
        return contenuRepository.findOne(idColunm);
    }

    @Override
    public ArrayList<Contenu> getAllContenu() {
        return (ArrayList<Contenu>) contenuRepository.findAll();
    }

    @Override
    public Contenu getContenuCpu(Integer serveurId){
        String nomCol = "CPU";
        Serveur serveur = serveurService.getServeur(serveurId);
        return  contenuRepository.findByServeurAndNomColLike(serveur, nomCol );
    }

    @Override
    public Contenu getContenuByServeurAndNomColLike(Serveur serveur , String nomCol){
        return contenuRepository.findByServeurAndNomColLike(serveur , nomCol);
    }

    public void setContenuColBisByServeur(Serveur serveur ,String nomCol , String nomColBis ) {
        Contenu contenu = contenuRepository.findByServeurAndNomColLike(serveur , nomCol);

    }
}
