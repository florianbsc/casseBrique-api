package app.Formes.models;

import jakarta.persistence.*;

import java.awt.Color;

@Entity
@Table(name = "FormeGeo")
public abstract class FormeGeo {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String couleur; // Utilisation de String pour stocker la couleur
    protected String name; // attribut commun a toutes les formes
    protected int x;
    protected int y;


    public FormeGeo() {}
//Constructeur avec arguments : le constructeur permet d'initialiser FormeGeo
// avec des valeurs spécifiques lorsque de la creation de nouvelles instances dans ton code.
    public FormeGeo(String name, Color couleur, int x, int y) {
//        this.id = id;
        this.name = name;
        this.couleur = convertColorToString(couleur); // Convertir la couleur en String
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

    public String getCouleur() {
        return couleur;
    } // Retourne la couleur sous forme de String

    public void setCouleur(String couleur) {
        this.couleur =couleur; // Accepte la couleur sous forme de String
    }

    public Color getCouleurAsColor() {
        return convertStringToColor(couleur);
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

    // Convertir une couleur en chaîne hexadécimale
    private String convertColorToString(Color color) {
        return "#" + Integer.toHexString(color.getRGB()).substring(2).toUpperCase();
    }

    // Convertir une chaîne hexadécimale en couleur
    private Color convertStringToColor(String colorString) {
        return Color.decode(colorString);
    }
}