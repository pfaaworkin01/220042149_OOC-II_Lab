import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final String userID;
    private String name;
    private String email;
    private String phone;
    private final String password;
    private String address;
    private int age;
    private final List<Flight> flightsRegisteredByUser;
    private final List<Integer> numOfTicketsBookedByUser;

    public Customer(CustomerRegistration registration) {
        this.userID = RandomGenerator.generateId();
        this.name = registration.getName();
        this.email = registration.getEmail();
        this.password = registration.getPassword();
        this.phone = registration.getPhone();
        this.address = registration.getAddress();
        this.age = registration.getAge();
        this.flightsRegisteredByUser = new ArrayList<>();
        this.numOfTicketsBookedByUser = new ArrayList<>();
    }

    public void registerFlight(Flight flight, int tickets) {
        flightsRegisteredByUser.add(flight);
        numOfTicketsBookedByUser.add(tickets);
    }

    public void updateTickets(int flightIndex, int additionalTickets) {
        int current = numOfTicketsBookedByUser.get(flightIndex);
        numOfTicketsBookedByUser.set(flightIndex, current + additionalTickets);
    }

    public String getUserID() { return userID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public String getAddress() { return address; }
    public int getAge() { return age; }
    public List<Flight> getRegisteredFlights() { return Collections.unmodifiableList(flightsRegisteredByUser); }
    public List<Integer> getTicketCounts() { return Collections.unmodifiableList(numOfTicketsBookedByUser); }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setAge(int age) { this.age = age; }
}