package com.tp.javableu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.catalina.Server;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CONTENU")
public class Contenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;

    @Column(name = "NomCol")
    private String nomCol;

    @Column(name ="NomColBis")
    private String nomColBis;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "serveur_id")
    private Serveur serveur;


    @OneToMany(mappedBy = "contenu")
    private List<Data> listeValue;

    @Transient
    private int indexColonne;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCol() {
        return nomCol;
    }

    public void setNomCol(String nomCol) {
        this.nomCol = nomCol;
    }

    public String getNomColBis() {
        return nomColBis;
    }

    public void setNomColBis(String nomColBis) {
        this.nomColBis = nomColBis;
    }

    public List<Data> getListeValue() {
        return listeValue;
    }

    public void setListeValue(List<Data> listeValue) {
        this.listeValue = listeValue;
    }


    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public int getIndexColonne() {
        return indexColonne;
    }

    public void setIndexColonne(int indexColonne) {
        this.indexColonne = indexColonne;
    }
}
