package org.example;

import org.example.klant.Klant;
import org.example.offerte.Offerte;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrijsOpgaveTest {
    @Test
    void BerekenBTWTest(){
        Klant klant = new Klant("","");
        PrijsOpgave p = new PrijsOpgave(klant,new Offerte("", klant),new Date());
        assertEquals(210,p.berekenBtw(1000));
    }
}
