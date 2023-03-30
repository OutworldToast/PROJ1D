package org.example;

import org.example.offerte.Onderdeel;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TotaalLijst {

    Scanner scanner = Loop.scanner;
    boolean gesorteerd = false;
    private final ArrayList<Onderdeel> totaalLijst = new ArrayList<>();

    public ArrayList<Onderdeel> getTotaalLijst() {
        return totaalLijst;
    }

    public TotaalLijst(){ //test 123

        String line; //string waar de regels ingelezen worden
        String splitBy = ","; //delimiter
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("opties.csv").getFile());
            InputStream is = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //file inlezen

            boolean skipEersteLine = true;
            while ((line = br.readLine()) != null) { //loopt door bestand
                if(skipEersteLine) {
                    skipEersteLine = false;
                    continue;
                }

                String[] opties = line.split(splitBy); //separate regels
                totaalLijst.add (new Onderdeel(
                        opties[0], opties[1], Double.parseDouble(opties[2]), 0));
                //voegt nieuwe offerteoptie toe
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printOpties(){
        printOnderdeelLijst(totaalLijst);
    }
    public void printOnderdeelLijst(ArrayList<Onderdeel>  lijst){ //print de lijst
        if (!gesorteerd) {
            ArrayList<Onderdeel> newLijst = sortLijst(lijst);
            lijst.clear();
            lijst.addAll(newLijst);
        }

        int i = 1;
        for (Onderdeel onderdeel : lijst) {
            System.out.printf("[%d] Naam: %s, Categorie: %s, Prijs: €%.2f, Milieukortingspercentage: %d%n",
                    i, onderdeel.getNaam(), onderdeel.getCategorie(), onderdeel.getPrijs(), onderdeel.getMilieukorting());
            i++;
        }

    }

    private ArrayList<Onderdeel> sortLijst(ArrayList<Onderdeel> lijst){ //sorteert lijst
        ArrayList<Onderdeel> esslijst = new ArrayList<>();
        ArrayList<Onderdeel> extlijst = new ArrayList<>();
        for (Onderdeel optie : lijst){
            if (optie.getCategorie().equals("Essentieel")) { //zet alle essentiele in een lijst
                esslijst.add(optie);
            } else if (optie.getCategorie().equals("Extra")) { //zet alle extra in een lijst
                extlijst.add(optie);
            } else { //errorcontrole
                System.out.printf("Incorrecte categorie bij optie met naam %s", optie.getNaam());
            }
        }
        esslijst.addAll(extlijst); //combineert lijsten
        gesorteerd = true; //lijst is gesorteerd
        return esslijst; //update de lijst
    }
    public void addOptie(String naam, String categorie, double prijs, int milieukorting){
        totaalLijst.add(new Onderdeel(naam, categorie, prijs, milieukorting));
        gesorteerd = false;
    }

    public void addLoop() {
        boolean looping = true;
        while(looping) {
            try {
                System.out.println("Wat wilt u doen?");
                System.out.println("[0] Terug");
                System.out.println("[1] Nieuwe optie");
                System.out.println("[2] Update optie");
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 0 -> looping = false;
                    case 1 -> { //NOG TOE TE VOEGEN: controle voor foutieve inputs
                        System.out.println("Hoe heet het onderdeel?");
                        String naam = scanner.nextLine();
                        System.out.println("Is het een extra([EX]) of essentiële([ES]) optie?");
                        String categorie = scanner.nextLine();
                        if (categorie.equalsIgnoreCase("EX")){
                            categorie = "Extra";
                        } else if (categorie.equalsIgnoreCase("ES")) {
                            categorie = "Essentieel";
                        } else {
                            System.out.println("Dat is geen optie");
                        }
                        System.out.println("Hoeveel kost het onderdeel?");
                        double prijs = scanner.nextDouble(); //voeg afronding toe
                        scanner.next();
                        System.out.println("Wat is het milieukortingspercentage? (0-100) ");
                        int milieukorting = scanner.nextInt();
                        scanner.next();
                        addOptie(naam, categorie, prijs, milieukorting);
                        }
                    case 2 -> updateOnderdeelLoop();
                    default -> {System.out.println("Dat is geen optie");scanner.next();}
                }
            } catch (Exception e) {
                System.out.println("Typ een getal");
                scanner.next();
            }

        }
    }

    private void updateOnderdeelLoop(){
        printOpties();
        boolean b = true;
        while (b) {
            try {
                System.out.println("Wat is het nummer van het onderdeel?");
                System.out.println("[0] om terug te gaan");
                int input = scanner.nextInt();
                if (input == 0) {
                    b = false;
                } else if (input > 0 && input <= totaalLijst.size()) {
                    Onderdeel onderdeel = totaalLijst.get(input - 1);
                    kiesOnderdeelLoop(onderdeel);
                    b = false;
                } else {
                    System.out.println("Dat is geen optie");
                }
            } catch (InputMismatchException e) {
                System.out.println("Typ een getal");
                scanner.next();
            }
        }
    }

    private void kiesOnderdeelLoop(Onderdeel onderdeel){ //NOG TOE TE VOEGEN: controle voor foutieve inputs
        boolean b = true;
        System.out.println("U heeft het volgende onderdeel gekozen:");
        System.out.printf("Naam: %s, Categorie: %s, Prijs: €%.2f, Milieukortingspercentage: %d%n",
                onderdeel.getNaam(), onderdeel.getCategorie(), onderdeel.getPrijs(), onderdeel.getMilieukorting());
        while (b) {
            try {
                System.out.println("Wat wilt u doen?");
                System.out.println("[0] Terug");
                System.out.println("[1] Verander naam");
                System.out.println("[2] Verander categorie");
                System.out.println("[3] Verander prijs");
                System.out.println("[4] Verander milieukortingspercentage");
                int input = scanner.nextInt();
                switch (input) {//NOG TOE TE VOEGEN: controles voor foutieve inputs
                    case 0 -> b = false;
                    case 1 -> onderdeel.setNaam(scanner.nextLine());
                    case 2 -> onderdeel.setCategorie(scanner.nextLine());
                    case 3 -> onderdeel.setPrijs(scanner.nextDouble());
                    case 4 -> onderdeel.setMilieukorting(scanner.nextInt());
                    default -> System.out.println("Dat is geen optie");
                }
                b = false;

            } catch (InputMismatchException e) {
                System.out.println("Typ een getal");
                scanner.next();
            }
        }
    }

}
