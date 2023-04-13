package org.example;

import org.example.klant.Bedrijf;
import org.example.klant.Klant;

import org.example.offerte.Offerte;
import org.example.offerte.Onderdeel;

import java.util.Date;

public class PrijsOpgave {

    private  Klant klant;
    private  Offerte offerte;
    private TotaalLijst totaalLijst = Loop.totaalLijst;
    private Date date;

    public double result;

    double regelTotaal;

    public PrijsOpgave(Klant klant, Offerte offerte, Date date) {
        this.klant = klant;
        this.offerte = offerte;
        this.totaalLijst = totaalLijst;
        this.date = date;
    }

    public Klant getKlant() {
        return klant;
    }

    public double berekenBtw(double bedragZonderBtw) {
        result = bedragZonderBtw * (21 / 100);
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
        String strMilieuKorting = "MILIEUKORTING";
        String strKlantKorting = "KORTING";
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

        System.out.println("BESCHRIJVING: "  + offerte.getBeschrijving());
        System.out.println();
        System.out.printf("%-5s | %-20s| %-20s\t | %-20s | %-20s | %-20s\n ", strHoeveelheid,strCategorie, strBeschrijving,strPrijsPerEenheid, strMilieuKorting, strRegelTotaal);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

        for (Onderdeel t : offerte.getSchip().getOnderdeelLijst()){

            regelTotaal = t.getPrijs() * t.getHoeveelheid() * ((100 - t.getMilieukorting())/100.0);

            System.out.printf("%-5s   %-20s  %-20s\t  € %.2f                 %-3d%%\t                  € %.2f  ", t.getHoeveelheid(), t.getCategorie(), t.getNaam(), t.getPrijs(),t.getMilieukorting(), regelTotaal);
            System.out.println();

            totaal += regelTotaal;
            korting = offerte.getKlant().getKortingAlsPercentage();
            korting -= regelTotaal;

            korting = totaal * offerte.getKlant().getKortingAlsPercentage() /100;
        }


        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-100s  € %.2f%n", strMilieuKorting,  korting);
        System.out.printf("%-100s  € %.2f%n", strRegelTotaal,  totaal);
        System.out.printf("%-100s  € %.2f%n", strKlantKorting, korting);
        System.out.printf("%-100s  € %.2f%n", strRegelTotaal,  totaal - korting);
        System.out.printf("%-100s  € %.2f%n", strBtw, berekenBtw(totaal - korting) );
        System.out.printf("%-100s  € %.2f%n", strTotaal, result + totaal - korting) ;
        System.out.println();
        System.out.println();
        System.out.println("                                                     <<<<  DREAM TEAM >>>>");


    }

    public static void main(String[] args) {
        // Start de main loop.


        Klant k1 = new Bedrijf("Jantje gebruiker", "jan@gmail.com",123456);
        k1.setKortingAlsPercentage(20);
        Offerte ofe = new Offerte("mijOffr", k1);
        TotaalLijst t1 = new TotaalLijst();
        Date dateToday = new Date();
        t1.getTotaalLijst().get(6).setMilieukorting(10);


        PrijsOpgave prijsOpgave = new PrijsOpgave(k1,ofe,dateToday);



        prijsOpgave.toonPrijsopgave();
    }



}
