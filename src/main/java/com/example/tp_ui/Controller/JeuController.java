package com.example.tp_ui.Controller;

import com.example.tp_ui.Model.Achetable;
import com.example.tp_ui.Model.Joueur;
import com.example.tp_ui.Model.Magasin;
import com.example.tp_ui.Model.Objet;
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
        Objet o = new Objet();
        o.setNom("but");
        magasinObjet.AddItem(o);

        Objet q = new Objet();
        q.setNom("test");
        magasinObjet.AddItem(q);
        for (Achetable a: magasinObjet.GetItems())
        {
            a.observeBy(j);
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
