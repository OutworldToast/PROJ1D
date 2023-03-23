package org.example.offerte;

public class OfferteOptie {
    private String naam; //naam van de optie
    private String categorie; //bijbehorende categorie (essentieel of extra)
    private double prijs; //prijs van de optie
    private int milieuvriendelijkekorting;//Berekende korting voor elk onderdeel indien van toepassing

    public OfferteOptie(String naam, String categorie, double prijs,int milieuvriendelijkekorting) {
        this.naam = naam;
        this.categorie = categorie;
        this.prijs = prijs;
        this.milieuvriendelijkekorting = milieuvriendelijkekorting;
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

    public void setKortingPercentage(int percentage) {
        this.milieuvriendelijkekorting = percentage;
    }

    public double getKortingPercentage() {//Methode
        return this.milieuvriendelijkekorting;
    }

    public void voegMilieuvriendelijkeKortingToe(int percentage){//Methode (Korting toepassen)
        this.setKortingPercentage(percentage);
    }

    public double berekenGereduceerdePrijs(double prijs) {//Nieuwprijs na korting
        double gereduceerdePrijs = prijs * (1 - this.getKortingPercentage());
        return gereduceerdePrijs;
    }
}
