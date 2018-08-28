package com.tp.javableu.services.Interface;

import com.tp.javableu.model.Contenu;
import com.tp.javableu.model.Serveur;

import java.util.List;

public interface IContenuService {

    Contenu getContenu(Integer idContenu);

    Contenu getContenuCpu(Integer idServeur);

    Contenu getContenuByServeurAndNomColLike(Serveur serveur , String nomCol);

    List<Contenu> getAllContenu();
}
