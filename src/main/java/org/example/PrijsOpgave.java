package org.example;

import org.example.klant.Klant;
import org.example.offerte.Offerte;
import org.example.offerte.Onderdeel;

public class PrijsOpgave {

    private Klant klantnaam;
   ///private Schip schiptype;

    private Offerte offerte;

    private TotaalLijst totaalLijst;






    public PrijsOpgave(Klant klantnaam, Offerte offerte, TotaalLijst totaalLijst) {
        this.klantnaam = klantnaam;
        this.offerte = offerte;
        this.totaalLijst = totaalLijst;
    }

    public Klant getKlantnaam() {
        return klantnaam;
    }

    public void setKlantnaam(Klant klantnaam) {
        this.klantnaam = klantnaam;
    }

    public Offerte getOfferte() {
        return offerte;
    }

    public void setOfferte(Offerte offerte) {
        this.offerte = offerte;
    }

    public TotaalLijst getTotaalLijst() {
        return totaalLijst;
    }

    public void setTotaalLijst(TotaalLijst totaalLijst) {
        this.totaalLijst = totaalLijst;
    }





    public void toonPrijsopgave() {



        System.out.println();
        System.out.println();
        System.out.println(klantnaam.getNaam() + " hierbij kunt u de totale kosten verwachten: ");


            for (Onderdeel t : totaalLijst.getTotaalLijst()
            ) {



                System.out.printf("%-15s ---- € %.2f%n", t.getNaam(), t.getPrijs());


            }








    }

}
