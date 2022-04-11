package com.example.tp_ui.Controller;

import com.example.tp_ui.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class JeuController implements Initializable
{

    @FXML
    public Label titreObjet;
    @FXML
    public Label orJoueur;
    @FXML
    public Label orJoueurChiffre;
    Magasin magasinObjet = new Magasin("objet");
    Joueur j = new Joueur();

    @FXML
    private Label Test;
    private Scene scene ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        j.setPoint(1000);
        orJoueurChiffre.setText("" + j.getPoint());
        titreObjet.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        orJoueur.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 14));
        //Attente
        // orJoueurChiffre.setText();


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
        scene = orJoueur.getScene();
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();


        Achetable a = magasinObjet.GetItem(data);
        a.addNiv();
        updatePoint();
        String prix = "#prix" + data ;
        Label labelprix = (Label) scene.lookup(prix);
        labelprix.setText(a.getPrix() + " Or");

        String prixc = "#prixc" + data ;
        Label labelprixc = (Label) scene.lookup(prixc);
        labelprixc.setText(a.getPrix() + " points");

        String niv = "#niveau" + data ;
        Label labelniv = (Label) scene.lookup(niv);
        labelniv.setText(a.getNiv() + "");


        String eff = "#effet" + data ;
        Label labeleff = (Label) scene.lookup(eff);
        labeleff.setText("Effet: +"+a.getEffet() + "/click");
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
