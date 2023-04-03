package org.example;
import org.example.klant.*;
import org.example.offerte.Offerte;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        //TestKlant();
        //TestLijst();
       // new Loop();
        TestprijsOpgave();
    }

    public static void TestKlant() {
        // later misschien uniek "KlantenID" ofzo
        ArrayList<Klant> klantArrayList = new ArrayList<>();
        klantArrayList.add(new Bedrijf("Joost Inc.", "Bedrijfje@wow.nl", 39099902));
        klantArrayList.add(new Particulier("Joost","Joost@mail.nl"));
        klantArrayList.get(1).setEmail("Joost@hotmail.com");
        Klant.printArrayList(klantArrayList);
        klantArrayList.get(0).printKlantInfo();
        klantArrayList.set(0, new Klant("joost","hallo"));

    }


    public static void TestLijst() {
        TotaalLijst lijst = new TotaalLijst();
        lijst.printOpties();
    }

    public static void TestprijsOpgave(){

        Klant k1 = new Klant("Juan", "juan@gmail.com");
        Offerte juan = new Offerte("Juan", k1);
        TotaalLijst totaalLijst = new TotaalLijst();


        PrijsOpgave juanofferte = new PrijsOpgave(k1,juan,totaalLijst);

        juanofferte.toonPrijsopgave();
    }
}



