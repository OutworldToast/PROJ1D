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
        assertEquals(168,p.berekenBtw(1000,200));
        assertEquals(210,p.berekenBtw(1000,0));
    }

    @Test
    void berekenTotaalTest(){

        Klant k1 = new Bedrijf("Jantje gebruiker", "jan@gmail.com",123456);
        k1.setKortingAlsPercentage(8);
        Offerte ofe = new Offerte("mijOffr", k1);
        TotaalLijst t1 = new TotaalLijst();
        Date dateToday = new Date();
        PrijsOpgave prijsOpgave = new PrijsOpgave(ofe,dateToday);

       assertEquals(1210,prijsOpgave.berekenTotaal(2000,1000,210));
       assertEquals(121,prijsOpgave.berekenTotaal(100,0,21));
    }

    @Test
    void berekenRegelTotaalTest(){

        Klant k1 = new Bedrijf("Jantje gebruiker", "jan@gmail.com",123456);
        Offerte ofe = new Offerte("mijOffr", k1);
        TotaalLijst t1 = new TotaalLijst();
        Date dateToday = new Date();
        PrijsOpgave prijsOpgave = new PrijsOpgave(ofe,dateToday);

        assertEquals(80, prijsOpgave.berekenRegelTotaal(100,1,20));
        assertEquals(1200,prijsOpgave.berekenRegelTotaal(300,4,0));


    }

    @Test
    void berekenKortingTest(){

            TotaalLijst t1 = new TotaalLijst();
            t1.getTotaalLijst().get(1).setMilieukorting(10);
            t1.addOptie("TurboPropeller","Extra", Double.parseDouble("1200"),30);
            Klant k1 = new Bedrijf("Jantje gebruiker", "jan@gmail.com",123456);
            k1.setKortingAlsPercentage(8);
            Offerte offerte = new Offerte("mijOffr", k1);
            Date dateToday = new Date();
            PrijsOpgave prijsOpgave = new PrijsOpgave(offerte,dateToday);
            prijsOpgave.toonPrijsopgave();


    }





}
