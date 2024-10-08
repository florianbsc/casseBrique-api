package app.Formes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.awt.*;

@Entity
@Table(name = "Cercles")
public class Cercle extends FormeGeo {
    private double rayon = 2.5;

    protected Cercle () {}

    public Cercle(double rayon, int x, int y) {
        super("Cercle", Color.GREEN, x, y);
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
    }
    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public String getName() {
        return "Cercle";
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
    public double calculeAire() {
        return Math.PI * Math.pow(getRayon(), 2); // Aire du cercle = π * rayon²
    }

    @Override
    public double calculePerimetre() {
        return 2 * Math.PI * getRayon();
    }

    @Override
    public void displayForme () {
        System.out.println(name + " de rayon: " + getRayon() + " cm");
        System.out.println("Air Cercle: " + calculeAire() + " cm2");
        System.out.println("Perimetre Cercle: " + calculePerimetre() + " cm\n");
    }
}
