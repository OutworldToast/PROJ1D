package org.example;
import org.example.offerte.Onderdeel;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import javax.management.StringValueExp;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class TotaalLijstTest {

    @Test
    public void testPrintOnderdeelLijst() {

        TotaalLijst totaalLijst = new TotaalLijst();


        ArrayList<Onderdeel> lijst = new ArrayList<>();
        lijst.add(new Onderdeel("Onderdeel 1", "Essentieel", 10.0, 5));
        lijst.add(new Onderdeel("Onderdeel 2", "Extra", 20.0, 10));
        lijst.add(new Onderdeel("Onderdeel 3", "Essentieel", 30.0, 15));

        String line1 = "[2] Naam: Onderdeel 3, Categorie: Essentieel, Prijs: €30,00, Milieukortingspercentage: 15";
        String line2 = "[3] Naam: Onderdeel 2, Categorie: Extra, Prijs: €20,00, Milieukortingspercentage: 10";
        String line3 = "[1] Naam: Onderdeel 1, Categorie: Essentieel, Prijs: €10,00, Milieukortingspercentage: 5";

        String expected = String.format("%s%s%s%s%s%s",line3,System.lineSeparator(),
                line1,System.lineSeparator(),
                line2,System.lineSeparator());//Enters Fixen Opschonen


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        PrintStream original = System.out;
        System.setOut(printStream);

        // Voer de methode uit om de lijst te sorteren en af te drukken
        totaalLijst.printOnderdeelLijst(lijst);

        // Controleer of de lijst correct is afgedrukt
        Assertions.assertEquals(expected,
                baos.toString());

        System.setOut(original);
    }
}
