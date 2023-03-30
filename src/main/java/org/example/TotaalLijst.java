package org.example;

import org.example.offerte.Onderdeel;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TotaalLijst {

    boolean gesorteerd = false;
    private final ArrayList<Onderdeel> totaalLijst = new ArrayList<>();

    public ArrayList<Onderdeel> getTotaalLijst() {
        return totaalLijst;
    }

    public TotaalLijst(){

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
                        opties[0], opties[1], Double.parseDouble(opties[2]), Integer.parseInt(opties[3])));
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
         Scanner scanner = Loop.scanner;
        boolean looping = true;
        while(looping) {
            System.out.println("Wat wilt u toevoegen?");
            System.out.println("[A] Terug");
            System.out.println("[B] Nieuwe optie");
            System.out.println("[C] Update optie");
            String input = scanner.nextLine();
            try {
                if (input.equalsIgnoreCase("A")) {
                    looping = false;
                } else if (input.equalsIgnoreCase("B")) {
                    System.out.println("Hoe heet het onderdeel?");
                    String naam = scanner.nextLine();
                    System.out.println("Is het een extra([EX]) of essentiële([ES]) optie?");
                    String categorie = scanner.nextLine();
                    System.out.println("Hoeveel kost het onderdeel?");
                    double prijs = scanner.nextDouble(); //voeg afronding toe
                    System.out.println("Wat is het milieukortingspercentage? (0-100) ");
                    int milieukorting = scanner.nextInt();
                    totaalLijst.add(new Onderdeel(naam, categorie, prijs, milieukorting));
                } else if (input.equalsIgnoreCase("C")) {
                    //updateoptie
                } else {
                    System.out.println("Dat is geen optie");
                }
            } catch (Exception e) {
                System.out.println("Non-valide input");
            }

        }
    }

}
