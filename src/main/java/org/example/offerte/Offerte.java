package org.example.offerte;

import org.example.TotaalLijst;
import org.example.klant.Klant;

public class Offerte {
    private String beschrijving;
    private TotaalLijst opties;
    private Klant klant;

    public Offerte(String beschrijving, Klant klant, TotaalLijst opties) {
        this.beschrijving = beschrijving;
        this.klant = klant;
        this.opties = opties;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public TotaalLijst getOpties() {
        return opties;
    }

    public void setOpties(TotaalLijst opties) {
        this.opties = opties;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public double getTotaalPrijs() {
        double totaalPrijs = 0.0;

        for(Onderdeel optie : opties.getGekozenOpties()) {
            totaalPrijs += optie.getPrijs();
        }

        return totaalPrijs;
    }

}
