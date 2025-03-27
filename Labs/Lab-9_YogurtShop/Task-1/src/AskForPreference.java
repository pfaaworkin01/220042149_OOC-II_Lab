import java.util.Scanner;

public class AskForPreference {

    Scanner scanner = new Scanner(System.in);

    public String askForFlavor() {
        System.out.println("\nSelect flavor:");
        System.out.println("1. Cookies and Cream");
        System.out.println("2. Chocolate Fudge");
        System.out.println("3. Pistachio Delight");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return "Cookies and Cream";
            case 2:
                return "Chocolate Fudge";
            case 3:
                return "Pistachio Delight";
            default:
                System.out.println("Invalid choice");
                break;
        }

        return "Invalid choice";
    }

    public String askForToppings() {
        System.out.println("\nSelect toppings:");
        System.out.println("1. Sprinkles");
        System.out.println("2. Mixed Chopped Nuts");
        System.out.println("3. Crushed Gingerbread");
        System.out.println("4. Fresh Strawberries");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return "Sprinkles";
            case 2:
                return "Mixed Chopped Nuts";
            case 3:
                return "Crushed Gingerbread";
            case 4:
                return "Fresh Strawberries";
        }

        return "Invalid choice";
    }
}
