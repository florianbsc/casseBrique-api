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
    private List<FormeGeo> formes = new ArrayList<>(); // Liste pour stocker les formes ajoutées

    // Constructeur pour injecter NiveauRepository
    public NiveauService(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    // --------------------- Récupérer tous les niveaux ---------------------
    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    // --------------------- Récupérer un niveau par ID ---------------------
    public Niveau getNiveauById(Long id) {
        return niveauRepository.findById(id).orElse(null);
    }

    // --------------------- Créer un nouveau niveau ---------------------
    public Niveau createNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    // --------------------- Mettre à jour un niveau existant ---------------------
    public Niveau updateNiveau(Long id, Niveau niveau) {
        Niveau n = getNiveauById(id);
        if (n != null) {
            n.setNom(niveau.getNom()); // Mise à jour du nom du niveau
            return niveauRepository.save(n);
        }
        return null;
    }

    // --------------------- Supprimer un niveau ---------------------
    public void deleteNiveau(Long id) {
        Niveau niveau = getNiveauById(id);
        if (niveau != null) {
            niveauRepository.delete(niveau);
        }
    }

    // --------------------- Ajouter une forme à la liste de formes ---------------------
    public void addForme(FormeGeo forme) {
        formes.add(forme);
    }

    // --------------------- Ajouter une forme à un niveau ---------------------
    public void addFormeToNiveau(Long niveauId, FormeGeo forme) {
        Niveau niveau = getNiveauById(niveauId);
        if (niveau != null) {
            niveau.addForme(forme); // Ajoute la forme au niveau
            niveauRepository.save(niveau); // Sauvegarde du niveau avec la nouvelle forme
        }
    }

    // --------------------- Récupérer toutes les formes ---------------------
    public List<FormeGeo> getAllFormes() {
        return formes; // Retourne la liste de toutes les formes
    }

    // --------------------- Récupérer toutes les formes d'un niveau ---------------------
    public List<FormeDTO> getAllFormeFromNiveau(Long id) {
        Niveau niveau = niveauRepository.findById(id).orElse(null);
        return niveau != null ? niveau.getFormesDTO() : new ArrayList<>();
    }

    // --------------------- Supprimer une forme par ID ---------------------
    public boolean deleteForme(int id) {
        if (id >= 0 && id < formes.size()) {
            formes.remove(id); // Supprime la forme par son index
            return true;
        }
        return false; // Si l'index n'est pas valide, retourne false
    }

    // --------------------- Calculer la somme des aires de toutes les formes ---------------------
    public double calculerAireTotale() {
        return formes.stream().mapToDouble(FormeGeo::calculeAire).sum(); // Somme des aires de toutes les formes
    }

    // --------------------- Calculer la somme des périmètres de toutes les formes ---------------------
    public double calculerPerimetreTotal() {
        return formes.stream().mapToDouble(FormeGeo::calculePerimetre).sum(); // Somme des périmètres de toutes les formes
    }
}
