package com.tp.javableu.model;

import java.util.ArrayList;

public class ServeurData {


    private Contenu date;

    private Contenu securityError;

    private ArrayList<Contenu> cpus;

    private Contenu trafic;

    private Contenu memoryDisk;

    public Contenu getDate() {
        return date;
    }

    public void setDate(Contenu date) {
        this.date = date;
    }

    public Contenu getSecurityError() {
        return securityError;
    }

    public void setSecurityError(Contenu securityError) {
        this.securityError = securityError;
    }

    public ArrayList<Contenu> getCpus() {
        return cpus;
    }

    public void setCpus(ArrayList<Contenu> cpus) {
        this.cpus = cpus;
    }

    public Contenu getTrafic() {
        return trafic;
    }

    public void setTrafic(Contenu trafic) {
        this.trafic = trafic;
    }

    public Contenu getMemoryDisk() {
        return memoryDisk;
    }

    public void setMemoryDisk(Contenu memoryDisk) {
        this.memoryDisk = memoryDisk;
    }

}
