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

public class JeuController implements Initializable
{

    @FXML
    public  Label prixPioche;
    @FXML
    public  Label niveauPioche;
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
    @FXML
    public Label titreObjet;
    @FXML
    public Label orJoueur;
    @FXML
    public Label orJoueurChiffre;
    ArrayList<Double> prix = new ArrayList<>();
    ArrayList<Integer> niveau = new ArrayList<>();
    Magasin magasinObjet = new Magasin("objet");
    Joueur j = new Joueur();

    @FXML
    private Label Test;
    private Scene scene ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      j.setPoint(0);
      titreObjet.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
      orJoueur.setFont(Font.font("Times New Roman", FontPosture.ITALIC,14));
      //Attente
     // orJoueurChiffre.setText();
      prixPioche.setText(Double.toString(prix.get(0)));
      prixPerceuse.setText(Double.toString(prix.get(1)));
      prixNain.setText(Double.toString(prix.get(2)));
      prixForeuse.setText(Double.toString(prix.get(3)));
      niveauPioche.setText(Integer.toString(niveau.get(0)));
      niveauPerceuse.setText(Integer.toString(niveau.get(1)));
      niveauNain.setText(Integer.toString(niveau.get(2)));
      niveauForeuse.setText(Integer.toString(niveau.get(3)));
    }

    public JeuController()
    {

        Objet Pioche =new Objet("Pioche", 0,50,2);
        magasinObjet.AddItem(Pioche);
        Objet Perceuse =new Objet("Perceuse",0,100,4);
        magasinObjet.AddItem(Perceuse);
        Objet Nain =new Objet("Nain", 0,250,8);
        magasinObjet.AddItem(Nain);
        Objet Foreuse =new Objet("Foreuse", 0,500,12);
        magasinObjet.AddItem(Foreuse);
        for (Achetable a: magasinObjet.GetItems()) {
            a.addObserver(j);
            prix.add(a.getPrix());
            niveau.add(a.getNiv());
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




