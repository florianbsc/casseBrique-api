package app.Formes.Controllers;

import app.Formes.Services.TriangleService;
import app.Formes.models.Triangle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Triabgle")
public class TriangleController {
    private TriangleService triangleService;
    public TriangleController(TriangleService triangleService) {
        this.triangleService = triangleService;
    }

//    @GetMapping
//    public List<Triangle> getAllTriangles() {
//        return triangleService.getAllTriangles();
//    }

}
