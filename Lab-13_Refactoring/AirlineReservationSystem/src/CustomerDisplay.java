import java.util.List;

public class CustomerDisplay {
    public void showCustomerDetails(Customer customer) {
        System.out.println("Customer ID: " + customer.getUserID());
        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Age: " + customer.getAge());
        System.out.println("Address: " + customer.getAddress());
    }

    public void showBookedFlights(Customer customer) {
        System.out.println("\nBooked Flights:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-12s %-20s %-10s %-10s%n",
                "Flight", "Departure", "Seats", "Status");

        List<Flight> flights = customer.getRegisteredFlights();
        List<Integer> tickets = customer.getTicketCounts();

        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            System.out.printf("%-12s %-20s %-10d %-10s%n",
                    f.getFlightNumber(),
                    f.getDepartureTime(),
                    tickets.get(i),
                    "Confirmed");
        }
    }
}