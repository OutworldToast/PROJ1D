package org.example;

import org.example.klant.Klant;
import org.example.offerte.Offerte;

import java.sql.SQLOutput;
import java.util.Date;

public class PrijsOpgave {

    private Klant klant;
   ///private Schip schiptype;
    private String specificaties;
    private double materialeKosten;
    private int arbeidsuren;
    private double uurtarief;

    private Offerte offerte;

    private TotaalLijst totaalLijst;

    private Date date;






    public PrijsOpgave(Klant klant, String specificaties, double materialeKosten, int arbeidsuren, double uurtarief) {
        this.klant = klant;
        this.specificaties = specificaties;
        this.materialeKosten = materialeKosten;
        this.arbeidsuren = arbeidsuren;
        this.uurtarief = uurtarief;
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

    public double berekenTotaleKosten() {
        return getMaterialeKosten()  + (getArbeidsuren() * getUurtarief());
    }

    public void printPrijsopgave() {
        System.out.println("Prijsopgave voor " + klant.getNaam());
       // System.out.println("Scheepsbouwproject: " + schipType + " met " + specificaties);
        System.out.println("Materialenkosten: €" + materialeKosten);
        System.out.println("Arbeidsuren: " + arbeidsuren);
        System.out.println("Uurtarief: €" + uurtarief);
        System.out.println("Totale kosten: €" + berekenTotaleKosten());
    }

}
