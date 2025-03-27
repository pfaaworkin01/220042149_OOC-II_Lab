import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RideFareCalculatorTest {

    @Test
    public void testEconomyFare() {
        RideFareCalculator calculator = new RideFareCalculator();
        assertEquals(44.55, calculator.totalFare(20, 30, "Economy", 19));
    }

    @Test
    public void testPremiumFare() {
        RideFareCalculator calculator = new RideFareCalculator();
        assertEquals(151.2, calculator.totalFare(40, 50, "Premium", 30));
    }

    @Test
    public void testDiscount() {
        RideFareCalculator calculator = new RideFareCalculator();
        assertEquals(54.5, calculator.totalFare(20, 30, "Economy", 29));
    }
}