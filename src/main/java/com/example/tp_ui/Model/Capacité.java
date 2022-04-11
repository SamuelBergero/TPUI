package com.example.tp_ui.Model;

public class Capacité extends Achetable {

    public void augPrixC(){
        prix = prix++;
    }

    public Capacité(String nom, int niv, double prix, double effet){
        this.nom = nom;
        this.desc = desc;
        this.niv = niv;
        this.prix = prix;
        this.effetLvl = effet;
    }

    @Override
    public void addNiv(){
        niv++;
        setChanged();
        notifyObservers(-prix);
        augPrixC();
    }


}
