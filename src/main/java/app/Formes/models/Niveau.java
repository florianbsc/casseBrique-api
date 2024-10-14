package app.Formes.models;

import app.Formes.DTO.FormeDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// mon interface
@Entity
public class Niveau {

    @Id@GeneratedValue
    private Long id;
    private String nom;

//    @ManyToMany( fetch = FetchType.LAZY)
//    @OneToMany : Indique une relation de type "un-à-plusieurs" entre Niveau et FormeGeo.
//    cascade = CascadeType.ALL : Propager toutes les opérations (comme persist, remove, etc.) à la collection.
//    fetch = FetchType.LAZY : Charge la liste des formes de manière paresseuse (uniquement lorsqu'elle est nécessaire).
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)

    private List<FormeGeo> formes = new ArrayList<>(); // Initialisation par défaut
    private int nbFormes;

    public Niveau() {}

    public Niveau(Long id, String nom, List<FormeGeo> formes, int nbFormes) {
        this.id = id;
        this.nom = nom;
        this.formes = formes;
        this.nbFormes = nbFormes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public void displayNiveau() {
        formes.forEach(FormeGeo::displayForme);
        System.out.println("Aire totale : " + calculerAireTotale() + " cm²");
        System.out.println("Périmètre total : " + calculerPerimetreTotale() + " cm");
    }


    public List<FormeDTO> getFormesDTO() {
        List<FormeDTO> formesDTO = new ArrayList<>();
        for (FormeGeo forme : formes) {

        }
        return formesDTO;
    }
}

