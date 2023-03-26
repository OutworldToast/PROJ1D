package org.example;
import org.example.klant.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //TestKlant();
        //TestLijst();
        new Loop();
    }

    public static void TestKlant() {
        // later misschien uniek "KlantenID" ofzo.
        ArrayList<Klant> klantArrayList = new ArrayList<>();
        klantArrayList.add(new Bedrijf("Joost Inc.", "Bedrijfje@wow.nl", 39099902));
        klantArrayList.add(new Particulier("Joost","Joost@mail.nl"));
        klantArrayList.get(1).setEmail("Joost@hotmail.com");
        Klant.printArrayList(klantArrayList);
        klantArrayList.get(0).printKlantInfo();

    }


    public static void TestLijst() {
        OptieLijst lijst = new OptieLijst();
        lijst.printOpties();
    }
}



