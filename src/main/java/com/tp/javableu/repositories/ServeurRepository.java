package com.tp.javableu.repositories;

import com.tp.javableu.model.Serveur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServeurRepository extends CrudRepository <Serveur,Integer> {
}
