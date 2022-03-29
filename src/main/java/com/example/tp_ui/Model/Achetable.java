package com.example.tp_ui.Model;

import java.util.Observable;

public abstract class Achetable extends Observable {
    double prix = 2;
    String nom;
    int niv = 1;
    boolean typeEffet;
    double effet;

    public double getPrix(){return prix;}
    public void setPrix(int prix){this.prix=prix;}

    public int getNiv(){return niv;}
    public void setNiv(int niv){this.niv=niv;}

    public String getNom(){return nom;}
    public void setNom(String nom){this.nom = nom;}

    public void addNiv()
    {
        niv++;
        setChanged();
        notifyObservers(-prix);
    }
}
