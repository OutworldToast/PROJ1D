package org.example;
import org.example.klant.Bedrijf;
import org.example.klant.Klant;
import org.example.offerte.Offerte;
import org.example.offerte.Onderdeel;
import java.util.Date;

public class PrijsOpgave {
    private final Offerte offerte;
    private final Date date;

    public PrijsOpgave(Offerte offerte, Date date) {
        this.offerte = offerte;
        this.date = date;
    }

    public static double berekenBtw(double bedragZonderBtw) {
        return bedragZonderBtw * (21.0 / 100.0);
    }


    public double berekenRegelTotaal(double prijs, int hoeveelheid, double milieukorting) {
        return prijs * hoeveelheid * ((100 - milieukorting) / 100.0);
    }

    public void toonPrijsopgave() {

        String strMilieuKorting = "MILIEUKORTING";
        String strRegelTotaal = "SUBTOTAAL";
        String strKlantKorting = "KLANTKORTING";
        String strBtw = "BTW";
        String strTotaal = "TOTAAL TE BETALEN";

        System.out.printf( "%70s\n", "PRIJSOPGAVE");
        System.out.println("==============================================================================================================================");
        System.out.println();

        System.out.println("DATUM: " + date);
        System.out.println("AAN: " + offerte.getKlant().getNaam());

        System.out.println("BESCHRIJVING: "  + offerte.getBeschrijving());
        System.out.println();
        System.out.printf("%-5s | %-20s| %-20s\t | %-20s | %-20s | %-20s\n ", "HVH", "CATEGORIE",
                "BESCHRIJVING", "PRIJS PER EENHEID", strMilieuKorting, strRegelTotaal);
        System.out.println("==============================================================================================================================");

        double totaal = 0.0;
        double totaalMilieuKorting = 0.0;

        offerte.getSchip().getOnderdeelLijst().get(6).setMilieukorting(20);

        for (Onderdeel t : offerte.getSchip().getOnderdeelLijst()){

            double milieuKorting = t.getMilieukorting();
            double subRegelTotaal = t.getPrijs() * t.getHoeveelheid();
            double regelTotaal = berekenRegelTotaal(t.getPrijs(), t.getHoeveelheid(), milieuKorting);
            totaalMilieuKorting += subRegelTotaal - regelTotaal;
            totaal += regelTotaal;

            System.out.printf("%-5s   %-20s  %-20s\t  € %-20.2f %.1f%-18%\t € %.2f  ", t.getHoeveelheid(), t.getCategorie(), t.getNaam(), t.getPrijs(),milieuKorting, regelTotaal);
            System.out.println();


        }

        double korting = totaal * offerte.getKlant().getKortingAlsPercentage()/100;
        double result = berekenBtw(totaal - korting);

        System.out.println("==============================================================================================================================");
        System.out.printf("%-100s € %.2f-%n", strMilieuKorting, totaalMilieuKorting);
        System.out.printf("%-100s € %.2f%n", strRegelTotaal,  totaal);
        System.out.printf("%-100s € %.2f-%n", strKlantKorting, korting);
        System.out.printf("%-100s € %.2f%n", strBtw, result);
        System.out.println("==============================================================================================================================");
        System.out.printf("%-100s € %.2f%n", strTotaal, result + totaal - korting) ;
        System.out.println();
        System.out.println("                                                     <<<< DREAM TEAM >>>>");


    }

}
