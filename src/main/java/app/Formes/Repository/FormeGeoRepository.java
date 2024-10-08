package app.Formes.Repository;

import app.Formes.models.FormeGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormeGeoRepository extends JpaRepository<FormeGeo, Long> {
    FormeGeo findById(long id);

}
