package org.example;

import org.example.klant.Klant;
import org.example.offerte.Offerte;
import org.example.offerte.Onderdeel;

import java.sql.SQLOutput;
import java.util.Date;

public class PrijsOpgave {

    private Klant klantnaam;
    ///private Schip schiptype;

    private Offerte offerte;

    private TotaalLijst totaalLijst;

    private Date date;






    public PrijsOpgave(Klant klantnaam, Offerte offerte, TotaalLijst totaalLijst) {
        this.klantnaam = klantnaam;
        this.offerte = offerte;
        this.totaalLijst = totaalLijst;
    }

    public Klant getKlantnaam() {
        return klantnaam;
    }

    public void setKlantnaam(Klant klantnaam) {
        this.klantnaam = klantnaam;
    }

    public Offerte getOfferte() {
        return offerte;
    }

    public void setOfferte(Offerte offerte) {
        this.offerte = offerte;
    }

    public TotaalLijst getTotaalLijst() {
        return totaalLijst;
    }

    public void setTotaalLijst(TotaalLijst totaalLijst) {
        this.totaalLijst = totaalLijst;
    }





    public void toonPrijsopgave() {

        String strOfferte = "PRIJSOPGAVE";
        String strResult = "TOTAAL ONDERDELEN: ";
        String strHoeveelheid = "HVH";
        String strBeschrijving  = "BESCHRIJVING";
        String strVerkoper = "VERKOPER";
        String strPrijsPerEenheid = "PRIJS PER EENHEID";
        String strRegelTotaal = "REGELTOTAAL";
        String strKorting = "KORTING";
        String strBtw = "BTW";
        String strCategorie = "CATEGORIE";

        double totaal = 0;
        double result = 0;
        int teller = 1;

        System.out.printf( "%60s\n", strOfferte);
        System.out.print("-------------------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("02-01-2023");
        System.out.println("AAN: "+ klantnaam.getNaam());
        System.out.printf("%-20s | %-20s| %-20s | %-20s  | %-20s\n ", strHoeveelheid,strCategorie, strBeschrijving,strPrijsPerEenheid, strRegelTotaal);
        System.out.print("-------------------------------------------------------------------------------------------------------\n");




        for (Onderdeel t : totaalLijst.getTotaalLijst()
        ) {
            String strgezochtOnderdeel = t.getNaam();
            result += totaal + t.getPrijs();
            if (t.equals(strgezochtOnderdeel)){
                teller++;
            }



            System.out.printf("%-20s   %-20s  %-20s  € %.2f%n", teller, t.getCategorie(), t.getNaam(), t.getPrijs()); // HOVEELHEID PER ONDERDEEL
            System.out.println();

        }
        System.out.print("-------------------------------------------------------------------------------------------------------\n");

        System.out.printf("%-60s  %-60s  \n", strKorting, klantnaam.getKortingAlsPercentage()); //
        System.out.printf("%-60s\n", strBtw ); // BEREKEN BTW
        System.out.printf("%-90s  € %.2f%n", strResult,  result );











    }

}
