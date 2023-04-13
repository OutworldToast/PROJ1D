package org.example.klant;

public class Aangepast extends Klant {
    private String extraInfo;

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Aangepast(String naam, String email, String extraInfo, int kortingAlsPercentage) {
        super(naam, email);
        this.extraInfo = extraInfo;
        setKortingAlsPercentage(kortingAlsPercentage);
    }



    @Override
    public void printKlantInfo() {
        super.printKlantInfo();
        System.out.println("Extra Info bedrijf: " + extraInfo);

    }

}