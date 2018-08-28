package com.tp.javableu.services.Interface;

import com.tp.javableu.model.Serveur;

import java.util.ArrayList;
import java.util.List;

public interface IServeurService {

    ArrayList<Serveur> getAllServeur();

    Serveur getServeur(Integer serveurId);
}
