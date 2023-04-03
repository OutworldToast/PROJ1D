import org.example.Loop;
import org.example.PrijsOpgave;
import org.example.TotaalLijst;
import org.example.klant.Klant;
import org.example.offerte.Offerte;

import java.util.Date;

public class TestPrijsOpgave {



    public static void main(String[] args) {
        // Start de main loop.


        Klant k1 = new Klant("Jantje", "jan@gmail.com");
        Offerte ofe = new Offerte("mijOffr", k1);
        TotaalLijst t1 = new TotaalLijst();
        Date dateToday = new Date();
        PrijsOpgave prijsOpgave = new PrijsOpgave(k1,ofe,t1,dateToday);

        prijsOpgave.toonPrijsopgave();
    }

}
