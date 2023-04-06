package org.example;

import org.example.klant.Bedrijf;
import org.example.klant.Klant;
import org.example.klant.Overheid;
import org.example.offerte.Offerte;
import org.example.schip.Schip;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Loop {
    boolean loop = true;
    public static Scanner scanner = new Scanner(System.in);
    public static TotaalLijst totaalLijst = new TotaalLijst();

    private Offerte offerte;


    public Loop(){
        Introductie();
        BepaalLoop();
    }

    private void scheepsbouwerloop() {

        if (offerte != null) {
            offerteMakenLoop();
        }

        while (loop) {
            try {
                System.out.println("Wat wilt u doen?");
                System.out.println("[0] Programma verlaten");

                if (offerte != null) {
                    System.out.println("[1] Offerte aanpassen");
                } else {
                    System.out.println("[1] Offerte aanmaken");
                }

                System.out.println("[2] Prijsopgave bekijken");
                System.out.println("[3] Onderdelen toevoegen");
                System.out.println("[4] Verander gebruikerstype");
                int input = scanner.nextInt();
                switch (input) {
                    case 0 -> Exit();
                    case 1 -> {
                        if (offerte != null) {
                            veranderOfferte();
                        } else {
                            maakOfferte();
                        }
                    }
                    case 2 -> BekijkPrijsOpgave();
                    case 3 -> AddOnderdeel();
                    case 4 -> BepaalLoop();
                    default -> System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }
    }

    private void maakOfferte() {

        String beschrijving = bepaalBeschrijving();

        Klant klant = kiesKlantTypeLoop();

        offerte = new Offerte(beschrijving, klant);
    }

    private String bepaalBeschrijving () {
        System.out.println("Geef een beschrijving van de offerte:");
        return scanner.nextLine();
    }

    private void offerteMakenLoop() {
        boolean stopLoop = false;

        // Zorg dat de scanner niet blijft wachten op een input
        scanner.nextLine();

        while(!stopLoop) {
            System.out.println(
                    """
                    Wil je gelijk een offerte aanmaken?
                    Hiermee kun je onderdelen aan een schip toevoegen en klanten aanmaken.
                    [1] Ja
                    [2] Nee
                    """
            );

            try {
                int input = scanner.nextInt();

                if(input == 1) {
                    maakOfferte();
                    stopLoop = true;
                }
                else if(input == 2) {
                    stopLoop = true;
                }
                else {
                    System.out.println("Dat is geen optie");
                }

            } catch (InputMismatchException e){
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }
    }

    private Klant kiesKlantTypeLoop () {

        while (true) {

            System.out.println("""
                                Voor welk soort klant wordt de offerte gemaakt?
                            [1] Particulier
                            [2] Bedrijf
                            [3] Overheid
                            """);

            try {

                int input = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Voer de naam in:");
                String naam = scanner.nextLine();
                System.out.println("Voer de e-mail in:");
                String email = scanner.nextLine();

                switch (input) {
                    case 1 -> {
                        return new Klant(naam, email);
                    }
                    case 2 -> {

                        System.out.print("Voer het KVK nummer in:");
                        int kvk;

                        try {
                            kvk = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Typ een cijfer");
                            scanner.nextLine();
                            continue;
                        }

                        return new Bedrijf(naam, email, kvk);
                    }
                    case 3 -> {

                        System.out.print("Voer de gemeente in:");
                        String gemeente = scanner.nextLine();

                        return new Overheid(naam, email, gemeente);
                    }
                    default -> System.out.println("Dat is geen optie");
                }


            } catch (InputMismatchException e) {
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }

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

    private void BekijkPrijsOpgave() {
        //voeg code toe
    }

    private void veranderSchip() {
        offerte.getSchip().invoerLoop();
    }

    private void veranderOfferte() {
        boolean looping = true;

        while (looping) {
            try {
                System.out.println("Wat wilt u doen?");
                System.out.println("[0] Terug");
                System.out.println("[1] Schip aanpassen");
                System.out.println("[2] Klant aanpassen");
                System.out.println("[3] Beschrijving aanpassen");
                int input = scanner.nextInt();
                switch (input) {
                    case 0 -> looping = false;
                    case 1 -> veranderSchip();
                    case 2 -> veranderKlant();
                    case 3 -> offerte.setBeschrijving(bepaalBeschrijving());
                    default -> System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }
    }

    private void veranderKlant() {
        System.out.println("Wat is het type klant?[1] Particulier, [2] Overheid, [3] Bedrijf, [4] aangepast");
        int typeklant = scanner.nextInt();
        scanner.nextLine();
        if (typeklant == 1) {
            System.out.println("Voer de naam van de klant in:");
            String naam = scanner.nextLine();
            System.out.println("Voer de e-mail van de klant in:");
            String Email = scanner.nextLine();
            offerte.setKlant(new Klant(naam, Email));
            offerte.getKlant().printKlantInfo();
        }
        if (typeklant == 2) {
            System.out.println("Voer de naam van de overheid in:");
            String naam = scanner.nextLine();
            System.out.println("Voer de e-mail van de overheid in:");
            String Email = scanner.nextLine();
            System.out.println("Voer de Gemeente van de overheid in:");
            String Gemeente = scanner.nextLine();
            offerte.setKlant(new Overheid(naam, Email, Gemeente));
            offerte.getKlant().printKlantInfo();
        }
        if (typeklant == 3) {
            System.out.println("Voer de naam van het bedrijf in:");
            String naam = scanner.nextLine();
            System.out.println("Voer de e-mail van het bedrijf in:");
            String Email = scanner.nextLine();
            System.out.println("Voer het KVKNummer van het bedrijf in:");
            int KVKNummer = scanner.nextInt();
            scanner.nextLine();
            offerte.setKlant(new Bedrijf(naam, Email, KVKNummer));
            offerte.getKlant().printKlantInfo();
        }
        if (typeklant == 4) {
            System.out.println("Voer de naam van de klant in:");
            String naam = scanner.nextLine();
            System.out.println("Voer de e-mail van de klant in:");
            String Email = scanner.nextLine();
            System.out.println("Voer de extra informatie van de klant in:");
            String extraInfo = scanner.nextLine();
            offerte.setKlant(new Klant(naam, Email));
            System.out.println("Voer de korting als percentage in (5% wordt ingevuld als 5):");
            int kortingAlsPercentage = scanner.nextInt();
            scanner.nextLine();
            offerte.getKlant().setKortingAlsPercentage(kortingAlsPercentage);
            offerte.getKlant().printKlantInfo();
            System.out.println(extraInfo);
        }
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
