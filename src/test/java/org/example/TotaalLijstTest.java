package org.example;
import org.testng.annotations.Test;

public class TotaalLijstTest {
    @Test
    public void TestTotaalLijstInlezen() {
        TotaalLijst lijst = new TotaalLijst();

        lijst.printOpties();
    }
}
