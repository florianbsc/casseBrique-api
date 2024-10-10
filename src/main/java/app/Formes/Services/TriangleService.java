package app.Formes.Services;

import app.Formes.Repository.TriangleRepository;
import app.Formes.models.Triangle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriangleService {
    private TriangleRepository triangleRepository;
    public TriangleService(TriangleRepository triangleRepository) {
        this.triangleRepository = triangleRepository;
    }

//    public List<Triangle> getAllTriangles() {
//        return triangleRepository.getAllTriangles();
//    }
}
