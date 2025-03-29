import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {
    private final String flightNumber;
    private final String departureTime;
    private final String origin;
    private final String destination;
    private final String gate;
    private final double distanceMiles;
    private final double distanceKm;
    private final String flightDuration;
    private int availableSeats;
    private final List<Customer> passengers;

    public Flight(String flightNumber, String departureTime, String origin,
                  String destination, String gate, double distanceMiles,
                  double distanceKm, int totalSeats) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.origin = origin;
        this.destination = destination;
        this.gate = gate;
        this.distanceMiles = distanceMiles;
        this.distanceKm = distanceKm;
        this.flightDuration = calculateFlightDuration(distanceMiles);
        this.availableSeats = totalSeats;
        this.passengers = new ArrayList<>();
    }

    private String calculateFlightDuration(double miles) {
        double hours = miles / Constants.AIRCRAFT_SPEED_KNOTS;
        int wholeHours = (int) hours;
        int minutes = (int) ((hours - wholeHours) * 60);
        return String.format("%02d:%02d", wholeHours, minutes);
    }

    public boolean addPassenger(Customer customer, int tickets) {
        if (availableSeats >= tickets) {
            passengers.add(customer);
            availableSeats -= tickets;
            return true;
        }
        return false;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDepartureTime() { return departureTime; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getGate() { return gate; }
    public double getDistanceMiles() { return distanceMiles; }
    public double getDistanceKm() { return distanceKm; }
    public String getFlightDuration() { return flightDuration; }
    public int getAvailableSeats() { return availableSeats; }
    public List<Customer> getPassengers() { return Collections.unmodifiableList(passengers); }
}