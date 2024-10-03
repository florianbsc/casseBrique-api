package app.Formes.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;

import java.awt.*;

@Entity
public class Cercle extends FormeGeo {
    private double rayon = 2.5;

    protected Cercle () {}

    public Cercle(double rayon) {
        super("Cercle", Color.GREEN, 0, 0);
        this.rayon = rayon;
    }

    @Override
    public String getName() {
        return "Cercle";
    }

    @Override
    public double calculeAire() {
        return Math.PI * Math.pow(rayon, 2); // Aire du cercle = π * rayon²
    }

    @Override
    public double calculePerimetre() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public void displayForme () {
        System.out.println(name + " de rayon: " + this.rayon + " cm");
        System.out.println("Air Cercle: " + calculeAire() + " cm2");
        System.out.println("Perimetre Cercle: " + calculePerimetre() + " cm\n");
    }
}
