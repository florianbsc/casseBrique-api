package app.Http.Models;


import jakarta.persistence.Entity;

import java.awt.*;

@Entity
public class Triangle extends FormeGeo {
    private double side =3;

    protected Triangle(){}

    public  Triangle  (double side) {
        super("Triangle", Color.MAGENTA, 4, 4);
        this.side =side;
    }

    @Override
    public double calculePerimetre () {
        return 3 * side; // Périmètre = 3 * côté (triangle équilatéral)
    }

    @Override
    public double calculeAire() {
        return (Math.sqrt(3) / 4) * Math.pow(side, 2); // Aire = (√3 / 4) * côté²
    }

    //la methode pour afficher les infos
    @Override
    public void displayForme() {
        System.out.println("Nom : " +name + " longuere de  cotés: " + side + " cm");
        System.out.println("Perimetre: " + calculePerimetre() + " cm, Aire : " + calculeAire() +" cm2" +  "\n");
    }
}
