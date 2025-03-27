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

    @Test
    public void testInvoiceGeneration() throws IOException {
        IceCreamFlavor strawberrySwirl = new IceCreamFlavor("Strawberry Swirl", 2.75);
        IceCreamTopping chocolateChips = new IceCreamTopping("Chocolate Chips", 0.50);

        Order order = new Order(false); // Paper cup
        order.addItem(strawberrySwirl, 2); // 2 scoops
        order.addTopping(chocolateChips);

        String expectedInvoice = """
            Ice Cream Shop Invoice
            Strawberry Swirl - 2 scoop(s): $5.50
            Chocolate Chips - 1 time: $0.50
            Subtotal: $6.00
            Tax: $0.48
            Total Amount Due: $6.48
            """;

        assertEquals(expectedInvoice.trim(), order.generateInvoice().trim(), "Invoice generation failed");
    }

}
