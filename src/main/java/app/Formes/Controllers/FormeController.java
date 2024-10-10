package app.Formes.Controllers;

import app.Formes.Services.FormeGeoService;
import app.Formes.models.FormeGeo;
import app.Formes.models.Triangle;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/formes")
public class FormeController {

    private final FormeGeoService formeGeoService;

    public FormeController(FormeGeoService formeGeoService) {
        this.formeGeoService = formeGeoService;
    }

    @GetMapping
    public List<FormeGeo> getAllFormes() {
        return formeGeoService.getAllFormes();
    }


    @PostMapping
    public FormeGeo createForme(@RequestBody FormeGeo forme) {
        return formeGeoService.saveFormeGeo(forme);
    }
}


