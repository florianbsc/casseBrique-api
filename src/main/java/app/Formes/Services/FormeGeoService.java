package app.Formes.Services;

import app.Formes.Repository.FormeGeoRepository;
import app.Formes.Repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class FormeGeoService {

    @Autowired
    private NiveauRepository niveauRepository;
    @Autowired
    private FormeGeoRepository formeGeoRepository;

//    public FormeGeo creatForme(FormeGeo forme){
//        niveau.addForme(forme);
//    }

    public void saveFormeGeo(FormeGeo forme);

    public Color getCouleur() {
        Color couleur = Color.RED;
        return couleur;
    }
}
