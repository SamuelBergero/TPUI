package com.example.tp_ui.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class Joueur implements Observer {
    private double point = 0;


    public double getPoint(){return point;}
    public void setPoint(int point){this.point = point;}

    public Joueur(){}
    public Joueur(double point)
    {
        this.point = point;
    }

    public void addPoint(double change){point += change;}

    @Override
    public void update(Observable o, Object arg)
    {
        double i = Double.parseDouble(arg.toString());
        addPoint(i);
    }
}
