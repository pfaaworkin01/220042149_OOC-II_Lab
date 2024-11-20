import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IceCreamFlavor chocolate = new IceCreamFlavor("Chocolate Fudge", 3.00);
        IceCreamTopping sprinkles = new IceCreamTopping("Sprinkles", 0.30);
        Order order1 = new Order(false);
        order1.addItem(chocolate, 1);
        order1.addTopping(sprinkles);
        System.out.println(order1.generateInvoice());
        order1.saveInvoiceToFile("invoice.txt");
        System.out.println("Invoice saved to invoice.txt");
    }
}