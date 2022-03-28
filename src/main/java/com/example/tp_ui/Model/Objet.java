package com.example.tp_ui.Model;

public class Objet<string> {

    private string Nom;
    private int Cout;
    private int Niveau;

    public string getNom() {return Nom;}

    public void setNom(string name) {Nom = name;}

    public int getCout(){return Cout;}

    public void setCout(int or) {Cout = or;}

    public int getNiveau() {
        return Niveau;
    }

    public void setNiveau(int niveau) {
        Niveau = niveau;
    }
}
