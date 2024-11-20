import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class IceCreamShopTest {

    @Test
    public void testSingleScoopOrder() {
        IceCreamFlavor mintChocolateChip = new IceCreamFlavor("Mint Chocolate Chip", 2.80);
        IceCreamTopping sprinkles = new IceCreamTopping("Sprinkles", 0.30);

        Order order = new Order(false); // Paper cup
        order.addItem(mintChocolateChip, 1);
        order.addTopping(sprinkles);

        double expectedTotal = 2.80 + 0.30; // $3.10 before tax
        expectedTotal += expectedTotal * 0.08; // Adding 8% tax

        assertEquals(expectedTotal, order.calculateTotal(), 0.01, "Total calculation failed for single scoop order");
    }

}
