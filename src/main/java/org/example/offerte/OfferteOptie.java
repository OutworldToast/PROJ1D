package org.example.offerte;

public class OfferteOptie {
    private String naam; //naam van de optie
    private String categorie; //bijbehorende categorie (essentieel of extra)
    private double prijs; //prijs van de optie

    public OfferteOptie(String naam, String categorie, double prijs) {
        this.naam = naam;
        this.categorie = categorie;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
