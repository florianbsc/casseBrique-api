package org.example.cassBrique_api;

import java.awt.*;


public abstract class FormeGeo {
    protected Color couleur;
    protected String name; // attribut commun a toutes les formes
    protected int x;
    protected int y;

//    protected double sideLongueur;  // enlever car Cercle n'herite pas de cette attribut

    public FormeGeo(String name, Color couleur, int x, int y) {
        this.name = name;
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }

    public abstract double calculePerimetre() ;
    public abstract double calculeAire() ;

    public int getPointX() {
        return x;
    }
    public int getPointY() {
        return y;
    }

    //    public String getName() {
//        return name;
//    }
    public Color getCouleur() {
        return couleur;
    }

    public abstract void displayForme() ;

}