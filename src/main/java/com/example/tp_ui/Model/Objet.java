package com.example.tp_ui.Model;

import javafx.fxml.FXML;

import java.util.ArrayList;

public class Objet extends Achetable{

    double Prix;
    int Niveau;

    ArrayList TabObjets = new ArrayList<>();


    public void augPrixCl(){
        prix = prix + (750 * (0.4 * getNiv()));
    }

    public void augPrixPr(){
        prix = prix + (580 * (0.6 * getNiv()));
    }

    @Override
    public void addNiv(){
        setPrix(12);
        augPrixCl();
        setChanged();
        notifyObservers(-prix);
    }

    @Override
    public double getPrix() {
        return Prix;
    }

    public void setPrix(double prix) {
        Prix = prix;
    }

    public int getNiveau() {
        return Niveau;
    }

    public void setNiveau(int niveau) {
        Niveau = niveau;
    }



}
