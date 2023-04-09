package org.example;

import org.example.klant.Bedrijf;
import org.example.klant.Klant;

import org.example.offerte.Offerte;
import org.example.offerte.Onderdeel;

import java.util.Date;

public class PrijsOpgave {

    private Klant klant;
    private Offerte offerte;
    private TotaalLijst totaalLijst;
    private Date date;

    double result;

    public PrijsOpgave(Klant klant, Offerte offerte, TotaalLijst totaalLijst, Date date) {
        this.klant = klant;
        this.offerte = offerte;
        this.totaalLijst = totaalLijst;
        this.date = date;
    }

    public Klant getKlant() {
        return klant;
    }

    public double berekenBtw(double bedragZonderBtw, double btwPercentage) {
        result = bedragZonderBtw * (btwPercentage / 100);
        return result;
    }

    public static double berekenRegelTotaal(double prijs, int hoeveelheid, double milieukorting) {

        double regelTotaal = prijs * hoeveelheid * ((100 - milieukorting) / 100.0);
        return regelTotaal;
    }

    public void toonPrijsopgave() {

        String strPrijsOpgave = "PRIJSOPGAVE";
        String strResult = "TOTAAL ONDERDELEN: ";
        String strHoeveelheid = "HVH";
        String strBeschrijving  = "BESCHRIJVING";
        String strNaam = "NAAM:";
        String strPrijsPerEenheid = "PRIJS PER EENHEID";
        String strRegelTotaal = "SUBTOTAAL";
        String strKorting = "KORTING";
        String strBtw = "BTW";
        String strCategorie = "CATEGORIE";
        String strTotaal = "TOTAAL TE BETALEN";

        double totaal = 0.0;
        double subTotaal = 0.0;
        int teller = 0;
        double regelTotaal;
        double korting = 0.0;
        double btwPercentage = 21.0;



        System.out.printf( "%70s\n", strPrijsOpgave);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("DATUM: " + date);
        System.out.println("AAN: " + offerte.getKlant().getNaam());

        System.out.println("SCHIP: "  + offerte.getSchip());
        System.out.println();
        System.out.printf("%-20s | %-20s| %-20s | %-20s | %-20s | %-20s\n ", strHoeveelheid,strCategorie, strBeschrijving,strPrijsPerEenheid,strKorting, strRegelTotaal);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        for (Onderdeel t : totaalLijst.getTotaalLijst()
        ) {

            regelTotaal = t.getPrijs() * t.getHoeveelheid() * ((100 - t.getMilieukorting())/100.0);

            System.out.printf("%-20s   %-20s  %-20s  € %.2f                 %3d%%                  € %.2f  ", t.getHoeveelheid(), t.getCategorie(), t.getNaam(), t.getPrijs(),t.getMilieukorting(), regelTotaal);
            System.out.println();

            totaal += regelTotaal;

        }

        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-112s  € %.2f%n", strRegelTotaal,  totaal);
        System.out.printf("%-112s  € %.2f%n", strBtw, berekenBtw(totaal, btwPercentage) );
        System.out.printf("%-112s  € %.2f%n", strTotaal, result + totaal) ;

    }

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
