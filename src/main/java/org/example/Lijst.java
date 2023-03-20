package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Lijst {

    boolean gesorteerd = false;
    ArrayList<Offerteoptie> optielijst = new ArrayList<>();
    ArrayList<Offerteoptie> gekozenlijst = new ArrayList<>();

    Lijst(){

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
                optielijst.add (new Offerteoptie(opties[0], opties[1], Double.parseDouble(opties[2])));
                //voegt nieuwe offerteoptie toe
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printOpties(){
        printLijst(optielijst);
    }
    public void printGekozen(){
        printLijst(gekozenlijst);
    }
    private void printLijst(ArrayList<Offerteoptie>  lijst){ //print de lijst
        if (!gesorteerd) {
            ArrayList<Offerteoptie> newLijst = sortLijst(lijst);
            lijst.clear();
            lijst.addAll(newLijst);
        }

        int i = 1;
        for (Offerteoptie optie : lijst) {
            i++;
            System.out.printf("[%d] Naam: %s, Categorie: %s, Prijs: €%.2f%n", i, optie.naam, optie.categorie, optie.prijs);
        }

    }

    private ArrayList<Offerteoptie> sortLijst(ArrayList<Offerteoptie> lijst){ //sorteert lijst
        ArrayList<Offerteoptie> esslijst = new ArrayList<>();
        ArrayList<Offerteoptie> extlijst = new ArrayList<>();
        for (Offerteoptie optie : lijst){
            if (optie.categorie.equals("Essentieel")) { //zet alle essentiele in een lijst
                esslijst.add(optie);
            } else if (optie.categorie.equals("Extra")) { //zet alle extra in een lijst
                extlijst.add(optie);
            } else { //errorcontrole
                System.out.printf("Incorrecte categorie bij optie met naam %s", optie.naam);
            }
        }
        esslijst.addAll(extlijst); //combineert lijsten
        gesorteerd = true; //lijst is gesorteerd
        return esslijst; //update de lijst
    }
    public void addOptie(String naam, String categorie, double prijs){
        gekozenlijst.add(new Offerteoptie(naam, categorie, prijs));
        gesorteerd = false;
    }

    public void addLoop() {
        Scanner scanner = new Scanner(System.in);
        boolean looping = true;
        while(looping) {
            System.out.println("Wat wilt u toevoegen?");
            System.out.println("[A] Terug");
            System.out.println("[B] Nieuwe optie");
            printOpties();
            String input = scanner.nextLine();
            try {
                if (input.equalsIgnoreCase("A")) {
                    looping = false;
                } else if (input.equalsIgnoreCase("B")) {
                    //nieuwe optie
                } else if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= optielijst.size()) {
                    gekozenlijst.add(optielijst.get(Integer.parseInt(input) - 1));
                } else {
                    System.out.println("Dat is geen optie");
                }
            } catch (Exception e) {
                System.out.println("Non-valide input");
            }

        }
    }

    static class Offerteoptie { //klasse met alle optieinformatie
        private String naam; //naam van de optie
        private String categorie; //bijbehorende categorie (essentieel of extra)
        private double prijs; //prijs van de optie

        public Offerteoptie(String naam, String categorie, double prijs) {
            this.naam = naam;
            this.categorie = categorie;
            this.prijs = prijs;
        }

        public String getNaam() {
            return naam;
        }

        public void setNaam(String naam) {
            this.naam = naam;
        }

        public String getCategorie() {
            return categorie;
        }

        public void setCategorie(String categorie) {
            this.categorie = categorie;
        }

        public double getPrijs() {
            return prijs;
        }

        public void setPrijs(double prijs) {
            this.prijs = prijs;
        }
    }

}
