package com.example.tp_ui.Model;

import Observateur.Observateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class Joueur implements Observateur {
    private int point = 0;


    public int getPoint(){return point;}
    public void setPoint(int point){this.point = point;}

    public Joueur(){}
    public Joueur(int point)
    {
        this.point = point;
    }

    public void addPoint(int change){point += change;}

    @Override
    public void update(Object arg)
    {
        int i = Integer.parseInt(arg.toString());
        addPoint(i);
    }
}
