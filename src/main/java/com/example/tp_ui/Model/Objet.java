package com.example.tp_ui.Model;

public class Objet extends Achetable{

    public void augPrixCl(){
       prix = (getPrix() * getNiv());
    }

//    public void augPrixPr(){
//        prix = prix + (580 * (0.6 * getNiv()));
//    }

    public Objet(String nom,int niv, double prix, double effet){
        this.nom = nom;
        this.niv = niv;
        this.prix = prix;
        this.effetLvl = effet;
    }


    @Override
    public void addNiv(){
        setPrix((int) getPrix());
        setNiv(niv +1);
        augPrixCl();
        setChanged();
        notifyObservers(-prix);
    }



}
