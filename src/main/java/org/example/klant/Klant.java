package org.example.klant;

import java.util.ArrayList;

public class Klant {
    // De main klant waarvan alle andere overerven met hieronder de variabelen
    private String naam;
    protected int kortingAlsPercentage;
    private String email;

    public static void printArrayList(ArrayList<Klant> klantArrayList){
        for (Klant klant : klantArrayList) {
            klant.printKlantInfo();
        }
    }
    public Klant(String naam, String email) {
        this.naam = naam;
        this.email = email;
    }

    // De getters en Setters voor de variabelen
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public int getKortingAlsPercentage() {
        return kortingAlsPercentage;
    }

    public void setKortingAlsPercentage(int kortingAlsPercentage) {
        this.kortingAlsPercentage = kortingAlsPercentage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printKlantInfo() {
        System.out.println("De naam van de klant is: " + getNaam());
        System.out.println("De email die opgegeven is: " + getEmail());
        System.out.println("De korting voor deze klant is: " + getKortingAlsPercentage());
    }
    public void veranderKlantInfo(){
        //hier moet nog code komen om de Info van elke klant te veranderen.
    }

}

