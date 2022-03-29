package com.example.tp_ui.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class Joueur implements Observer {
    private int point = 0;


    public int getPoint(){return point;}
    public void setPoint(int point){this.point = point;}

    public Joueur(){}
    public Joueur(int point)
    {
        this.point = point;
    }

    public void addPoint(float change){point += change;}

    @Override
    public void update(Observable o, Object arg)
    {
        float i = Float.parseFloat(arg.toString());
        addPoint(i);
    }
}
