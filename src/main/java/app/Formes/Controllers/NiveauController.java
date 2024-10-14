package app.Formes.Controllers;
import app.Formes.DTO.FormeDTO;
import app.Formes.Repository.NiveauRepository;
import app.Formes.models.FormeGeo;
import app.Formes.Services.NiveauService;
import app.Formes.models.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // corps de la requete
@RequestMapping("/api/niveau") // lien URL de la requete
public class NiveauController {

    // Injection de la dépendance du service NiveauService grâce à @Autowired
    @Autowired
    public NiveauService niveauService;
    @Autowired
    private NiveauRepository niveauRepository;

    //   Recupere tout les niveaux
    @GetMapping
    public List<Niveau> getAllNiveaux() {
        return niveauService.getAllNiveaux();
    }

//    Recupere un niveau par id
    @GetMapping("/{id}")
    public Niveau getNiveauById(@PathVariable Long id) {
        return niveauService.getNiveauById(id);
    }

//    Créer un niveau
    @PostMapping
    public ResponseEntity<String> createNiveau(@RequestBody Niveau niveau) {
        try {
            niveauService.createNiveau(niveau);
            return new ResponseEntity<>("Niveau créé avec succès", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la création du niveau", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    ajout une forme a un niveau
    @PostMapping("/{id}/formes")
    public ResponseEntity<String> addFormeToNiveau(@PathVariable Long id, @RequestBody FormeDTO formeDTO) {
        try {
            FormeGeo forme = formeDTO.dtoToForme();  // Conversion du DTO en une entité FormeGeo
            niveauService.addFormeToNiveau(id, forme);  // Ajout de la forme au niveau
            return ResponseEntity.ok("Forme ajoutée avec succès !");
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout de la forme", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/formes")
    public List<FormeDTO> getAllFormeFromNiveau(@PathVariable Long id) {
        Niveau niveau = niveauRepository.findById(id).orElse(null);
        return niveau.getFormesDTO();
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
     * Supprime une forme du niveau par son ID.
     * @param id L'ID de la forme à supprimer (obtenu à partir de l'URL).
     * @return Une réponse HTTP avec un message indiquant que la forme a été supprimée avec succès.
     */
    @DeleteMapping("/formes/{id}")
    public ResponseEntity<String> deleteForme(@PathVariable int id) {
        boolean isDeleted = niveauService.deleteForme(id);
        if (isDeleted) {
            return ResponseEntity.ok("Forme supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forme non trouvée");
        }
    }



    /**
     * Calcule la somme des aires de toutes les formes dans le niveau.
     * @return Le total des aires de toutes les formes.
     */
    @GetMapping("/aireTotale")
    public ResponseEntity<Double> getAireTotale() {
        double aireTotale = niveauService.calculerAireTotale();
        return new ResponseEntity<>(aireTotale, HttpStatus.OK);
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
