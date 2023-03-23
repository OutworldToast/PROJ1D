package org.example;

import org.example.klant.Klant;

public class PrijsOpgave {

    private Klant klantnaam;
   ///private Schip schiptype;
    private String specificaties;
    private double materialeKosten;
    private int arbeidsuren;
    private double uurtarief;

    public PrijsOpgave(Klant klantnaam, String specificaties, double materialeKosten, int arbeidsuren, double uurtarief) {
        this.klantnaam = klantnaam;
        this.specificaties = specificaties;
        this.materialeKosten = materialeKosten;
        this.arbeidsuren = arbeidsuren;
        this.uurtarief = uurtarief;
    }

    public Klant getKlantnaam() {
        return klantnaam;
    }

    public void setKlantnaam(Klant klantnaam) {
        this.klantnaam = klantnaam;
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
        System.out.println("Prijsopgave voor " + getKlantnaam());
       // System.out.println("Scheepsbouwproject: " + schipType + " met " + specificaties);
        System.out.println("Materialenkosten: €" + getMaterialeKosten());
        System.out.println("Arbeidsuren: " + getArbeidsuren());
        System.out.println("Uurtarief: €" + getUurtarief());
        System.out.println("Totale kosten: €" + berekenTotaleKosten());
    }

}
