package com.example.tp_ui.Model;

public class Capacité extends Achetable {

    public void augPrixCl(){
        prix = prix + (750 * (0.4 * getNiv()));
    }

    public Capacité(String nom, String desc, int niv, double prix, double effet){
        this.nom = nom;
        this.desc = desc;
        this.niv = niv;
        this.prix = prix;
        this.effetLvl = effet;
    }

    @Override
    public void addNiv(){
        niv++;
        augPrixCl();
        setChanged();
        notifyObservers(-prix);
    }


}
