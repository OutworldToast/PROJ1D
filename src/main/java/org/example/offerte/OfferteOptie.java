package org.example.offerte;

public class OfferteOptie {
    private String naam; //naam van de optie
    private String categorie; //bijbehorende categorie (essentieel of extra)
    private double prijs; //prijs van de optie
    private int milieukorting;//Berekende korting voor elk onderdeel indien van toepassing

    public OfferteOptie(String naam, String categorie, double prijs, int milieukorting) {
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

    public int getMilieukorting() {//Methode
        return milieukorting;
    }

    public void voegMilieuvriendelijkeKortingToe(int percentage){//Methode (Korting toepassen)
        this.setMilieukorting(percentage);
    } //feedback

    public double berekenGereduceerdePrijs(double prijs) {//Nieuwprijs na korting
        double gereduceerdePrijs = prijs * (1 - this.getMilieukorting());
        return gereduceerdePrijs;
    }
}
