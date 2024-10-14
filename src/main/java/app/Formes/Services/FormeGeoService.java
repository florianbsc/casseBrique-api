package app.Formes.Services;

import app.Formes.Repository.FormeGeoRepository;
import app.Formes.models.FormeGeo;
import app.Formes.models.Niveau;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormeGeoService {

    private final FormeGeoRepository formeGeoRepository;

    public FormeGeoService(FormeGeoRepository formeGeoRepository) {
        this.formeGeoRepository = formeGeoRepository;
    }

    public List<FormeGeo> getAllFormes() {
        return formeGeoRepository.findAll();
    }

    public FormeGeo getFormeById(Long id) {
        return formeGeoRepository.findById(id).orElse(null);
    }

    public FormeGeo createForme(FormeGeo forme) {
        return formeGeoRepository.save(forme);
    }

    public void deleteFormeById(Long id) {
        formeGeoRepository.deleteById(id);
    }

    public FormeGeo saveFormeGeo(FormeGeo forme) {
        return formeGeoRepository.save(forme);
    }



}
