package org.example;

import org.example.klant.Aangepast;
import org.example.klant.Bedrijf;
import org.example.klant.Klant;
import org.example.klant.Overheid;
import org.example.offerte.Offerte;
import org.example.offerte.Onderdeel;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Loop {
    boolean loop = true;
    public static Scanner scanner = new Scanner(System.in);;
    public static TotaalLijst totaalLijst = new TotaalLijst();

    private Offerte offerte;

    public void start() {
        Introductie();
        BepaalLoop();
    }

    private void scheepsbouwerloop() {

        if (offerte == null) {
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

    private String bepaalBeschrijving() {
        System.out.println("Geef een beschrijving van de offerte:");
        scanner.nextLine();
        return scanner.nextLine();
    }

    private void offerteMakenLoop() {
        boolean stopLoop = false;

        // Zorg dat de scanner niet blijft wachten op een input
        scanner.nextLine();

        while (!stopLoop) {
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

                if (input == 1) {
                    maakOfferte();
                    stopLoop = true;
                } else if (input == 2) {
                    stopLoop = true;
                } else {
                    System.out.println("Dat is geen optie");
                }

            } catch (InputMismatchException e) {
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }
    }

    private Klant kiesKlantTypeLoop() {
        while (true) {
            System.out.println("""
                    Voor welk soort klant wordt de offerte gemaakt?
                    [1] Particulier
                    [2] Bedrijf
                    [3] Overheid
                    [4] Aangepast
                    """);
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Voer de naam in:");
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
                    case 4 -> {
                        System.out.println("Voer de extra informatie van de klant in:");
                        String extraInfo = scanner.nextLine();
                        // offerte.setKlant(new Klant(naam, email));
                        System.out.println("Voer de korting als percentage in (5% wordt ingevuld als 5):");
                        int kortingAlsPercentage = 0;
                        try {
                            kortingAlsPercentage = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("U heeft geen cijfer ingevuld percentage is automatisch 0 geworden.");
                            scanner.nextLine();
                        }
                        return new Aangepast(naam, email, extraInfo,kortingAlsPercentage);
                    }
                    default -> System.out.println("Dat is geen optie");
                }


            } catch (InputMismatchException e) {
                System.out.println("Typ een cijfer");
                scanner.next();
            }
        }

    }
    private void veranderKlant() {
        offerte.setKlant(kiesKlantTypeLoop());
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
        if (offerte == null) {
            System.out.println("Er is geen offerte beschikbaar");
        } else {
            PrijsOpgave prijsOpgave = new PrijsOpgave(offerte, new Date());
            prijsOpgave.toonPrijsopgave();
        }
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


        private void klantloop () {
            while (loop) {
                try {
                    System.out.println("Wat wilt u doen?");
                    System.out.println("[0] Programma verlaten");
                    System.out.println("[1] Offerte bekijken");
                    System.out.println("[2] Verander gebruikerstype");
                    System.out.println("[3] Bekijk Opties");
                    int input = scanner.nextInt();
                    switch (input) {
                        case 0 -> Exit();
                        case 1 -> BekijkPrijsOpgave();
                        case 2 -> BepaalLoop();
                        case 3 -> bekijkOptielijst();
                        default -> System.out.println("Dat is geen optie");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Typ een cijfer");
                    scanner.next();
                }
            }
        }

        private void bekijkOptielijst () {
            ArrayList<Onderdeel> lijst = new ArrayList<>();
            boolean b = true;
            while (b) {
                try {
                    System.out.println("Welke onderdelen wilt u selecteren");
                    System.out.println("[0] Klaar");
                    totaalLijst.printOpties();
                    int input = scanner.nextInt();
                    if (input == 0) {
                        b = false;
                    } else if (input > 0 && input <= totaalLijst.getTotaalLijst().size()) {
                        Onderdeel onderdeel = totaalLijst.getTotaalLijst().get(input - 1);
                        lijst.add(onderdeel);
                        System.out.println("U heeft onderdeel: " + onderdeel.getNaam() + " toegevoegd.");
                        System.out.println();
                    } else {
                        System.out.println("Dat is geen optie");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Typ een getal");
                    scanner.next();
                }
            }
            double som = 0;
            for (Onderdeel onderdeel : lijst) {
                som += onderdeel.getPrijs();
            }
            if (som != 0) {
                System.out.printf("Totaalprijs van geselecteerde onderdelen is: €%.2f", som);
                System.out.println();
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
                        if (checkScheepsbouwerWachtwoord()) {
                            return true;
                        } else {
                            System.out.println("Incorrect wachtwoord");
                        }
                    }
                    default -> System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ alleen een cijfer");
                scanner.next();
            }
        }
    }

    private boolean checkScheepsbouwerWachtwoord() {
        scanner.nextLine();
        System.out.println("Wat is het wachtwoord?");
        return scanner.nextLine().equals("st3RK");
    }
}
