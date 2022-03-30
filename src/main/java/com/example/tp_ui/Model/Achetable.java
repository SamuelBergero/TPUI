package com.example.tp_ui.Model;

import java.util.Observable;

public abstract class Achetable extends Observable {
    double prix;
    String nom,desc;
    int niv = 0;
    double effetLvl;

    public double getPrix(){return prix;}
    public void setPrix(int prix){this.prix=prix;}

    public int getNiv(){return niv;}
    public void setNiv(int niv){this.niv=niv;}

    public String getNom(){return nom;}
    public void setNom(String nom){this.nom = nom;}

    public String getDescription() {return desc;}
    public void setDescription(String description) {desc = description;}

    public double getEffet(){return niv * effetLvl;}
    public void addNiv()
    {
        niv++;
        setChanged();
        notifyObservers(-prix);
    }
}
