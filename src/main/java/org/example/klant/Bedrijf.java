package org.example.klant;

public class Bedrijf extends Klant {
    int KVKNummer;

    public void setKlantInfo(String naam, String email, int KVKNummer) {
        this.KVKNummer = KVKNummer;
        super.setKlantInfo(naam, email);
    }

    @Override
    public void printKlantInfo() {
        setKortingAlsPercentage(3);
        super.printKlantInfo();
    }

}
