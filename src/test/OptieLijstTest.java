
import org.example.TotaalLijst;
import org.testng.annotations.Test;

public class OptieLijstTest {
    @Test
    public void TestOptieLijstInlezen() {
        TotaalLijst lijst = new TotaalLijst();

        lijst.printOpties();
    }
}
