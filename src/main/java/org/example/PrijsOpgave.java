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

    public double berekenBtw(double bedragZonderBtw, double klantkorting) {
        return  (bedragZonderBtw - klantkorting) * (21.0 / 100.0);

    }


    public double berekenRegelTotaal(double prijs, int hoeveelheid, double milieukorting) {
        return  prijs * hoeveelheid * ((100 - milieukorting) / 100.0);

    }

    private double berekenKorting(double bedragZonderKorting,double klantKorting) {
        return  bedragZonderKorting * (klantKorting / 100.0);
    }

    public double berekenTotaal(double subtotaal, double kortingBedrag, double btwBedrag) {
        return subtotaal  - kortingBedrag + btwBedrag;
    }

    public void toonPrijsopgave() {


        double milieuKorting;
        double totaal = 0.0;
        double regelTotaal;
        double btw = 0.0;
        double klantkorting = 0.0;


        System.out.printf( "%70s\n", "PRIJSOPGAVE");
        System.out.println("==============================================================================================================================");
        System.out.println();

        System.out.println("DATUM: " + date);
        System.out.println("AAN: " + offerte.getKlant().getNaam());

        System.out.println("BESCHRIJVING: "  + offerte.getBeschrijving());
        System.out.println();
        System.out.printf("%-5s | %-20s| %-20s\t | %-20s | %-20s | %-20s\n ", "HVH","CATEGORIE", "BESCHRIJVING","PRIJS PER EENHEID",
                "KORTING PER ONDERDEEL", "SUBTOTAAL");
        System.out.println("==============================================================================================================================");


        for (Onderdeel t : offerte.getSchip().getOnderdeelLijst()){

            regelTotaal = berekenRegelTotaal(t.getPrijs(),t.getHoeveelheid(),t.getMilieukorting());

            System.out.printf("%-5s   %-20s  %-20s\t  € %.2f                 %d%%\t                  € %.2f ",
                    t.getHoeveelheid(), t.getCategorie(), t.getNaam(), t.getPrijs(),t.getMilieukorting(), regelTotaal);
            System.out.println();

            totaal += regelTotaal;  //
            klantkorting = berekenKorting(totaal,offerte.getKlant().getKortingAlsPercentage());
            btw = berekenBtw(totaal,klantkorting);

        }

        System.out.println("==============================================================================================================================");
        System.out.printf("%-100s  € %.2f%n", "REGELTOTAAL",  totaal);
        System.out.printf("%-100s  € %.2f-%n", "KLANTKORTING", klantkorting);

        //System.out.printf("%-100s  € %.2f-%n", strMilieuKorting, milieuKorting);
        System.out.printf("%-100s  € %.2f%n", "BTW", btw);
        System.out.println("==============================================================================================================================");
       // System.out.printf("%-100s  € %.2f%n", strTotaal, result + totaal - korting);
        System.out.printf("%-100s  € %.2f%n", "TOTAAL TE BETALEN", berekenTotaal(totaal,klantkorting,btw));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                                                     <<<<  DREAM TEAM >>>>");
    }




    public static void main(String[] args) {
        // Start de main loop.


        Klant k1 = new Bedrijf("Jantje gebruiker", "jan@gmail.com",123456);
        k1.setKortingAlsPercentage(8);
        Offerte ofe = new Offerte("mijOffr", k1);
        TotaalLijst t1 = new TotaalLijst();
        Date dateToday = new Date();
        PrijsOpgave prijsOpgave = new PrijsOpgave(ofe,dateToday);
        t1.getTotaalLijst().get(6).setMilieukorting(10);

        prijsOpgave.toonPrijsopgave();

    }



}
