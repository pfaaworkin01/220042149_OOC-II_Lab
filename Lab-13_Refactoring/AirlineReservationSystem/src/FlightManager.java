import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FlightManager extends FlightService {
    private final List<Flight> flights;

    public FlightManager() {
        this.flights = new ArrayList<>();
        initializeSampleFlights();
    }

    public FlightManager(List<Flight> flights) {
        this.flights = new ArrayList<>(flights);
    }

    private void initializeSampleFlights() {
        // Uses Refactoring #2: Magic literals replaced with constants
        flights.add(new Flight(
                RandomGenerator.generateFlightNumber(),
                "Monday, 15 January 2024, 08:00 AM",
                "New York",
                "London",
                "A12",
                3456.50,
                5561.82,
                Constants.MIN_FLIGHT_SEATS + 100
        ));
        // Add more sample flights...
    }

    // Core operations
    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }

    public boolean removeFlight(String flightNumber) {
        return flights.removeIf(f -> f.getFlightNumber().equals(flightNumber));
    }

    // Refactoring #7: Encapsulate Collection
    public List<Flight> getAllFlights() {
        return Collections.unmodifiableList(flights);
    }

    // Overrides superclass method with concrete implementation
    @Override
    public Optional<Flight> findFlight(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst();
    }

    // Business logic methods
    public boolean bookSeat(String flightNumber, int seats) {
        Optional<Flight> flight = findFlight(flightNumber);
        if (flight.isPresent() && flight.get().getAvailableSeats() >= seats) {
            flight.get().setAvailableSeats(flight.get().getAvailableSeats() - seats);
            return true;
        }
        return false;
    }

    public void cancelSeat(String flightNumber, int seats) {
        findFlight(flightNumber).ifPresent(flight ->
                flight.setAvailableSeats(flight.getAvailableSeats() + seats)
        );
    }
}