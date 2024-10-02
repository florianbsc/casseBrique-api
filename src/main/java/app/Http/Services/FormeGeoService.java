package app.Http.Services;

import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public abstract class FormeGeoService {
    protected Color couleur;
    protected String name; // attribut commun a toutes les formes
    protected int x;
    protected int y;

    public void FormeGeo(String name, Color couleur, int x, int y) {
        this.name = name;
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }

//    private FormeGeo triangle1 = new Triangle(4.5); // Triangle avec un côté de 4.5 unités

    public abstract double calculePerimetre() ;
    public abstract double calculeAire() ;

    public Color getCouleur() {
        return couleur;
    }
}
