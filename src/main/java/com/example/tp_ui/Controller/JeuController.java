package com.example.tp_ui.Controller;

import com.example.tp_ui.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class JeuController implements Initializable
{


    public Label prixPioche;
    public Label niveauPioche;
    public Label prixPerceuse;
    public Label niveauPerceuse;
    public Label prixNain;
    public Label niveauNain;
    public Label prixForeuse;
    public Label niveauForeuse;

    Magasin magasinObjet = new Magasin("objet");
    Joueur j = new Joueur();

    @FXML
    private Label Test;
    private Scene scene ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Objet Pioche =new Objet("Pioche", 1,50,2);
        magasinObjet.AddItem(Pioche);
        magasinObjet.AddItem(new Objet("Perceuse",1,100,4));
        magasinObjet.AddItem(new Objet("Nain", 1,250,8));
        magasinObjet.AddItem(new Objet("Foreuse", 1,500,12));
        for (Achetable a: magasinObjet.GetItems())
        {
            a.addObserver(j);
        }
//        String nomTemporaire;
//        scene = prixPioche.getScene();
//        Label label;
//
//        for (Achetable a: magasinObjet.GetItems()) {
//
//            nomTemporaire = "#prix"+a.getNom();
//            label = (Label) scene.lookup(nomTemporaire);
//            label.setText("Prix : " + a.getPrix());
//
//            nomTemporaire = "#niveau"+a.getNom();
//            label = (Label) scene.lookup(nomTemporaire);
//            label.setText("Niveau : " + a.getNiv());
//        }
    }

    public JeuController()
    {
        Objet Pioche =new Objet("Pioche", 1,50,2);
        magasinObjet.AddItem(Pioche);
        magasinObjet.AddItem(new Objet("Perceuse",1,100,4));
        magasinObjet.AddItem(new Objet("Nain", 1,250,8));
        magasinObjet.AddItem(new Objet("Foreuse", 1,500,12));
        for (Achetable a: magasinObjet.GetItems())
        {
            a.addObserver(j);
        }

    }

    @FXML
    private void achat(ActionEvent event) {
        scene = Test.getScene();
        Node node = (Node) event.getSource() ;
        String data = (String) node.getUserData();

        Achetable a = magasinObjet.GetItem(data);

        a.addNiv();
        updatePoint();
    }

    public void updatePoint(){
        scene = Test.getScene();
        Test.setText("Point: " + j.getPoint());

        double point = j.getPoint();
        String p;

        for (Achetable a: magasinObjet.GetItems())
        {
            if(a.getPrix() > point)
            {
                try {
                    p = "#" + a.getNom() + "Achat";
                    Button button = (Button) scene.lookup(p);
                    button.setDisable(true);
                }catch(Exception e){
                }
            }

        }

    }



}
