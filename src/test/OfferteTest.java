import org.example.OptieLijst;
import org.example.klant.Klant;
import org.example.klant.Particulier;
import org.example.offerte.Offerte;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OfferteTest {


    @Test
    public void printTotaalPrijsTest() {
        Klant klant = new Particulier();
        OptieLijst opties = new OptieLijst();
        opties.addOptie("Test Optie 1", "Essentieel", 25.0);
        opties.addOptie("Test Optie 2", "Essentieel", 21.50);
        Offerte offerte = new Offerte("Test beschrijving", klant, opties);

        double totaalPrijs = offerte.getTotaalPrijs();

        Assert.assertEquals(totaalPrijs, 46.50);
    }
}
