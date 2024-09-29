package org.example.cassBrique_api;


import java.awt.*;

//polymorphisme
// Classe représentant un côté
class Side {
    private double side;

    public Side(double side) {
        this.side = side;
    }
    public double getside() {
        return side;
    }
}

public class Carre extends FormeGeo {
    //  attribut du carré
    private Side side; // Un carré est composé d'un seul côté (longueur du côté identique pour tous)

    // Constructeur pour initialiser le carré avec un côté
    public Carre(double side) {
        super("Carre", Color.CYAN, 8, 8);  // Appel au constructeur parent pour initialiser le nom et la couleur
        this.side = new Side(side); // Composition : Un carré contient un côté
    }

    //    methode
    @Override
    public double calculePerimetre() {
        return side.getside() * 4; // Récupérer la longueur du côté
    }

    // Méthode pour calculer l'aire du carré
    @Override
    public double calculeAire() {
        return Math.pow(side.getside(), 2); // Aire = côté * côté
    }

    @Override
    public void displayForme() {
        System.out.println("Nom :" + name + ", Longueur Coté : " + side.getside() + " , Couleur : " + getCouleur());
        System.out.println("le perimetre : " + calculePerimetre() + " cm et l'air : " + calculeAire() + " cm2" + "\n");

    }
}