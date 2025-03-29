public final class Constants {
    public static final int MIN_FLIGHT_SEATS = 75;          // Minimum seats per flight
    public static final int MAX_FLIGHT_SEATS = 500;         // Maximum seats per flight
    public static final int MAX_SEATS_PER_BOOKING = 10;     // Max tickets per booking
    public static final double AIRCRAFT_SPEED_KNOTS = 450.0; // Cruise speed in knots

    public static final String FLIGHT_NUMBER_FORMAT = "^[A-Z]{2}-\\d{3}$";

    public static final String SEAT_BOOKING_SUCCESS = "Booking confirmed for %d seats on flight %s";
    public static final String SEAT_BOOKING_FAILURE = "Only %d seats available";

    public static final int FLIGHT_STATUS_SCHEDULED = 1;
    public static final int FLIGHT_STATUS_CANCELLED = 2;
    public static final int FLIGHT_STATUS_DELAYED = 3;

    public static final String ERR_INVALID_SEAT_COUNT =
            String.format("Seats must be between %d-%d", 1, MAX_SEATS_PER_BOOKING);
    public static final String ERR_FLIGHT_NOT_FOUND = "Flight not found in system";
    public static final String ERR_INSUFFICIENT_SEATS =
            String.format("Request exceeds available seats (Max: %d)", MAX_SEATS_PER_BOOKING);

    private Constants() {
        throw new AssertionError("Cannot instantiate constants class");
    }

    public static final String DEFAULT_ADMIN_USER = "root";
    public static final String DEFAULT_ADMIN_PASS = "root";
    public static final int MAX_ADMINS = 10;
    public static final int MAX_PASSWORD_LENGTH = 30;

    public static final int MIN_PASSENGER_AGE = 1;
    public static final int MAX_PASSENGER_AGE = 120;

    public static final int DISPLAY_LINE_LENGTH = 120;
    public static final String DATE_FORMAT = "EEEE, dd MMMM yyyy, HH:mm a";
    public static final String TIME_FORMAT = "HH:mm";

    public static final String WELCOME_BANNER =
            "\n=============================================\n" +
                    "      WELCOME TO BAV AIRLINES SYSTEM       \n" +
                    "=============================================\n";

    public static final String INVALID_EMAIL_MSG = "Invalid email format";
    public static final String INVALID_PHONE_MSG = "Phone can only contain numbers, +, - or spaces";
    public static final String LOGIN_FAILED_MSG = "Invalid username or password";

    public static final String FLIGHT_NOT_FOUND = "Flight not found";
    public static final String NO_SEATS_AVAILABLE = "No seats available";

    public static final String MAIN_MENU =
            "\nMAIN MENU:\n" +
                    "1. Admin Login\n" +
                    "2. Passenger Login\n" +
                    "3. Register New Passenger\n" +
                    "0. Exit\n" +
                    "Enter choice: ";
}