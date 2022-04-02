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

    public Label prixPioche;
    @FXML
    public Label niveauPioche;
    @FXML
    public Label prixPerceuse;
    @FXML
    public Label niveauPerceuse;
    @FXML
    public Label prixNain;
    @FXML
    public Label niveauNain;
    @FXML
    public Label prixForeuse;
    @FXML
    public Label niveauForeuse;
    Magasin magasinObjet = new Magasin("objet");
    Magasin magasinCapacite = new Magasin("capacite");
    Joueur j = new Joueur();
    Joueur b = new Joueur();

    @FXML
    private Label Test;
    private Scene scene ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        j.setPoint(1000);
        b.setPoint(100);
        orJoueurChiffre.setText("" + j.getPoint());
        titreObjet.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        orJoueur.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 14));
        //Attente
        // orJoueurChiffre.setText();


    }

    public JeuController()
    {

        Capacité Leadership = new Capacité("Leadership", 0, 1, 0.1);
        magasinCapacite.AddItem(Leadership);
        Capacité Competence = new Capacité("Competence", 0, 4, 0.4);
        magasinCapacite.AddItem(Competence);
        Capacité Forage = new Capacité("Forage", 0, 8, 0.8);
        magasinCapacite.AddItem(Forage);
        Capacité Recolte = new Capacité("Recolte", 0, 10,1);
        magasinCapacite.AddItem(Recolte);

        Objet Pioche =new Objet("Pioche", 1,50,2);
        magasinObjet.AddItem(Pioche);
        Objet Perceuse =new Objet("Perceuse",1,100,4,"PerceuseAchat");
        magasinObjet.AddItem(Perceuse);
        Objet Nain =new Objet("Nain", 1,250,8,"NainAchat");
        magasinObjet.AddItem(Nain);
        Objet Foreuse =new Objet("Foreuse", 1,500,12,"ForeuseAchat");
        magasinObjet.AddItem(Foreuse);
        for (Achetable a: magasinObjet.GetItems()) {
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

    public void clickRessourceB() {
        double effet = 0.5;

        for (Achetable a : magasinCapacite.GetItems()) {
            effet += a.getEffet();
        }
        b.addPoint(effet);

        updatePoint();
    }

}


