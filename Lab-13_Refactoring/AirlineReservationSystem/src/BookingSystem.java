import java.util.List;
import java.util.Optional;

public class BookingSystem extends FlightService {
    private final List<Flight> flights;

    public BookingSystem(List<Flight> flights) {
        this.flights = flights;
    }

    public BookingResult bookFlight(String customerId, String flightNumber, int tickets) {
        try {
            ValidationHelper.validateTickets(tickets);

            Optional<Flight> flightOpt = findFlight(flights, flightNumber);
            if (flightOpt.isEmpty()) {
                return BookingResult.error("Flight not found");
            }

            Flight flight = flightOpt.get();
            if (!isSeatAvailable(flight, tickets)) {
                return BookingResult.error("Not enough seats available");
            }

            Customer customer = new Customer();
            if (flight.addPassenger(customer, tickets)) {
                return BookingResult.success(flightNumber, tickets);
            }

            return BookingResult.error("Booking failed");
        } catch (IllegalArgumentException e) {
            return BookingResult.error(e.getMessage());
        }
    }
}