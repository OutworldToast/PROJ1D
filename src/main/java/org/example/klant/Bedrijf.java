package org.example.klant;
public class  Bedrijf extends Klant {
    private int KVKNummer;
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
        super.printKlantInfo();
        System.out.println("Het KVK-nummer van dit bedrijf is: " + KVKNummer);
    }
}
