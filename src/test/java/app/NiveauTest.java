package app;

import app.Formes.models.Carre;
import app.Formes.models.Cercle;
import app.Formes.models.Niveau;
import app.Formes.models.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NiveauTest {
    private Niveau niveau;

    @BeforeEach
    public void setUp() {
        niveau = new Niveau();
        Triangle tri = new Triangle(3, 4, 4);
        Carre car = new Carre(3, 8, 8);
        Cercle cer = new Cercle(3, 0, 0);

        niveau.addForme(car);
        niveau.addForme(cer);
        niveau.addForme(tri);
    }

    @Test
    public void When_addForme_RETURN_formeAdded() {
        Carre carTest = new Carre(66, 8, 8);
        Niveau niveau1 = niveau;
        niveau1.addForme(carTest);
        niveau1.displayNiveau();
    }

    @Test
    public void When_deleteForme_RETURN_formeDeleted() {}

    @Test
    public void When_clearNiveau_deleteAllFormes() {}

    @Test
    public void When_getForme_RETURN_Listforme() {
        Carre carTest = new Carre(66, 8, 8);
        Triangle triTest = new Triangle(66, 4, 4);

        niveau.addForme(carTest);
        niveau.addForme(triTest);

        niveau.displayNiveau();
    }

    @Test
    public void When_calculteAllAera_RETURN_TotalAllAera() {


    }
}
