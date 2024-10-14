
package app.Formes.DTO;

import app.Formes.models.Carre;
import app.Formes.models.Cercle;
import app.Formes.models.FormeGeo;
import app.Formes.models.Triangle;

import java.awt.*;

public record FormeDTO(String name, String couleur, int x, int y, Double side, Double rayon) {

    public FormeGeo dtoToForme() {
        switch (name.toLowerCase()) {
            case "carre":
                return new Carre(side, x, y);
            case "cercle":
                return new Cercle(rayon, x, y);
            case "triangle":
                return new Triangle(side, x, y);
            default:
                throw new IllegalArgumentException("Forme non supportée : " + name);
        }
    }
    // Convertir une chaîne hexadécimale en couleur
    private Color convertStringToColor(String colorString) {
        return Color.decode(colorString);
    }
}






