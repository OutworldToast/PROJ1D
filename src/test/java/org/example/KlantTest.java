package org.example;

import org.example.klant.Bedrijf;
import org.example.klant.Klant;
import org.example.schip.Schip;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Ignore;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KlantTest {
    @Test
    void klantKortingPercentage(){
        Klant klant = new Bedrijf("Bedrijfje", "123@hotmail.nl", 6969);
        klant.setKortingAlsPercentage(20);
        assertEquals(klant.getKortingAlsPercentage(), 20);
    }
}
