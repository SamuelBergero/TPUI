package com.example.tp_ui.Model;

public class Objet extends Achetable{

    public void augPrixCl(){
        prix = prix + (750 * (0.4 * getNiv()));
    }


    public Objet(String nom,int niv, double prix, double effet){
        this.nom = nom;
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
