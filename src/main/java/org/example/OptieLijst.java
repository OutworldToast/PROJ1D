package org.example;

import org.example.offerte.OfferteOptie;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OptieLijst {

    boolean gesorteerd = false;
    private ArrayList<OfferteOptie> totaalLijst = new ArrayList<>();
    private ArrayList<OfferteOptie> gekozenlijst = new ArrayList<>();

     public OptieLijst(){

        String line; //string waar de regels ingelezen worden
        String splitBy = ","; //delimiter
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("opties.csv").getFile());
            InputStream is = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //file inlezen

            while ((line = br.readLine()) != null) { //loopt door bestand
                String[] opties = line.split(splitBy); //separate regels
                totaalLijst.add (new OfferteOptie(
                        opties[0], opties[1], Double.parseDouble(opties[2]), Integer.parseInt(opties[3])));
                //voegt nieuwe offerteoptie toe
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<OfferteOptie> getGekozenOpties() {
        return this.gekozenlijst;
    }

    public void printOpties(){
        printLijst(totaalLijst);
    }
    public void printGekozen(){
        printLijst(gekozenlijst);
    }
    private void printLijst(ArrayList<OfferteOptie>  lijst){ //print de lijst
        if (!gesorteerd) {
            ArrayList<OfferteOptie> newLijst = sortLijst(lijst);
            lijst.clear();
            lijst.addAll(newLijst);
        }

        int i = 1;
        for (OfferteOptie optie : lijst) {
            System.out.printf("[%d] Naam: %s, Categorie: %s, Prijs: €%.2f, Milieukortingspercentage:%d%n",
                    i, optie.getNaam(), optie.getCategorie(), optie.getPrijs(), optie.getMilieukorting());
            i++;
        }

    }

    private ArrayList<OfferteOptie> sortLijst(ArrayList<OfferteOptie> lijst){ //sorteert lijst
        ArrayList<OfferteOptie> esslijst = new ArrayList<>();
        ArrayList<OfferteOptie> extlijst = new ArrayList<>();
        for (OfferteOptie optie : lijst){
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
        gekozenlijst.add(new OfferteOptie(naam, categorie, prijs, milieukorting));
        gesorteerd = false;
    }

    public void addLoop() {
        Scanner scanner = new Scanner(System.in);
        boolean looping = true;
        while(looping) {
            System.out.println("Wat wilt u toevoegen?");
            System.out.println("[A] Terug");
            System.out.println("[B] Nieuwe optie");
            System.out.println("[C] Update optie");
            printOpties();
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
                    totaalLijst.add(new OfferteOptie(naam, categorie, prijs, milieukorting));
                } else if (input.equalsIgnoreCase("C")) {
                    //updateoptie
                } else if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= totaalLijst.size()) {
                    gekozenlijst.add(totaalLijst.get(Integer.parseInt(input) - 1));
                } else {
                    System.out.println("Dat is geen optie");
                }
            } catch (Exception e) {
                System.out.println("Non-valide input");
            }

        }
    }

}
