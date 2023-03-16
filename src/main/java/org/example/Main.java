package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //TestKlant();
        TestLijst();

    }

    public static void TestKlant(){
        Bedrijf Bedrijfje = new Bedrijf();
        Bedrijfje.setKlantInfo("Joost Inc.", "Bedrijfje@wow.nl", 39099902);
        Bedrijfje.printKlantInfo();
        Particulier Joost = new Particulier();
        Joost.setKlantInfo("naam","Joost@mail.nl");
        Joost.printKlantInfo();
        Overheid overheid = new Overheid();
    }

    public static void TestLijst() {
        Lijst lijst = new Lijst();
        lijst.printLijst();
    }


}
