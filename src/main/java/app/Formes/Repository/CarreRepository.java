package app.Formes.Repository;

import app.Formes.models.Carre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreRepository extends JpaRepository<Carre, Long> {
    Carre findById(long id);
}
