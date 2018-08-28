package com.tp.javableu.repositories;

import com.tp.javableu.model.Contenu;
import com.tp.javableu.model.Serveur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ContenuRepository extends CrudRepository<Contenu,Integer> {

    ArrayList<Contenu> findByServeur(Serveur serveur);

    Contenu findByServeurAndNomCol(Serveur serveur, String nomCol);

    Contenu findByServeurAndNomColLike(Serveur serveur, String nomcol);
}
