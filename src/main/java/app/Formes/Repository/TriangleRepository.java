package app.Formes.Repository;

import app.Formes.models.Triangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriangleRepository  extends JpaRepository<Triangle, Long> {
    Triangle findById(long id);
}
