package org.example.offerte;

import org.example.klant.Klant;
import org.example.OptieLijst;

public class Offerte {
    private String beschrijving;
    private OptieLijst opties;
    private Klant klant;

    public Offerte(String beschrijving, Klant klant, OptieLijst opties) {
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

    public OptieLijst getOpties() {
        return opties;
    }

    public void setOpties(OptieLijst opties) {
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

        for(OfferteOptie optie : opties.getGekozenOpties()) {
            totaalPrijs += optie.getPrijs();
        }

        return totaalPrijs;
    }

}
