package app.Formes.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// mon interface
@Entity
public class Niveau {

    @Id@GeneratedValue
    private Long id;

    @ManyToMany( fetch = FetchType.LAZY)
//    @OneToMany : Indique une relation de type "un-à-plusieurs" entre Niveau et FormeGeo.
//    cascade = CascadeType.ALL : Propager toutes les opérations (comme persist, remove, etc.) à la collection.
//    fetch = FetchType.LAZY : Charge la liste des formes de manière paresseuse (uniquement lorsqu'elle est nécessaire).

    private List<FormeGeo> formes = new ArrayList<>(); // Initialisation par défaut
    private int nbFormes;

    public Niveau() {}

    public Niveau(Long id, List<FormeGeo> formes, int nbFormes) {
        this.id = id;
        this.formes = formes;
        this.nbFormes = nbFormes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FormeGeo> getFormes() {
        return formes;
    }

    public void setFormes(List<FormeGeo> formes) {
        this.formes = formes;
    }

    public int getNbFormes() {
        return nbFormes;
    }

    public void setNbFormes(int nbFormes) {
        this.nbFormes = nbFormes;
    }

    // Ajouter une forme
    public void addForme(FormeGeo forme) {
        formes.add(forme);
    }

    // Supprimer une forme
    public void deleteForme(FormeGeo forme) {
        formes.remove(forme);
    }

    // Vider le niveau
    public void clearNiveau() {
        formes.clear();
    }

    // Calculer l'aire totale
    public double calculerAireTotale() {
        return formes.stream().mapToDouble(FormeGeo::calculeAire).sum();
    }

    // Calculer le périmètre total
    public double calculerPerimetreTotale() {
        return formes.stream().mapToDouble(FormeGeo::calculePerimetre).sum();
    }


    //    Addition de toute les aires des formes
//    public double caculerAireTotale() {
//        double aireTotale = 0;
//        for (FormeGeo forme : formes) {
//            aireTotale += forme.calculeAire();
//        }
//        return aireTotale;
//    }
//
//    //    Addition de toute les perimetres des niveau
//    public double calculerPerimetreTotale() {
//        double perimetreTotale = 0;
//        for (FormeGeo forme : formes) {
//            perimetreTotale += forme.calculePerimetre();
//        }
//        return perimetreTotale;
//    }

    public void displayNiveau() {
        formes.forEach(FormeGeo::displayForme);
        System.out.println("Aire totale : " + calculerAireTotale() + " cm²");
        System.out.println("Périmètre total : " + calculerPerimetreTotale() + " cm");
    }


}

