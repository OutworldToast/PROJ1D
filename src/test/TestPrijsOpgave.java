import org.example.PrijsOpgave;
import org.example.TotaalLijst;
import org.example.klant.Klant;
import org.example.offerte.Offerte;

public class TestPrijsOpgave {



public static void main(String[] args){
    Klant k1 = new Klant("Jantje", "jan@gmail.com");
    Offerte ofe = new Offerte("mijOffr", k1);
    TotaalLijst t1 = new TotaalLijst();
    PrijsOpgave prijsOpgave = new PrijsOpgave(k1,ofe,t1);

}
}

