package org.example;

public class Klant {
private String naam;
int kortingAlsPercentage;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Klant() {
        System.out.println("De naam van de klant is:" + naam );
    }
}
class Particulier extends Klant{
    String email;
    public Particulier() {
    }
}
class Bedrijf extends Klant{

}
class Overheid extends Klant{

}