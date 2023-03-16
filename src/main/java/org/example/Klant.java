package org.example;

public class Klant {
    // De main klant waarvan alle andere overerven met hieronder de variabelen
private String naam;
private int kortingAlsPercentage;
private String email;
// De getters en Setters voor de variabelen
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getNaam(){
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
    public void setKlantInfo(String naam, String email){
        setNaam(naam);
        setEmail(email);
    }
    public void printKlantInfo() {
        System.out.println("De naam van de klant is: " + getNaam());
        System.out.println("De email die opgegeven is: " + getEmail());
        System.out.println("De korting voor deze klant is: " + getKortingAlsPercentage());
    }
}
class Particulier extends Klant{

    @Override
    public void printKlantInfo() {
        setKortingAlsPercentage(0);
        super.printKlantInfo();
    }
}
class Bedrijf extends Klant{
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

class Overheid extends Klant{
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
