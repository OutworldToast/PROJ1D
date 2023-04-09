package org.example.klant;

public class Overheid extends Klant {
    String Gemeente;

    public void setGemeente(String gemeente) {
        Gemeente = gemeente;
    }

    public Overheid(String naam, String email, String gemeente) {
        super(naam, email);
        Gemeente = gemeente;
        setKortingAlsPercentage(21);
    }

    @Override
    public void printKlantInfo() {
        super.printKlantInfo();
        System.out.println("De naam van de gemeente is: "+ Gemeente);
    }
}
