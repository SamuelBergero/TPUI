package com.example.tp_ui.Model;

public class Capacité extends Achetable {

<<<<<<< HEAD
    public void augPrixC(){
        prix += prix;
    }

    public Capacité(String nom, int niv, double prix, double effet){
        this.nom = nom;
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

=======
//    //public void augPrixCl(){
//        prix = (int) (prix + (750 * (0.4 * getNiv())));
//    }
//
//    public void augPrixPr(){
//        prix = (int) (prix + (580 * (0.6 * getNiv())));
//    }
//
//    @Override
//    public void addNiv(){
//        setPrix(12);
//        augPrixCl();
//        setChanged();
//        notifyObservers(-prix);
//    }
//
>>>>>>> Kev-Objets

}
