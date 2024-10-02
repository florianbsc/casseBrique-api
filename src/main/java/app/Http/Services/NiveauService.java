package app.Http.Services;


import app.Http.Models.FormeGeo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NiveauService {

//    pourquoi c'est dans le service du niveau qu'il y a les methodes CRUD de formeGeo ?

    private List<FormeGeo> formes = new ArrayList<>(); // liste qui va contenir les formes add

    public void addForme(FormeGeo forme) {
        formes.add(forme); // methode d'add de la forme a la liste
    }

    public List<FormeGeo> getAllFormes() {
        return formes; // methode pour retourner toutes les formes contenue dans la liste
    }

    public FormeGeo getFormeById(int id) { // je comprend l'utiliter de l'ID mais je ne comprend pas pk il m'en a rajouter un
        return formes.get(id);
    }

    public void deleteForme(int id) { // methode pour sup une forme par son id
        formes.remove(id);
    }

    public double calculerAireTotale() {
        // Utilise un Stream pour parcourir toutes les formes et calculer la somme de leurs aires
        return formes.stream().mapToDouble(FormeGeo::calculeAire).sum();
    }

    public double calculerPerimetreTotal() {
        // Utilise un Stream pour parcourir toutes les formes et calculer la somme de leurs périmètres
        return formes.stream().mapToDouble(FormeGeo::calculePerimetre).sum();
    }
}

