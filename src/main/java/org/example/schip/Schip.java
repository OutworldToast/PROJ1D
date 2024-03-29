package org.example.schip;
import org.example.Loop;
import org.example.TotaalLijst;
import org.example.offerte.Onderdeel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Schip {
    private final TotaalLijst totaalLijst = Loop.totaalLijst;
    private final ArrayList<Onderdeel> onderdeelLijst = new ArrayList<>();
    private final Scanner scanner = Loop.scanner;
    public Schip() {//voegt alle essentiele onderdelen toe
        for (Onderdeel e : totaalLijst.getTotaalLijst()) {
            if (e.getCategorie().equals("Essentieel")) {
                onderdeelLijst.add(e);
            }
        }
    }
    public void invoerLoop(){
        boolean b = true;
        Scanner scanner = new Scanner(System.in);
        while (b) {
            try {
                System.out.println("Wat wilt u doen?");
                System.out.println("[0] Terug");
                System.out.println("[1] Toon totaallijst");
                System.out.println("[2] Toon huidige onderdelen");
                System.out.println("[3] Onderdeel toevoegen aan schip");
                System.out.println("[4] Onderdeel verwijderen uit schip");
                System.out.println("[5] Onderdeel toevoegen/veranderen in totaallijst");
                System.out.println("[6] Milieukorting toevoegen aan onderdeel");
                int input = scanner.nextInt();
                switch (input) {
                    case 0 -> b = false;
                    case 1 -> totaalLijst.printOpties();
                    case 2 -> printOnderdeelLijst();
                    case 3 -> voegOnderdeelToeConsole();
                    case 4 -> verwijderOnderdeelConsole();
                    case 5 -> totaalLijst.addLoop();
                    case 6 -> invoerKorting();
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
    public ArrayList<Onderdeel> getOnderdeelLijst() {
        return onderdeelLijst;
    }
    public TotaalLijst getTotaalOnderdeelLijst() {
        return totaalLijst;
    }
    public void voegOnderdeelToe(int onderdeelNummer) {
        Onderdeel onderdeel = totaalLijst.getTotaalLijst().get(onderdeelNummer - 1);
        boolean gevonden = false;
         for (Onderdeel x : onderdeelLijst) {
                if (x.getNaam().equals(onderdeel.getNaam())){
                    x.verhoogHoeveelheid();
                    gevonden = true;
                }
            }
             if(!gevonden) {
            onderdeelLijst.add(onderdeel);
        }
            System.out.printf("Het onderdeel '%s' is toegevoegd%n", onderdeel.getNaam());
        }
    private void voegOnderdeelToeConsole() {
        boolean b = true;
        ArrayList<Onderdeel> lijst = totaalLijst.getTotaalLijst();
        while (b) {
            try {
                System.out.println("Wat is het nummer van het onderdeel dat u wilt toevoegen?");
                System.out.println("[0] om terug te gaan");
                totaalLijst.printOpties();
                int input = scanner.nextInt();
                if (input == 0) {
                    b = false;
                } else if (input > 0 && input <= lijst.size()) {
                    voegOnderdeelToe(input);
                } else {
                    System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een getal");
            }
        }
    }
    public void verwijderOnderdeel(int onderdeelNummer) {
        Onderdeel onderdeel = onderdeelLijst.get(onderdeelNummer - 1);
        if (onderdeel.getHoeveelheid() > 1) {
            onderdeel.verminderHoeveelheid();
        } else {
            onderdeelLijst.remove(onderdeel);
        }
        System.out.printf("Het onderdeel '%s' is verwijderd%n", onderdeel.getNaam());
    }
    public void invoerKorting(){
        boolean k = true;
        while(k){
            try{
                ArrayList<Onderdeel> onderdeel = getTotaalOnderdeelLijst().getTotaalLijst();
                getTotaalOnderdeelLijst().printOnderdeelLijst(onderdeel);
                System.out.println("Voor welke onderdeel wilt u korting toepassen?");
                int keuze = scanner.nextInt();
                if (keuze > 0 && keuze <= onderdeel.size()){
                    scanner.nextLine();
                    System.out.println("Hoeveel procent korting wilt u toepassen?");
                    int percentage = scanner.nextInt();
                    onderdeel.get(keuze - 1).setMilieukorting(percentage);//Binnen 0-100 percentage toevoegen
                    double nieuwprijs = berekenPrijs(onderdeel.get(keuze - 1));
                    System.out.println("De prijs van dit onderdeel na de korting: €"+nieuwprijs);
                    k = false;
                }
            }catch (Exception d){
                System.out.println("Geen onderdeel aangegeven");
            }
        }
    }
    public double berekenPrijs(Onderdeel onderdeel){
        double prijs = onderdeel.getPrijs();
        int milieukorting = onderdeel.getMilieukorting();

        prijs -= (milieukorting / 100.0) * prijs;

        return prijs;
    }
    private void verwijderOnderdeelConsole() {
        boolean b = true;
        printOnderdeelLijst();
        while (b) {
            try {
                System.out.println("Wat is het nummer van het onderdeel?");
                System.out.println("[0] om terug te gaan");
                int input = scanner.nextInt();
                if (input == 0) {
                    b = false;
                } else if (input > 0 && input <= onderdeelLijst.size()) {
                    verwijderOnderdeel(input);
                    b = false;
                } else {
                    System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een getal");
            }
        }
    }
}
