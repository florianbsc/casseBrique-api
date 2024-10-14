package app.Formes.Services;


import app.Formes.DTO.FormeDTO;
import app.Formes.Repository.NiveauRepository;
import app.Formes.models.FormeGeo;
import app.Formes.models.Niveau;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NiveauService {

    private final NiveauRepository niveauRepository;


    private List<FormeGeo> formes = new ArrayList<>(); // liste qui va contenir les formes add

    public NiveauService(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    public Niveau getNiveauById(Long id) {
        return niveauRepository.findById(id).orElse(null);
    }

    public Niveau createNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    public void addFormeToNiveau(Long niveauId, FormeGeo forme) {
        Niveau niveau = getNiveauById(niveauId);
        if (niveau != null) {
            niveau.addForme(forme);
            niveauRepository.save(niveau);
        }
    }

    public void deleteNiveau(Long niveauId) {
        Niveau niveau = getNiveauById(niveauId);
    }

//
//    public void addForme(FormeGeo forme) {
//        formes.add(forme); // methode d'add de la forme a la liste
//    }
//
    public List<FormeGeo> getAllFormes() {
        return formes; // methode pour retourner toutes les formes contenue dans la liste
    }

    public List<FormeDTO> getAllFormeFromNiveau(Long id) {
        Niveau niveau = niveauRepository.findById(id).orElse(null);
        return niveau.getFormesDTO();
    }

//    public FormeGeo getFormeById(int id) {
//        return formes.get(id);
//    }

    public boolean deleteForme(int id) { // methode pour sup une forme par son id
        formes.remove(id);
        return false;
    }

    public double calculerAireTotale() {
        // Utilise un Stream pour parcourir toutes les formes et calculer la somme de leurs aires
        return formes.stream().mapToDouble(FormeGeo::calculeAire).sum();
    }


    public double calculerPerimetreTotal() {
        // Utilise un Stream pour parcourir toutes les formes et calculer la somme de leurs périmètres
        return formes.stream().mapToDouble(FormeGeo::calculePerimetre).sum();
    }

    public void addForme(FormeGeo forme) {
        formes.add(forme);
    }
}

