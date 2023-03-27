import org.example.OptieLijst;
import org.testng.annotations.Test;

public class OptieLijstTest {
    @Test
    public void TestOptieLijstInlezen() {
        OptieLijst lijst = new OptieLijst();

        lijst.printOpties();
    }
}
