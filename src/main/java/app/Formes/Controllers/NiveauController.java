package app.Formes.Controllers;

import app.Formes.DTO.FormeDTO;
import app.Formes.Repository.NiveauRepository;
import app.Formes.Services.NiveauService;
import app.Formes.models.FormeGeo;
import app.Formes.models.Niveau;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/niveau")
public class NiveauController {

    private final NiveauService niveauService;
    private final NiveauRepository niveauRepository;

    // Constructeur pour injecter NiveauService et NiveauRepository
    public NiveauController(NiveauService niveauService, NiveauRepository niveauRepository) {
        this.niveauService = niveauService;
        this.niveauRepository = niveauRepository;
    }

    // --------------------- Récupérer tous les niveaux ---------------------
    @GetMapping
    public List<Niveau> getAllNiveaux() {
        return niveauService.getAllNiveaux();
    }

    // --------------------- Récupérer un niveau par ID ---------------------
    @GetMapping("/{id}")
    public Niveau getNiveauById(@PathVariable Long id) {
        return niveauService.getNiveauById(id);
    }

    // --------------------- Créer un nouveau niveau ---------------------
    @PostMapping
    public ResponseEntity<String> createNiveau(@RequestBody Niveau niveau) {
        try {
            niveauService.createNiveau(niveau);
            return new ResponseEntity<>("Niveau créé avec succès", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la création du niveau", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // --------------------- Ajouter une forme à un niveau ---------------------
    @PostMapping("/{id}/create")
    public ResponseEntity<String> addFormeToNiveau(@PathVariable Long id, @RequestBody FormeDTO formeDTO) {
        try {
            FormeGeo forme = formeDTO.dtoToForme();  // Conversion du DTO en entité FormeGeo
            niveauService.addFormeToNiveau(id, forme);  // Ajout de la forme au niveau
            return ResponseEntity.ok("Forme ajoutée avec succès !");
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout de la forme", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // --------------------- Récupérer toutes les formes d'un niveau ---------------------
    @GetMapping("/{id}/formes")
    public List<FormeDTO> getAllFormeFromNiveau(@PathVariable Long id) {
        Niveau niveau = niveauRepository.findById(id).orElse(null);
        return niveau != null ? niveau.getFormesDTO() : null;
    }

    // --------------------- Ajouter une nouvelle forme ---------------------
    @PostMapping("/formes")
    public ResponseEntity<String> addForme(@RequestBody FormeGeo forme) {
        niveauService.addForme(forme);
        return ResponseEntity.ok("Forme ajoutée !");
    }

    // --------------------- Mettre à jour un niveau ---------------------
    @PutMapping("/update/{id}")
    public Niveau updateNiveau(@PathVariable Long id, @RequestBody Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    // --------------------- Supprimer une forme par ID ---------------------
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteForme(@PathVariable int id) {
        boolean isDeleted = niveauService.deleteForme(id);
        if (isDeleted) {
            return ResponseEntity.ok("Forme supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forme non trouvée");
        }
    }

    // --------------------- Calculer l'aire totale des formes d'un niveau ---------------------
    @GetMapping("/aireTotale")
    public ResponseEntity<Double> getAireTotale() {
        double aireTotale = niveauService.calculerAireTotale();
        return new ResponseEntity<>(aireTotale, HttpStatus.OK);
    }

    // --------------------- Calculer le périmètre total des formes d'un niveau ---------------------
    @GetMapping("/perimetreTotale")
    public double getPerimetreTotale() {
        return niveauService.calculerPerimetreTotal();
    }
}
