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


    public Label piocheLabel;
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



    }

    public JeuController()
    {

        Capacité Leadership = new Capacité("Leadership", 0, 1, 15);
        magasinObjet.AddItem(Leadership);
        Capacité Competence = new Capacité("Competence", 0, 5, 60);
        magasinObjet.AddItem(Competence);
        Capacité Forage = new Capacité("Forage", 0, 8, 95);
        magasinObjet.AddItem(Forage);
        Capacité Recolte = new Capacité("Recolte", 0, 10,5);
        magasinObjet.AddItem(Recolte);

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
