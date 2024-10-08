package app;

import app.Formes.models.*;

public class Main {
    public static void main(String[] args) {


        // Créer un niveau
        Niveau niveau1 = new Niveau();

        // Créer un carré, un triangle et un cercle
        FormeGeo cercle1 = new Cercle(5, 0, 0);    // Carré avec un côté de 4 unités
//        FormeGeo triangle1 = new Triangle(4.5, 4, 4); // Triangle avec un côté de 4.5 unités

        // Ajouter les formes au niveau
        niveau1.addForme(cercle1);
//        niveau1.addForme(triangle1);

        // Afficher le contenu du niveau
        niveau1.displayNiveau();
    }

}
