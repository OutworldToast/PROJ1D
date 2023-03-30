
import org.example.TotaalLijst;
import org.example.klant.Klant;
import org.example.klant.Particulier;
import org.example.offerte.Offerte;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OfferteTest {


    @Test
    public void printTotaalPrijsTest() {
        Klant klant = new Particulier("Mark", "markie@hotmail.com");
        Offerte offerte = new Offerte("Test beschrijving", klant);

        offerte.getSchip().voegOnderdeelToe(1);

        double totaalPrijs = offerte.getTotaalPrijs();

        Assert.assertEquals(totaalPrijs, 46.50);
    }
}
