package org.example.offerte;

public class Onderdeel {

    private int hoeveelheid = 1;
    private String naam; //naam van de optie
    private String categorie; //bijbehorende categorie (essentieel of extra)
    private double prijs; //prijs van de optie
    private int milieukorting;//Berekende korting voor elk onderdeel indien van toepassing



    public Onderdeel(String naam, String categorie, double prijs, int milieukorting) {
        this.naam = naam;
        this.categorie = categorie;
        this.prijs = prijs;
        this.milieukorting = milieukorting;

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

    public void setMilieukorting(int percentage) {
        //check voor non-valide waardes
        this.milieukorting = percentage;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public int getMilieukorting() {//Methode
        return milieukorting;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void verhoogHoeveelheid() {
        hoeveelheid++;
    }

    public void verminderHoeveelheid() {
        hoeveelheid--;
    }

}
