package com.example.tp_ui.Model;

public class Objet extends Achetable{

    public void augPrixCl(){
        if (niv <=1){
       prix +=getEffet() +2;}
        else{
            prix +=getEffet();
        }
    }

//    public void augPrixPr(){
//        prix = prix + (580 * (0.6 * getNiv()));
//    }

    public Objet(String nom,int niv, int prix, double effet){
        this.nom = nom;
        this.niv = niv;
        this.prix = prix;
        this.effetLvl = effet;
    }


    @Override
    public void addNiv(){
        setChanged();
        notifyObservers(-prix);
        augPrixCl();
        setNiv(niv +1);
    }



}
