package org.example.offerte;

import org.example.klant.Klant;
import org.example.schip.Schip;

import java.util.ArrayList;
import java.util.Scanner;

public class Offerte {
    private String beschrijving;
    private Klant klant;
    private final Schip schip;

    public Offerte(String beschrijving, Klant klant) {
        this.beschrijving = beschrijving;
        this.klant = klant;
        schip = new Schip();
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Schip getSchip() {
        return schip;
    }

    public double berekenTotaalPrijs() {

        double totaalPrijs = 0.0;

        for(Onderdeel onderdeel : schip.getOnderdeelLijst()) {
            double prijs = onderdeel.getPrijs();

            int milieukorting = onderdeel.getMilieukorting();

            prijs -= (milieukorting / 100.0) * prijs;

            totaalPrijs += prijs;
        }

        return totaalPrijs;
    }

}
