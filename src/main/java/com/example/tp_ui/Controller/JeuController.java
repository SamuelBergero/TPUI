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

        Objet Pioche = new Objet("Pioche", "Une pioche", 1, 50, (50*2));
        magasinObjet.AddItem(Pioche);


        /*Objet Perceuse = new Objet();
        Perceuse.setNom("but");
        Perceuse.setDescription("x3 vitesse");
        Perceuse.setPrix(3000);
        magasinObjet.AddItem(Perceuse);

        Objet Nain = new Objet();
        Nain.setNom("but");
        Nain.setDescription("x5 vitesse");
        Nain.setPrix(5000);
        magasinObjet.AddItem(Nain);

        Objet Foreuse = new Objet();
        Foreuse.setNom("but");
        Foreuse.setDescription("x10 vitesse");
        Foreuse.setPrix(10000);
        magasinObjet.AddItem(Foreuse);*/

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
