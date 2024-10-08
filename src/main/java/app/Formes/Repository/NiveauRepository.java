package app.Formes.Repository;

import app.Formes.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    Niveau findById(long id);
}
