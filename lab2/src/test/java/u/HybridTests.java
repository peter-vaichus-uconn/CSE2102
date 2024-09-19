package u;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import c.Hybrid;

public class HybridTests {

    private Hybrid hybrid;

    @Before
    public void setUp() {
        hybrid = new Hybrid();
    }

    @Test
    public void testCalcGasMPG() {
        hybrid.setMilesfromGas(300);
        hybrid.setGallonsfromGas(10);
        assertEquals(30.0, hybrid.calcGasMPG(), 0.01); // Use delta for floating-point comparison
    }

    @Test
    public void testCalcMPGe() {
        hybrid.setElectricMiles(300);
        hybrid.setTotalkWh(70.0);
        assertEquals(144.43, hybrid.calcMPGe(), 0.01); // Example expected value, adjust as needed
    }

    @Test
    public void testSetAndGetCostPerGallon() {
        hybrid.setCostPerGallon(3.50);
        assertEquals(3.50, hybrid.getCostPerGallon(), 0.01);
    }

    @Test
    public void testSetAndGetCostPerkWh() {
        hybrid.setCostPerkWh(0.12);
        assertEquals(0.12, hybrid.getCostPerkWh(), 0.01);
    }

    @Test
    public void testAverageMPG() {
        hybrid.setMilesfromGas(150);
        hybrid.setGallonsfromGas(5);
        hybrid.setElectricMiles(150);
        hybrid.setTotalkWh(35.0);

        double gasMPG = hybrid.calcGasMPG();
        double electricMPGe = hybrid.calcMPGe();
        double averageMPG = (gasMPG + electricMPGe) / 2;

        // Example expected value, adjust as needed
        double expectedAverageMPG = 87.21;
        assertEquals(expectedAverageMPG, averageMPG, 0.01);
    }
}
