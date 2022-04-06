package com.example.tp_ui.Controller;

import com.example.tp_ui.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JeuController implements Initializable {

    @FXML
    public Label titreObjet;
    @FXML
    public Label orJoueur;
    @FXML
    public Label orJoueurChiffre;
    Magasin magasinObjet = new Magasin("objet");
    Magasin magasinCapacite = new Magasin("capacite");
    Joueur j = new Joueur();
    Joueur b = new Joueur();

    @FXML
    private Label Test;
    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        j.setPoint(1000);
        orJoueurChiffre.setText("" + j.getPoint());
        titreObjet.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        orJoueur.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 14));
        //Attente
        // orJoueurChiffre.setText();
    }

    public JeuController() {
        Objet Pioche = new Objet("Pioche", 0, 50, 2);
        magasinObjet.AddItem(Pioche);
        Objet Perceuse = new Objet("Perceuse", 0, 100, 4);
        magasinObjet.AddItem(Perceuse);
        Objet Nain = new Objet("Nain", 0, 250, 8);
        magasinObjet.AddItem(Nain);
        Objet Foreuse = new Objet("Foreuse", 0, 500, 12);
        magasinObjet.AddItem(Foreuse);
        for (Achetable a : magasinObjet.GetItems()) {
            a.addObserver(j);
        }

    }

    @FXML
    private void achatc(ActionEvent event) {
        scene = orJoueur.getScene();
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();


        Achetable a = magasinCapacite.GetItem(data);
        a.addNiv();
        updatePoint();
        String prix = "#prix" + data ;
        Label labelprix = (Label) scene.lookup(prix);
        labelprix.setText(a.getPrix() + " Or");

        String niv = "#niveau" + data ;
        Label labelniv = (Label) scene.lookup(niv);
        labelniv.setText(a.getNiv() + "");


        String eff = "#effet" + data ;
        Label labeleff = (Label) scene.lookup(eff);
        labeleff.setText("Effet: +"+a.getEffet() + "/click");
        updatePoint();

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

    public void updatePoint() {
                for (Achetable a : magasinObjet.GetItems()) {
                    if (a.getPrix() > j.getPoint()) {
                        try {
                            String p = "#" + a.getNom() + "Achat";
                            Button button = (Button) scene.lookup(p);
                            button.setDisable(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
        }
        orJoueurChiffre.setText("" + j.getPoint());

    }

    public void clickRessourceB() {
        double effet = 0.5;

        for (Achetable a : magasinCapacite.GetItems()) {
            effet += a.getEffet();
        }
        b.addPoint(effet);

        updatePoint();
    }
}

}


