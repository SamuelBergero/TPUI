package com.example.tp_ui.Model;

public class Objet<string> {

    private string Name;
    private int Or;
    private int Niveau;

    public string getName() {
        return Name;
    }

    public void setName(string name) {
        Name = name;
    }

    public int getOr() {
        return Or;
    }

    public void setOr(int or) {
        Or = or;
    }

    public int getNiveau() {
        return Niveau;
    }

    public void setNiveau(int niveau) {
        Niveau = niveau;
    }
}
