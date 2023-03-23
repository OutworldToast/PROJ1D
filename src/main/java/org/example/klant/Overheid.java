package org.example.klant;

public class Overheid extends Klant {
    String Gemeente;

    public void setKlantInfo(String naam, String email, String Gemeente) {
        this.Gemeente = Gemeente;
        super.setKlantInfo(naam, email);
    }

    @Override
    public void printKlantInfo() {
        setKortingAlsPercentage(21);
        super.printKlantInfo();
    }
}
