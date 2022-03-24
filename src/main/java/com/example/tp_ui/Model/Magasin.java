package com.example.tp_ui.Model;

import java.util.ArrayList;

public class Magasin {
    String nom;
    ArrayList<Achetable> inventaire = new ArrayList<Achetable>();

    public Magasin(String nom){
        this.nom = nom;
    }

    public void SetNom(String nom){this.nom = nom;}
    public String GetNom(){return nom;}

    public void AddItem(Achetable objet){inventaire.add(objet);}
    public void RemoveItem(Achetable objet){inventaire.remove(objet);}
    public ArrayList<Achetable> GetItems(){return inventaire;}
    public Achetable GetItem(String nom){
        for (Achetable c : inventaire) {
            if (nom.equals(c.getNom())) {
                return c;
            }
        }
        return null;
    }
}
