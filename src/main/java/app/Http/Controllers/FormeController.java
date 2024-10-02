package app.Http.Controllers;

import app.Http.Models.FormeGeo;
import app.Http.Services.FormeGeoService;
import app.Http.Services.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/formes")
public class FormeController {

    @Autowired
    private FormeGeoService formeGeoService;

    @GetMapping("/couleur")
    public Color getCouleur() {
        return formeGeoService.getCouleur();
    }




}
