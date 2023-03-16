package org.example;

import java.io.*;
import java.util.ArrayList;

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

    public void printLijst(){ //print de lijst
        if (!gesorteerd) {
            sortLijst();
        }
        for (Offerteoptie optie : optielijst) {
            System.out.printf("Naam: %s, Categorie: %s, Prijs: €%.2f%n", optie.naam, optie.categorie, optie.prijs);
        }

    }

    public void sortLijst(){ //sorteert lijst
        ArrayList<Offerteoptie> esslijst = new ArrayList<>();
        ArrayList<Offerteoptie> extlijst = new ArrayList<>();
        for (Offerteoptie optie : optielijst){
            if (optie.categorie.equals("Essentieel")) { //zet alle essentiele in een lijst
                esslijst.add(optie);
            } else if (optie.categorie.equals("Extra")) { //zet alle extra in een lijst
                extlijst.add(optie);
            } else { //errorcontrole
                System.out.printf("Incorrecte categorie bij optie met naam %s", optie.naam);
            }
        }
        esslijst.addAll(extlijst); //combineert lijsten
        optielijst = esslijst; //update de lijst
        gesorteerd = true; //lijst is gesorteerd
    }
    public void addOptie(String naam, String categorie, double prijs){
        gekozenlijst.add(new Offerteoptie(naam, categorie, prijs));
        gesorteerd = false;
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
