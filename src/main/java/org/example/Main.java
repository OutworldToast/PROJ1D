package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Bedrijf Bedrijfje = new Bedrijf();
        Bedrijfje.setKlantInfo("Joost Inc.", "Bedrijfje@wow.nl", 39099902);
        Bedrijfje.printKlantInfo();
        Particulier Joost = new Particulier();
        Joost.setKlantInfo("naam","Joost@mail.nl");
        Joost.printKlantInfo();
        Overheid overheid = new Overheid();

        TestKlant();

    }

    public static void TestKlant() {
        Lijst lijst = new Lijst();
        lijst.printLijst();
    }
}
