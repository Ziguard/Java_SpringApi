package com.tp.javableu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SERVEUR")
public class Serveur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="serveurName")
    private String fileName;

    @Column(name="path")
    private String filePath;

    @JsonIgnore
    @OneToMany(mappedBy = "serveur", fetch = FetchType.LAZY)
    private List<Contenu> listeColonne;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<Contenu> getListeColonne() {
        return listeColonne;
    }

    public void setListeColonne(List<Contenu> listeColonne) {
        this.listeColonne = listeColonne;
    }
}
