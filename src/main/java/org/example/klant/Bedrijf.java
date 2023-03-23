package org.example.klant;

public class Bedrijf extends Klant {
    int KVKNummer;

    public void setKVKNummer(int KVKNummer) {
        this.KVKNummer = KVKNummer;
    }

    public Bedrijf(String naam, String email, int KVKNummer) {
        super(naam, email);
        this.KVKNummer = KVKNummer;
        kortingAlsPercentage = 8;
    }

    @Override
    public void printKlantInfo() {
        setKortingAlsPercentage(3);
        super.printKlantInfo();
    }

}
