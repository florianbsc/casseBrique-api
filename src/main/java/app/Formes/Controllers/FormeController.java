package app.Formes.Controllers;

import app.Formes.DTO.FormeDTO;
import app.Formes.Services.FormeGeoService;
import app.Formes.models.FormeGeo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/formes")
public class FormeController {

    private final FormeGeoService formeGeoService;

    public FormeController(FormeGeoService formeGeoService) {
        this.formeGeoService = formeGeoService;
    }

    @GetMapping
    public List<FormeGeo> getAllFormes() {
        return formeGeoService.getAllFormes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormeGeo> getFormeById(@PathVariable Long id) {
        FormeGeo forme = formeGeoService.getFormeById(id);
        if (forme == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(forme);
    }

    @PostMapping
    public FormeGeo createForme(@RequestBody FormeDTO formeDTO) {
        FormeGeo forme = formeDTO.dtoToForme();
        return formeGeoService.saveFormeGeo(forme);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFormeById(@PathVariable Long id) {
        boolean isDeleted = formeGeoService.deleteFormeById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Forme supprimée avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}


