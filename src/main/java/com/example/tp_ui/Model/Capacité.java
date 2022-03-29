package com.example.tp_ui.Model;

public class Capacité extends Achetable {

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


}
