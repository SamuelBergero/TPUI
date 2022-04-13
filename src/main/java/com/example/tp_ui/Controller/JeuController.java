package com.example.tp_ui.Controller;

import com.example.tp_ui.Model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class JeuController implements Initializable {

    @FXML
    public Label titreObjet;
    @FXML
    public Label orJoueur;
    @FXML
    public Label orJoueurChiffre;

    @FXML
    public Label AffOr;

    @FXML
    public Label AffBiere;

    @FXML
    public Label points;



    Magasin magasinObjet = new Magasin("objet");
    Magasin magasinCapacite = new Magasin("capacite");
    Joueur j = new Joueur();
    Joueur b = new Joueur();


    @FXML
    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        j.setPoint(0);
        b.setPoint(0);
        titreObjet.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        orJoueur.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 14));
        orJoueurChiffre.setText(orJoueurChiffre.getText());


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

        Capacité Leadership = new Capacité("Leadership", 0, 1, 0.1);
        magasinCapacite.AddItem(Leadership);
        Capacité Competence = new Capacité("Competence", 0, 4, 0.4);
        magasinCapacite.AddItem(Competence);
        Capacité Forage = new Capacité("Forage", 0, 8, 0.8);
        magasinCapacite.AddItem(Forage);
        Capacité Recolte = new Capacité("Recolte", 0, 10,1);
        magasinCapacite.AddItem(Recolte);

        for (Achetable a: magasinObjet.GetItems())
        {
            a.addObserver(j);
        }
        for (Achetable a: magasinCapacite.GetItems())
        {
            a.addObserver(b);
        }


    }

    @FXML
    private void achatc(ActionEvent event) {
        scene = orJoueur.getScene();
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();

        Achetable a = magasinCapacite.GetItem(data);

        a.addNiv();

        String prix = "#prix" + data ;
        Label labelprix = (Label) scene.lookup(prix);
        labelprix.setText(a.getPrix() + " Bière");

        String niv = "#niv" + data ;
        Label labelniv = (Label) scene.lookup(niv);
        labelniv.setText(a.getNiv() + "");


        String eff = "#effet" + data ;
        Label labeleff = (Label) scene.lookup(eff);
        labeleff.setText("Effet: +"+a.getEffet() + "/click");

        updatePoint();
    }

    @FXML
    private void achat(ActionEvent event) {
        scene = orJoueur.getScene();
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();


        Achetable a = magasinObjet.GetItem(data);
        a.addNiv();

        String prix = "#prix" + data ;
        Label labelprix = (Label) scene.lookup(prix);
        labelprix.setText(a.getPrix() + "");

        String niv = "#niveau" + data ;
        Label labelniv = (Label) scene.lookup(niv);
        labelniv.setText(a.getNiv() + "");


        String eff = "#effet" + data ;
        Label labeleff = (Label) scene.lookup(eff);
        labeleff.setText("Effet: +"+a.getEffet() + "/click");
        updatePoint();

    }

    public void updatePoint() {
        scene = orJoueur.getScene();
                for (Achetable a : magasinObjet.GetItems()) {
                    if (a.getPrix() > j.getPoint()) {
                        try {
                            String p = "#" + a.getNom() + "Achat";
                            Button button = (Button) scene.lookup(p);
                            button.setDisable(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            String p = "#" + a.getNom() + "Achat";
                            Button button = (Button) scene.lookup(p);
                            button.setDisable(false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

        for (Achetable a : magasinCapacite.GetItems()) {
            if (a.getPrix() > b.getPoint()) {
                try {
                    String p = "#" + a.getNom() + "Achat";
                    Button button = (Button) scene.lookup(p);
                    button.setDisable(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    String p = "#" + a.getNom() + "Achat";
                    Button button = (Button) scene.lookup(p);
                    button.setDisable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        orJoueurChiffre.setText("" + j.getPoint());
        AffOr.setText(orJoueur.getText() + " " + j.getPoint());
        b.setPoint(new BigDecimal(b.getPoint()).setScale(2, RoundingMode.HALF_UP).doubleValue());
        AffBiere.setText("Bière du joueur : " + b.getPoint());
        points.setText("Bières disponibles : " + b.getPoint());
    }

    public void clickRessourceB() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    double effet = 5;

                    for (Achetable a : magasinCapacite.GetItems()) {
                        effet += a.getEffet();
                    }
                    b.addPoint(effet);
                    updatePoint();});
                scene = orJoueur.getScene();
                String p = "#buttonB";
                Button button = (Button) scene.lookup(p);
                button.setDisable(false);
            }
        };

        scene = orJoueur.getScene();
        String p = "#buttonB";
        Button button = (Button) scene.lookup(p);
        button.setDisable(true);

       Timer test = new Timer();
       test.schedule(task,2000);
    }

    public void clickRessourceA() {
        double effet = 1;

        for (Achetable a : magasinObjet.GetItems()) {
            effet += a.getEffet();
        }
        j.addPoint(effet);
        updatePoint();
    }
}


