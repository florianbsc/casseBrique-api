package app.Formes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.awt.Color;

@Entity
public abstract class FormeGeo {
    @Id@GeneratedValue
    protected Long id;
    protected Color couleur;
    protected String name; // attribut commun a toutes les formes
    protected int x;
    protected int y;

//Constructeur sans argument (protected) : JPA requiert un constructeur par défaut (sans arguments) pour instancier l'entité lorsqu'il charge les données depuis la base.
    public FormeGeo() {}
//Constructeur avec arguments : Ce constructeur te permet d'initialiser FormeGeo avec des valeurs spécifiques lorsque tu crées de nouvelles instances dans ton code.
    public FormeGeo(String name, Color couleur, int x, int y) {
//        this.id = id;
        this.name = name;
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getCouleur() {
        return couleur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract double calculePerimetre() ;
    public abstract double calculeAire() ;

    public abstract void displayForme() ;

}