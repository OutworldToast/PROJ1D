package org.example;

import org.example.klant.Bedrijf;
import org.example.klant.Klant;
import org.example.offerte.Offerte;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrijsOpgaveTest {



    @Test
    void BerekenBTWTest(){
        Klant klant = new Klant("","");
        PrijsOpgave p = new PrijsOpgave(new Offerte("", klant),new Date());
        assertEquals(21,p.berekenBtw(100,0,0));
    }

    @Test
    void berekenTotaalTest(){

        Klant k1 = new Bedrijf("Jantje gebruiker", "jan@gmail.com",123456);
        k1.setKortingAlsPercentage(8);
        Offerte ofe = new Offerte("mijOffr", k1);
        TotaalLijst t1 = new TotaalLijst();
        Date dateToday = new Date();
        PrijsOpgave prijsOpgave = new PrijsOpgave(ofe,dateToday);





    }

    @Test
    void berekenRegelTotaalTest(){

        Klant k1 = new Bedrijf("Jantje gebruiker", "jan@gmail.com",123456);
        Offerte ofe = new Offerte("mijOffr", k1);
        TotaalLijst t1 = new TotaalLijst();
        Date dateToday = new Date();
        PrijsOpgave prijsOpgave = new PrijsOpgave(ofe,dateToday);
        assertEquals(300,prijsOpgave.berekenRegelTotaal(100,3,0));


    }

    @Test
    void berekeningKortingTest(){

            Klant k1 = new Klant("Test", "Test");
            Offerte offerte = new Offerte("TestOfferte", k1);
            Date dateToday = new Date();
            offerte.getSchip().getOnderdeelLijst().get(4).setMilieukorting(50);
            offerte.getKlant().setKortingAlsPercentage(10);
            PrijsOpgave prijsOpgave = new PrijsOpgave(offerte,dateToday);


            assertEquals(100,prijsOpgave.berekenKorting(200,50));





    }





}
