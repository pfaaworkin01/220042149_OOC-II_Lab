import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AskForPreference askForPreference = new AskForPreference();

        if(askForPreference.askForFlavor().equals("Invalid choice")) {
            System.out.println("Invalid choice");
        }
        else {
            String flavor = askForPreference.askForFlavor();
            double pricePerScoop = askForPreference.returnPrice();

            IceCreamFlavor chocolate = new IceCreamFlavor(flavor, pricePerScoop);
            IceCreamTopping sprinkles = new IceCreamTopping("Sprinkles", 0.30);
            Order order1 = new Order(false);
            order1.addItem(chocolate, 1);
            order1.addTopping(sprinkles);
            System.out.println(order1.generateInvoice());
            order1.saveInvoiceToFile("invoice.txt");
            System.out.println("Invoice saved to invoice.txt");
        }
    }
}