package com.tp.javableu.services;

import com.tp.javableu.model.Contenu;
import com.tp.javableu.model.Serveur;
import com.tp.javableu.model.ServeurData;
import com.tp.javableu.services.Interface.IServeurDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServeurDataService implements IServeurDataService {

    @Autowired
    ContenuService contenuService;
    @Autowired
    ServeurService serveurService;

    @Override
    public ServeurData getServeurDataById(Integer serveurId) {
        Serveur serveur = serveurService.getServeur(serveurId);

        ServeurData serveurData = new ServeurData();
        ArrayList<Contenu> cpus = new ArrayList<>();

        for (int i = 0 ; i<= 8; i++ ){
            String search = "cpu"+i;
            Contenu cpu = GetContenuString(serveur , search);
            if (cpu != null)
            {
                cpus.add(cpu);
            }
        }

        serveurData.setCpus(cpus);
        serveurData.setDate(GetContenuString(serveur ,"humantime"));
        serveurData.setMemoryDisk(GetContenuString(serveur ,"memory size"));
        serveurData.setTrafic(GetContenuString(serveur ,"trafic"));
        serveurData.setSecurityError(GetContenuString(serveur , "security error"));

        return serveurData;
    }

    private Contenu GetContenuString(Serveur serveur, String stringSearch){
        return serveur.getListeColonne().stream().filter(x -> x.getNomCol().contains(stringSearch)).findFirst().orElse(null);
    }
}
