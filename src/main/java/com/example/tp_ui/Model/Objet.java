package com.example.tp_ui.Model;

import java.util.ArrayList;

public class Objet extends Achetable{

    public void augPrixCl(){
        prix = prix + (750 * (0.4 * getNiv()));
    }

    public void augPrixPr(){
        prix = prix + (580 * (0.6 * getNiv()));
    }

    public Objet(String nom, String desc, int niv, double prix, double effet){
        this.nom = nom;
        this.desc = desc;
        this.niv = niv;
        this.prix = prix;
        this.effetLvl = effet;
    }


    @Override
    public void addNiv(){
        setPrix(12);
        augPrixCl();
        setChanged();
        notifyObservers(-prix);
    }



}
