import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public abstract class FlightService {
    protected Optional<Flight> findFlight(List<Flight> flights, String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst();
    }

    protected boolean isSeatAvailable(Flight flight, int requestedSeats) {
        return flight.getAvailableSeats() >= requestedSeats;
    }

    protected String generateArrivalTime(String departureTime, String duration) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
        LocalDateTime departure = LocalDateTime.parse(departureTime, formatter);
        String[] timeParts = duration.split(":");
        LocalDateTime arrival = departure
                .plusHours(Long.parseLong(timeParts[0]))
                .plusMinutes(Long.parseLong(timeParts[1]));
        return arrival.format(DateTimeFormatter.ofPattern(Constants.TIME_FORMAT));
    }
}