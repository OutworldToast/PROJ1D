package org.example;

import java.util.ArrayList;

public class Offerte {
    private String beschrijving;
    private Lijst opties;
    private Klant klant;

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Lijst getOpties() {
        return opties;
    }

    public void setOpties(Lijst opties) {
        this.opties = opties;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    Offerte(String beschrijving, Klant klant, Lijst opties) {
        this.beschrijving = beschrijving;
        this.klant = klant;
        this.opties = opties;
    }

}
