import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        AskForPreference askForPreference = new AskForPreference();
        String flavor = askForPreference.askForFlavor();
        Scanner scanner = new Scanner(System.in);

        if(flavor.equals("Invalid choice")) {
            System.out.println("Invalid choice");
        }
        else {
            double flavorPrice = 0;
            switch (flavor) {
                case "Cookies and Cream":
                    flavorPrice = 2.80;
                    break;
                case "Chocolate Fudge":
                    flavorPrice = 3.00;
                    break;
                case "Pistachio Delight":
                    flavorPrice = 3.25;
                    break;
            }

            String toppings = askForPreference.askForToppings();
            double toppingPrice = 0;
            switch (toppings) {
                case "Sprinkles":
                    toppingPrice = 0.30;
                    break;
                case "Mixed Chopped Nuts":
                    toppingPrice = 0.80;
                    break;
                case "Crushed Gingerbread":
                    toppingPrice = 0.75;
                    break;
                case "Fresh Strawberries":
                    toppingPrice = 1.00;
                    break;
            }

            YogurtFlavor flavor1 = new YogurtFlavor(flavor, flavorPrice);
            YogurtTopping topping1 = new YogurtTopping(toppings, toppingPrice);

            System.out.println("Do u want it in a Glass Jar? (Y/N)\n");
            String wantGlassJar = scanner.nextLine();

            boolean glassJar = false;
            if(wantGlassJar.equals("Y")) {
                glassJar = true;
            }
            Order order1 = new Order(glassJar);
            order1.addItem(flavor1, 1);
            order1.addTopping(topping1);
            System.out.println(order1.generateInvoice());
            order1.saveInvoiceToFile("invoice.txt");
            System.out.println("Invoice saved to invoice.txt");
        }
    }
}