package org.example.offerte;

import org.example.TotaalLijst;
import org.example.klant.Klant;
import org.example.schip.Schip;

import java.util.ArrayList;
import java.util.Scanner;

public class Offerte {
    private String beschrijving;
    private Klant klant;
    private Schip schip;

    public Offerte(String beschrijving, Klant klant) {
        this.beschrijving = beschrijving;
        this.klant = klant;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Schip getSchip() {
        return schip;
    }

    public void invoerKorting(){
        Scanner sc = new Scanner(System.in);
        boolean k = true;
        while(k){
            try{
                ArrayList<Onderdeel> onderdeel = schip.getOnderdeelLijst();
                schip.getTotaalOnderdeelLijst().printOnderdeelLijst(onderdeel);
                System.out.println("Voor welke onderdeel wilt u korting toepassen?");
                int keuze = sc.nextInt();
                if (keuze > 0 && keuze <= onderdeel.size()){
                    int percentage = sc.nextInt();
                    onderdeel.get(keuze - 1).setMilieukorting(percentage);//Binnen 0-100 percentage toevoegen
                }
            }catch (Exception d){
                System.out.println("Geen onderdeel aangegeven");
            }
        }
    }

    public double getTotaalPrijs() {

        //deze moet klant korting meerekenen
        double totaalPrijs = 0.0;

        for(Onderdeel onderdeel : schip.getOnderdeelLijst()) {
            double prijs = onderdeel.getPrijs();

            int milieukorting = onderdeel.getMilieukorting();

            prijs -= (milieukorting / 100.0) * prijs;

            System.out.println("oude prijs: " + onderdeel.getPrijs());
            System.out.println("nieuwe prijs: " + prijs);
            totaalPrijs += prijs;
        }

        return totaalPrijs;
    }

}
