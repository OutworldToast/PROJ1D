package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Lijst {

    ArrayList<Offerteoptie> optielijst = new ArrayList<>();

    Lijst(){
        File file = new File("Opties.txt");
        Scanner scanner = new Scanner(System.in);
    }
    static class Offerteoptie {
        String optie;
        String type;
        double prijs;
    }


}
