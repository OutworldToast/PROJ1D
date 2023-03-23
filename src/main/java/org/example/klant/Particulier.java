package org.example.klant;

public class Particulier extends Klant {

    @Override
    public void printKlantInfo() {
        setKortingAlsPercentage(0);
        super.printKlantInfo();
    }
}

