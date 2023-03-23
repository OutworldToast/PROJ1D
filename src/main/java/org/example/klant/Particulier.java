package org.example.klant;

public class Particulier extends Klant {
    public Particulier(String naam, String email) {
        super(naam, email);
        this.setKortingAlsPercentage(8);
    }

    @Override
    public void printKlantInfo() {
        super.printKlantInfo();
    }
}

