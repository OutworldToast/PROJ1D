package org.example;

import org.example.schip.Schip;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Loop {
    boolean loop = true;
    public static Scanner scanner = new Scanner(System.in);
    TotaalLijst totaalLijst = new TotaalLijst();

    public Loop(){
        Introductie();
        BepaalLoop();
    }

    private void scheepsbouwerloop() {
        while (loop) {
            try {
                System.out.println("Wat wilt u doen?");
                System.out.println("[1] Programma verlaten");
                System.out.println("[2] Klant aanmaken");
                System.out.println("[3] Schip aanmaken");
                System.out.println("[4] Offerte aanmaken"); //veranderen
                System.out.println("[5] Prijsopgave bekijken");
                System.out.println("[6] Boot Template toevoegen");
                System.out.println("[7] Onderdelen toevoegen");
                System.out.println("[8] Verander gebruikerstype");
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> Exit();
                    case 2 -> MaakKlant();
                    case 3 -> MaakSchip();
                    case 4 -> MaakOfferte();
                    case 5 -> BekijkPrijsOpgave();
                    case 6 -> AddTemplate();
                    case 7 -> AddOnderdeel();
                    case 8 -> BepaalLoop();
                    default -> System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }
    }

    private void MaakSchip() { //STANDUP: waar zetten we schepenlijst?
        Schip schip = new Schip(totaalLijst);
        schip.invoerLoop();
    }

    private void Exit() {
        System.out.println("Dank u voor het gebruik van ons product");
        loop = false;
    }

    private void BepaalLoop() {
        if (IsScheepsbouwer()) {
            scheepsbouwerloop();
        } else {
            klantloop();
        }
    }

    private void AddOnderdeel() {
        totaalLijst.addLoop();
    }

    private void AddTemplate() {
        //voeg code toe
    }

    private void BekijkPrijsOpgave() {
        //voeg code toe
    }

    private void MaakOfferte() {
        //voeg code toe
    }

    private void MaakKlant() {
        //voeg code toe
    }

    private void klantloop() {
        while (loop) {
            try {
                System.out.println("Wat wilt u doen?");
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

    private void Introductie(){
        System.out.println("Welkom bij ShipFlex!");
        System.out.println("Dit is een programma gemaakt door Dream Team");
        System.out.println("In dit programma kunt u offertes voor boten maken en bekijken");
        System.out.println("Typ het teken tussen de blokhaken[1] om verder te gaan");
        boolean b = false;
        while (!b) {
            try {
                int input = scanner.nextInt();
                if (input == 1) {
                    b = true;
                } else {
                    System.out.println("Typ [1] om verder te gaan");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ alleen een cijfer");
                scanner.next();
            }
        }
    }
    private boolean IsScheepsbouwer() {
        while (true) {
            System.out.println("Bent u een klant[1] of een scheepsbouwer[2]?");
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> {
                        return false;
                    }
                    case 2 -> {
                        return true;
                    }
                    default -> System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ alleen een cijfer");
                scanner.next();
            }
        }
    }
}