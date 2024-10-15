package app.Formes.Services;

import app.Formes.Repository.FormeGeoRepository;
import app.Formes.models.FormeGeo;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable("formes")
    public FormeGeo getFormeById(Long id) {
        return formeGeoRepository.findById(id).orElse(null);
    }

    @Transactional
    public FormeGeo saveFormeGeo(FormeGeo forme) {
        return formeGeoRepository.save(forme);
    }

    public boolean deleteFormeById(Long id) {
        formeGeoRepository.deleteById(id);
        return false;
    }



}
