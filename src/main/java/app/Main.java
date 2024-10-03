package app;

import app.Formes.models.Carre;
import app.Formes.models.FormeGeo;
import app.Formes.models.Niveau;
import app.Formes.models.Triangle;

public class Main {
    public static void main(String[] args) {


        // Créer un niveau
        Niveau niveau1 = new Niveau();

        // Créer un carré, un triangle et un cercle
        FormeGeo carre1 = new Carre(5);    // Carré avec un côté de 4 unités
        FormeGeo triangle1 = new Triangle(4.5); // Triangle avec un côté de 4.5 unités

        // Ajouter les formes au niveau
        niveau1.addForme(carre1);
        niveau1.addForme(triangle1);

        // Afficher le contenu du niveau
        niveau1.dispayNiveau();
    }

}
