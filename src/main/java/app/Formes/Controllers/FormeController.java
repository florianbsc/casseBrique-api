package app.Formes.Controllers;

import app.Formes.Services.FormeGeoService;
import app.Formes.models.FormeGeo;
import app.Formes.models.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("api/formes")
//public class FormeController {
//
//    @Autowired
//    private FormeGeoService formeGeoService;
//
//    @GetMapping("/couleur")
//    public Color getCouleur() {
//        return formeGeoService.getCouleur();
//    }
//}

public class FormeController {
    @GetMapping("/forme")
    public FormeGeo getForme() {
        return new Triangle(69);

    }
}




