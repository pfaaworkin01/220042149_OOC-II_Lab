import java.util.List;

public class FlightDisplay {
    public void showFlightDetails(Flight flight) {
        System.out.println("\nFlight " + flight.getFlightNumber());
        System.out.println("--------------------------------------------------");
        System.out.println("Departure: " + flight.getDepartureTime());
        System.out.println("From: " + flight.getOrigin());
        System.out.println("To: " + flight.getDestination());
        System.out.println("Duration: " + flight.getFlightDuration());
        System.out.println("Available Seats: " + flight.getAvailableSeats());
        System.out.println("Gate: " + flight.getGate());
    }

    public void showFlightSchedule(List<Flight> flights) {
        System.out.println("\nFlight Schedule");
        System.out.println("==================================================================");
        System.out.printf("%-12s %-20s %-15s %-15s %-10s%n",
                "Flight", "Departure", "From", "To", "Seats");

        for (Flight f : flights) {
            System.out.printf("%-12s %-20s %-15s %-15s %-10d%n",
                    f.getFlightNumber(),
                    f.getDepartureTime(),
                    f.getOrigin(),
                    f.getDestination(),
                    f.getAvailableSeats());
        }
    }
}