package app.Formes.Repository;

import app.Formes.models.Cercle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CercleRepository extends JpaRepository<Cercle, Long> {
//    Cercle findById(Long id);
}
