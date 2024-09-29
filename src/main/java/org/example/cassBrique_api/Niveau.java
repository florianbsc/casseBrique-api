package org.example.cassBrique_api;

import java.util.ArrayList;
import java.util.List;

// mon interface
public class Niveau {

//    instantie un tableau lie a la calss FormeGeo
//    il stock les forme créé

    private List<FormeGeo> formes ;
    private int nbFormes;

    public Niveau() {
//        this.x = x;
//        this.y = y;
        this.formes = new ArrayList<FormeGeo>();
    }

    //    recupere les formes du niveau
    public List<FormeGeo> getForme() {
        return formes;
    }

    //    Creat une forme au niveau
    public void addForme(FormeGeo forme) {
        formes.add(forme);
    }
    //
//    // Mettre à jour une forme
//    public void editForme(int index, FormeGeo nouvelleForme) {
//        if (index >= 0 && index < formes.size()) {
//            formes.set(index, nouvelleForme); // MAJ la forme à l'index donné
//        }
//    }
//
    //    Delete
    public void deleteForme(FormeGeo forme) {
        formes.remove(forme);
    }

    public void clearNiveau() {
        formes.clear();
    }

    //    Addition de toute les aires des formes
    public double caculerAireTotale() {
        double aireTotale = 0;
        for (FormeGeo forme : formes) {
            aireTotale += forme.calculeAire();
        }
        return aireTotale;
    }

    //    Addition de toute les perimetres des formes
    public double calculerPerimetreTotale() {
        double perimetreTotale = 0;
        for (FormeGeo forme : formes) {
            perimetreTotale += forme.calculePerimetre();
        }
        return perimetreTotale;
    }

    public void dispayNiveau() {
        for (FormeGeo forme : formes) {  // prend chaque forme du tableau
            forme.displayForme();
// Affiche les totaux
        }
        System.out.println("Aire totale : " + caculerAireTotale() + " cm²");
        System.out.println("Périmètre total : " + calculerPerimetreTotale() + " cm");

    }

}

