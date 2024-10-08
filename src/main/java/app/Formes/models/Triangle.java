package app.Formes.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.awt.*;

@Entity
@Table(name = "triangles")
public class Triangle extends FormeGeo {
    private double side =3;

    public Triangle(){}

    public  Triangle  (double side, int x, int y) {
        super("Triangle", Color.MAGENTA, x, y);
        this.side =side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
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
