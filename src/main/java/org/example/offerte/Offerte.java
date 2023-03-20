package org.example.offerte;

import org.example.Klant;
import org.example.OptieLijst;

import java.util.ArrayList;

public class Offerte {
    private String beschrijving;
    private OptieLijst opties;
    private Klant klant;

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

    Offerte(String beschrijving, Klant klant, Lijst opties) {
        this.beschrijving = beschrijving;
        this.klant = klant;
        this.opties = opties;
    }

}
