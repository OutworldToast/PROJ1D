package org.example;

import java.io.*;
import java.util.ArrayList;

public class Lijst {

    ArrayList<Offerteoptie> optielijst = new ArrayList<>();
    ArrayList<Offerteoptie> gekozenlijst = new ArrayList<>();

    Lijst(){
        String line = "";
        String splitBy = ",";
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("opties.csv").getFile());
            InputStream is = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                String[] opties = line.split(splitBy);
                Offerteoptie optie = new Offerteoptie();
                optie.naam = opties[0];
                optie.categorie = opties[1];
                optie.prijs = Double.parseDouble(opties[2]);
                optielijst.add (optie);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void PrintLijst(){
        for (Offerteoptie optie : optielijst) {
            System.out.printf("Naam: %s, Categorie: %s, Prijs: €%.2f%n", optie.naam, optie.categorie, optie.prijs);
        }
    }
    static class Offerteoptie {
        String naam;
        String categorie;
        double prijs;
    }

}
