package app;

import app.Http.Models.Carre;
import app.Http.Models.Cercle;
import app.Http.Models.Niveau;
import app.Http.Models.Triangle;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NiveauTest {
    private Niveau niveau;

    @BeforeEach
    public void setUp() {
        niveau = new Niveau();
        Triangle tri = new Triangle(3);
        Carre car = new Carre(3);
        Cercle cer = new Cercle(3);

        niveau.addForme(car);
        niveau.addForme(cer);
        niveau.addForme(tri);
    }

    @Test
    public void When_addForme_RETURN_formeAdded() {
        Carre carTest = new Carre(66);
        Niveau niveau1 = niveau;
        niveau1.addForme(carTest);
        niveau1.dispayNiveau();
    }

    @Test
    public void When_deleteForme_RETURN_formeDeleted() {}

    @Test
    public void When_clearNiveau_deleteAllFormes() {}

    @Test
    public void When_getForme_RETURN_Listforme() {
        Carre carTest = new Carre(66);
        Triangle triTest = new Triangle(66);

        niveau.addForme(carTest);
        niveau.addForme(triTest);

        niveau.dispayNiveau();
    }

    @Test
    public void When_calculteAllAera_RETURN_TotalAllAera() {


    }
}
