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

    public Label Pioche;
    public Label descriptionPioche;
    public Label prixPioche;
    public Label niveauPioche;

    Magasin magasinObjet = new Magasin("objet");
    Joueur j = new Joueur();

    @FXML
    private Label Test;
    private Scene scene ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    j.setPoint(0);
    }

    public JeuController()
    {
        Capacité q = new Capacité();
        q.setNom("but");
        magasinObjet.AddItem(q);
        for (Achetable a: magasinObjet.GetItems())
        {
            a.addObserver(j);
        }

        Objet pioche = new Objet();
        pioche.setNom("but");
        pioche.setDescription("+ vitesse");
        pioche.setPrix(3000);
        pioche.setNiveau(1);
        magasinObjet.AddItem(pioche);
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
        int point = j.getPoint();
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
