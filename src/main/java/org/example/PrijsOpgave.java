package org.example;

import org.example.klant.Klant;

import java.sql.SQLOutput;
import java.util.Date;

public class PrijsOpgave {

    private Klant klant;
   ///private Schip schiptype;
    private String specificaties;
    private double materialeKosten;
    private int arbeidsuren;
    private double uurtarief;

<<<<<<< HEAD
    private Offerte offerte;

    private TotaalLijst totaalLijst;

    private Date date;






    public PrijsOpgave(Klant klantnaam, Offerte offerte, TotaalLijst totaalLijst) {
        this.klantnaam = klantnaam;
        this.offerte = offerte;
        this.totaalLijst = totaalLijst;
=======
    public PrijsOpgave(Klant klant, String specificaties, double materialeKosten, int arbeidsuren, double uurtarief) {
        this.klant = klant;
        this.specificaties = specificaties;
        this.materialeKosten = materialeKosten;
        this.arbeidsuren = arbeidsuren;
        this.uurtarief = uurtarief;
>>>>>>> parent of f4e9fce (prisjopgave)
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public String getSpecificaties() {
        return specificaties;
    }

    public void setSpecificaties(String specificaties) {
        this.specificaties = specificaties;
    }

    public double getMaterialeKosten() {
        return materialeKosten;
    }

    public void setMaterialeKosten(double materialeKosten) {
        this.materialeKosten = materialeKosten;
    }

    public int getArbeidsuren() {
        return arbeidsuren;
    }

    public void setArbeidsuren(int arbeidsuren) {
        this.arbeidsuren = arbeidsuren;
    }

    public double getUurtarief() {
        return uurtarief;
    }

    public void setUurtarief(double uurtarief) {
        this.uurtarief = uurtarief;
    }

<<<<<<< HEAD
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

        System.out.printf("%-60s\n", strKorting); //
        System.out.printf("%-60s\n", strBtw ); // BEREKEN BTW
        System.out.printf("%-90s  € %.2f%n", strResult,  result );










=======
    public double berekenTotaleKosten() {
        return getMaterialeKosten()  + (getArbeidsuren() * getUurtarief());
    }
>>>>>>> parent of f4e9fce (prisjopgave)

    public void printPrijsopgave() {
        System.out.println("Prijsopgave voor " + klant.getNaam());
       // System.out.println("Scheepsbouwproject: " + schipType + " met " + specificaties);
        System.out.println("Materialenkosten: €" + materialeKosten);
        System.out.println("Arbeidsuren: " + arbeidsuren);
        System.out.println("Uurtarief: €" + uurtarief);
        System.out.println("Totale kosten: €" + berekenTotaleKosten());
    }

}
