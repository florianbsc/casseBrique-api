package app.Formes.Controllers;
import app.Formes.models.FormeGeo;
import app.Formes.Services.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // corps de la requete
@RequestMapping("/api/niveau") // lien URL de la requete
public class NiveauController {

    // Injection de la dépendance du service NiveauService grâce à @Autowired
    @Autowired
    public NiveauService niveauService;

    /**
     * Ajoute une nouvelle forme au niveau.
     * @param forme L'objet FormeGeo reçu dans le corps de la requête HTTP (au format JSON).
     * @return Une réponse HTTP avec un message indiquant que la forme a été ajoutée avec succès.
     */
    @PostMapping("/formes") // request HTTP POST
    public ResponseEntity<String> addForme(@RequestBody FormeGeo forme) {
        // Appel du service pour ajouter la forme à la liste
        niveauService.addForme(forme);
        // Retourne une réponse HTTP 200 avec un message de succès
        return ResponseEntity.ok("Forme ajoutée !");
    }

    /**
     * Récupère la liste de toutes les formes dans le niveau.
     * @return Une liste d'objets FormeGeo.
     */
    @GetMapping("/formes")
    public List<FormeGeo> getAllFormes() {
        // Appel du service pour récupérer toutes les formes
        return niveauService.getAllFormes();
    }

    /**
     * Supprime une forme du niveau par son ID.
     * @param id L'ID de la forme à supprimer (obtenu à partir de l'URL).
     * @return Une réponse HTTP avec un message indiquant que la forme a été supprimée avec succès.
     */
    @DeleteMapping("/formes/{id}")
    public ResponseEntity<String> deleteForme(@PathVariable int id) {
        // Appel du service pour supprimer la forme à l'index spécifié
        niveauService.deleteForme(id);
        // Retourne une réponse HTTP 200 avec un message de succès
        return ResponseEntity.ok("Forme supprimée !");
    }

    /**
     * Calcule la somme des aires de toutes les formes dans le niveau.
     * @return Le total des aires de toutes les formes.
     */
    @GetMapping("/aireTotale")
    public double getAireTotale() {
        // Appel du service pour calculer la somme des aires
        return niveauService.calculerAireTotale();
    }

    /**
     * Calcule la somme des périmètres de toutes les formes dans le niveau.
     * @return Le total des périmètres de toutes les formes.
     */
    @GetMapping("/perimetreTotale")
    public double getPerimetreTotale() {
        // Appel du service pour calculer la somme des périmètres
        return niveauService.calculerPerimetreTotal();
    }
}
