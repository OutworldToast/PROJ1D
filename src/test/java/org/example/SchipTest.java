package org.example;


import org.example.offerte.Onderdeel;
import org.example.schip.Schip;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Ignore;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;


class SchipTest {

    private static final InputStream inOriginal = System.in;
    private static final PrintStream outOriginal = System.out;

    @Test
    void onderdeel1verhogenTest(){
        Schip schip = new Schip();
        schip.voegOnderdeelToe(1);
        assertEquals(10,schip.getOnderdeelLijst().size());
        assertEquals(2,schip.getOnderdeelLijst().get(0).getHoeveelheid());
    }
    @Test
    void testMilieukortingen(){
        Schip schip = new Schip();
        schip.getOnderdeelLijst().get(1).setMilieukorting(10);
        assertEquals(10,schip.getOnderdeelLijst().get(1).getMilieukorting());
        assertEquals(455,schip.getOnderdeelLijst().get(1).getPrijs());

    }
    @Test
    void onderdeel18ToevoegenTest(){
        Schip schip = new Schip();
        schip.voegOnderdeelToe(18);
        assertEquals(11,schip.getOnderdeelLijst().size());
    }
    @Test
    void berekenPrijsTest(){
        Schip schip = new Schip();
        // tien procent milieu korting op een prijs van 455 wordt 409,50
        assertEquals(409.50, schip.berekenPrijs(schip.getOnderdeelLijst().get(1)));
    }
    @Test
    void testKlantkortingveranderenTijdensAanmaken(){

    }

    @Test
    void invoerLoopErrorControl(){
        Schip schip = new Schip();

        String userInput = String.format("e%s0", System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Typ een cijfer";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        schip.invoerLoop();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-9];

        // checkout output
        assertEquals(expected,actual);
    }


    @AfterAll
    static void restoreStreams(){
        System.setIn(inOriginal);
        System.setOut(outOriginal);
    }

}