package app.Formes.models;

import jakarta.persistence.*;

import java.awt.Color;

@Entity
@Table(name = "FormeGeo")
public abstract class FormeGeo {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Color getCouleur() {
        return couleur;
    }
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public abstract double calculePerimetre() ;
    public abstract double calculeAire() ;


    public abstract void displayForme() ;

}