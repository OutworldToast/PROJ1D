package org.example.schip;

import org.example.Loop;
import org.example.TotaalLijst;
import org.example.offerte.Onderdeel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Schip {

    private String materiaal;
    private final TotaalLijst totaalLijst;
    private final ArrayList<Onderdeel> onderdeelLijst = new ArrayList<>();
    Scanner scanner = Loop.scanner;

    public Schip(TotaalLijst totaalLijst) {
        this.totaalLijst = totaalLijst;
        //setMateriaal();
    }

    public void invoerLoop(){
        boolean b = true;
        while (b) {
            try {
                System.out.println("Wat wilt u doen?");
                System.out.println("[1] Terug");
                System.out.println("[2] Toon totaallijst");
                System.out.println("[3] Toon huidige onderdelen");
                System.out.println("[4] Onderdeel toevoegen aan schip");
                System.out.println("[5] Onderdeel verwijderen uit schip");
                System.out.println("[6] Onderdeel toevoegen/veranderen in totaallijst");
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> b = false;
                    case 2 -> totaalLijst.printOpties();
                    case 3 -> printOnderdeelLijst();
                    case 4 -> voegToeOnderdeel();
                    case 5 -> verwijderOnderdeel();
                    case 6 -> totaalLijst.addLoop();
                    default -> System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }
    }

    private void printOnderdeelLijst() {
        totaalLijst.printOnderdeelLijst(onderdeelLijst);
    }

    private void voegToeOnderdeel() { //STANDUP: waar check voor essentiele onderdelen?
        boolean b = true;
        totaalLijst.printOpties(); //STANDUP: willen we dit hier?
        ArrayList<Onderdeel> lijst = totaalLijst.getTotaalLijst();
        while (b) {
            try {
                System.out.println("Wat is het nummer van het onderdeel?");
                System.out.println("[0] om terug te gaan");
                int input = scanner.nextInt();
                if (input == 0) {
                    b = false;
                } else if (input > 0 && input <= lijst.size()) {
                    Onderdeel onderdeel = lijst.get(input - 1);
                    onderdeelLijst.add(onderdeel);
                    System.out.printf("Het onderdeel '%s' is toegevoegd%n", onderdeel.getNaam());
                } else {
                    System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een getal");
            }
        }

    }

    private void verwijderOnderdeel() {
        boolean b = true;
        printOnderdeelLijst();
        ArrayList<Onderdeel> lijst = onderdeelLijst;
        while (b) {
            try {
                System.out.println("Wat is het nummer van het onderdeel?");
                System.out.println("[0] om terug te gaan");
                int input = scanner.nextInt();
                if (input == 0) {
                    b = false;
                } else if (input > 0 && input <= lijst.size()) {
                    Onderdeel onderdeel = lijst.get(input - 1);
                    onderdeelLijst.remove(onderdeel);
                    System.out.printf("Het onderdeel '%s' is verwijderd%n", onderdeel.getNaam());
                    b = false;
                } else {
                    System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een getal");
            }
        }
    }
    /* STANDUP: materiaalklasse ofzo nodig
    public void setMateriaal() {
        Scanner scanner = Loop.scanner;
        boolean b = false;
        while (!b) {
            try {
                System.out.println("Wat voor materiaal?");
                System.out.println("[1] Offerte bekijken");
                System.out.println("[2] Verander gebruikerstype");
                System.out.println("[3] Programma verlaten");
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> BekijkPrijsOpgave();
                    case 2 -> BepaalLoop();
                    case 3 -> Exit();
                    default -> System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }

    }
    */
}
