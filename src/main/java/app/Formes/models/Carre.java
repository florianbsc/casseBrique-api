package app.Formes.models;

import jakarta.persistence.Entity;

import java.awt.*;

@Entity
//@Table( name = "Carrés")
public class Carre extends FormeGeo {
    //  attribut du carré
    private double side; // Un carré est composé d'un seul côté (longueur du côté identique pour tous)

    protected Carre() {}

    // Constructeur pour initialiser le carré avec un côté
    public Carre(double side, int x, int y) {
        super("Carre", Color.CYAN, x, y);  // Appel au constructeur parent pour initialiser le nom et la couleur
        this.side =  side; // Composition : Un carré contient un côté
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }


    @Override
    public String getName() {
        return "Carré";
    }
    @Override
    public int getX() {
        return super.getX();
    }
    @Override
    public int getY() {
        return super.getY();
    }
    //    methode
    @Override
    public double calculePerimetre() {
        return side * 4; // Récupérer la longueur du côté
    }

    // Méthode pour calculer l'aire du carré
    @Override
    public double calculeAire() {
        return Math.pow(getSide(), 2); // Aire = côté * côté
    }

    @Override
    public void displayForme() {
        System.out.println("Nom :" + name + ", Longueur Coté : " + side + " , Couleur : " + getCouleur());
        System.out.println("le perimetre : " + calculePerimetre() + " cm et l'air : " + calculeAire() + " cm2" + "\n");

    }
}