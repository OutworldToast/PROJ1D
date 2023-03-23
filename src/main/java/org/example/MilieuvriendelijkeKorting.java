package org.example;

public class MilieuvriendelijkeKorting {//Class Naam

    private double kortingPercentage; // variablen

    public void setKortingPercentage(double percentage) {//Constructor
        this.kortingPercentage = percentage;
    }

    public double getKortingPercentage() {//Methode
        return this.kortingPercentage;
    }

    // andere methoden om kortingen toe te passen op specifieke onderdelen

}

class Scheepsbouwer {//Class naam

    private MilieuvriendelijkeKorting milieuvriendelijkeKorting;//Variablen

    public Scheepsbouwer() {//Constructor
        this.milieuvriendelijkeKorting = new MilieuvriendelijkeKorting();
    }

    public void voegMilieuvriendelijkeKortingToe(double percentage){//Methode (Korting toepassen)
        this.milieuvriendelijkeKorting.setKortingPercentage(percentage);
    }

    public double berekenGereduceerdePrijs(double prijs) {//Nieuwprijs na korting
        double gereduceerdePrijs = prijs * (1 - this.milieuvriendelijkeKorting.getKortingPercentage());
        return gereduceerdePrijs;
    }

    // andere methoden om offertes te genereren en onderdelen te selecteren

}



