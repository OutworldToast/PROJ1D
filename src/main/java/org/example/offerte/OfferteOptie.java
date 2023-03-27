package org.example.offerte;

public class OfferteOptie {
    private String naam; //naam van de optie
    private String categorie; //bijbehorende categorie (essentieel of extra)
    private double prijs; //prijs van de optie
    private int korting;//Berekende korting voor elk onderdeel indien van toepassing
    private boolean milieukorting;//False

    public OfferteOptie(String naam, String categorie, double prijs,int korting) {
        this.naam = naam;
        this.categorie = categorie;
        this.prijs = prijs;
        this.korting = korting;
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

    public void setMilieukorting(boolean milieukorting) {
        this.milieukorting = milieukorting;
    }

    public boolean getMilieukorting() {//Methode
        return milieukorting;
    }

    public int getKorting() {
        return korting;
    }

    public void setKorting(int korting) {
        this.korting = korting;
    }

}
