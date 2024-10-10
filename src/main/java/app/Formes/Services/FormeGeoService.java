package app.Formes.Services;

import app.Formes.Repository.FormeGeoRepository;
import app.Formes.models.FormeGeo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormeGeoService {

    private final FormeGeoRepository formeGeoRepository;

    public FormeGeoService(FormeGeoRepository formeGeoRepository) {
        this.formeGeoRepository = formeGeoRepository;
    }

    public FormeGeo saveFormeGeo(FormeGeo forme) {
        return formeGeoRepository.save(forme);
    }

    public List<FormeGeo> getAllFormes() {
        return formeGeoRepository.findAll();
    }

}
