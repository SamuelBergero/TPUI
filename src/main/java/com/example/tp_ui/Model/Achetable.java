package com.example.tp_ui.Model;

import java.util.Observable;

public abstract class Achetable extends Observable {
<<<<<<< HEAD
    double prix;
=======
    int prix;
>>>>>>> Kev-Objets
    String nom;
    int niv = 0;
    double effetLvl;

    public double getPrix(){return prix;}

    public int getNiv(){return niv;}
    public void setNiv(int niv){this.niv=niv;}

    public String getNom(){return nom;}

    public double getEffet(){return niv * effetLvl;}

    public void addNiv()
    {
        niv++;
        setChanged();
        notifyObservers(-prix);
    }
}
