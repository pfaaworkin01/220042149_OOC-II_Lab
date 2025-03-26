import java.util.Scanner;

public class AskForPreference {

    Scanner scanner = new Scanner(System.in);
    public String askForFlavor() {
        System.out.println("Select flavor:\n");
        System.out.println("1. Cookies and Cream\n");
        System.out.println("2. Chocolate Fudge\n");
        System.out.println("3. Pistachio Delight\n");

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

    public double returnPrice() {
        double price = 0;
        switch (askForFlavor()) {
            case "Cookies and Cream":
                price = 2.80;
                break;
            case "Chocolate Fudge":
                price = 3.00;
                break;
            case "Pistachio Delight":
                price = 3.25;
                break;
        }

        return price;
    }
}
