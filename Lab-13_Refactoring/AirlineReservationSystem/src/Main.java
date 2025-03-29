import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Main system class - Refactored with:
 * 1. Extracted admin operations (SRP)
 * 2. Command pattern for menu handling
 * 3. Dependency injection
 * 4. Guard clauses
 */
public class Main {
    // Refactoring #2: Replaced magic literals
    private static final String DEFAULT_USERNAME = Constants.DEFAULT_ADMIN_USER;
    private static final String DEFAULT_PASSWORD = Constants.DEFAULT_ADMIN_PASS;

    // Refactoring #1: Extracted dependencies
    private final CustomerManager customerManager;
    private final FlightManager flightManager;
    private final BookingSystem bookingSystem;
    private final DisplayHandler display;
    private final Scanner scanner;

    // Refactoring #3: Decomposed conditional (admin credentials)
    private final String[][] adminCredentials = new String[Constants.MAX_ADMINS][2];

    public User() {
        this.customerManager = new CustomerManager();
        this.flightManager = new FlightManager();
        this.bookingSystem = new BookingSystem(flightManager);
        this.display = new DisplayHandler();
        this.scanner = new Scanner(System.in);
        initializeDefaultAdmin();
    }

    // Refactoring #5: Parameter object for initialization
    public User(CustomerManager cm, FlightManager fm, BookingSystem bs, DisplayHandler dh) {
        this.customerManager = cm;
        this.flightManager = fm;
        this.bookingSystem = bs;
        this.display = dh;
        this.scanner = new Scanner(System.in);
        initializeDefaultAdmin();
    }

    private void initializeDefaultAdmin() {
        adminCredentials[0][0] = DEFAULT_USERNAME;
        adminCredentials[0][1] = DEFAULT_PASSWORD;
    }

    public void start() {
        display.welcomeMessage();
        int choice;
        do {
            display.mainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Refactoring #9: Replace conditional with polymorphism
            MenuCommand command = CommandFactory.createCommand(choice, this);
            if (command != null) {
                command.execute();
            } else if (choice != 0) {
                System.out.println("Invalid option!");
            }
        } while (choice != 0);
        scanner.close();
    }

    // Refactoring #6: Guard clauses for validation
    private boolean validateAdmin(String username, String password) {
        if (username == null || password == null) return false;

        return Arrays.stream(adminCredentials)
                .anyMatch(cred -> cred[0] != null &&
                        cred[0].equals(username) &&
                        cred[1].equals(password));
    }

    // Refactoring #4: Moved display logic to DisplayHandler
    // Refactoring #8: Extracted admin operations
    public void adminLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (validateAdmin(username, password)) {
            new AdminSession(customerManager, flightManager, bookingSystem).start();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    // Refactoring #7: Encapsulated customer operations
    public void passengerLogin() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Customer customer = customerManager.authenticate(email, password);
        if (customer != null) {
            new PassengerSession(customer, bookingSystem).start();
        } else {
            System.out.println("Login failed!");
        }
    }

    // Refactoring #5: Parameter object for registration
    public void registerPassenger() {
        CustomerRegistration registration = display.collectRegistrationDetails(scanner);
        try {
            Customer customer = new Customer(registration);
            customerManager.addCustomer(customer);
            System.out.println("Registration successful!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Refactoring #10: Pulled up common utilities
    private static class DisplayHandler {
        public void welcomeMessage() {
            System.out.println(Constants.WELCOME_BANNER);
        }

        public CustomerRegistration collectRegistrationDetails(Scanner scanner) {
            // Implementation...
        }
    }

    public static void main(String[] args) {
        new User().start();
    }
}