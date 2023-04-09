import org.example.Loop;
import org.example.PrijsOpgave;
import org.example.TotaalLijst;
import org.example.klant.Bedrijf;
import org.example.klant.Klant;
i
import org.example.offerte.Offerte;
import org.example.offerte.Onderdeel;
import org.example.schip.Schip;

import java.util.Date;

public class TestPrijsOpgave {



    public static void main(String[] args) {
        // Start de main loop.


        Klant k1 = new Bedrijf("Jantje", "jan@gmail.com",123456);
        Offerte ofe = new Offerte("mijOffr", k1);
        TotaalLijst t1 = new TotaalLijst();
        Date dateToday = new Date();


        PrijsOpgave prijsOpgave = new PrijsOpgave(k1,ofe,t1,dateToday);
        t1.getTotaalLijst().get(6).setMilieukorting(20);



        prijsOpgave.toonPrijsopgave();
    }



}
