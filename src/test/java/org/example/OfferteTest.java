package org.example;
import org.example.TotaalLijst;
import org.example.klant.Klant;
import org.example.offerte.Offerte;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OfferteTest {


    @Test
    public void berekenTotaalPrijsTest() {
        Klant klant = new Klant("Mark", "markie@hotmail.com");
        Offerte offerte = new Offerte("Test beschrijving", klant);


        double totaalPrijs = offerte.berekenTotaalPrijs();

        Assert.assertEquals(totaalPrijs, 3961.54);
    }
}
