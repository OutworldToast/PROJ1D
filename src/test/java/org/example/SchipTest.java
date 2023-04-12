package org.example;


import org.example.offerte.Onderdeel;
import org.example.schip.Schip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class SchipTest {

    @Test
    void onderdeel1verhogenTest(){
        Schip schip = new Schip();
        schip.voegOnderdeelToe(1);
        assertEquals(10,schip.getOnderdeelLijst().size());
        assertEquals(2,schip.getOnderdeelLijst().get(0).getHoeveelheid());
    }
    @Test
    void onderdeel18ToevoegenTest(){
        Schip schip = new Schip();
        schip.voegOnderdeelToe(18);
        assertEquals(11,schip.getOnderdeelLijst().size());
    }

}