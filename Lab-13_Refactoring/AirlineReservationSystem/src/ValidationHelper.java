import java.util.regex.Pattern;

public final class ValidationHelper {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String PHONE_REGEX = "^[0-9\\-+ ]+$";

    private ValidationHelper() {}

    public static String validateAndFormatEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        String trimmed = email.trim();
        if (!EMAIL_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException(Constants.INVALID_EMAIL_MSG);
        }
        return trimmed.toLowerCase();
    }

    public static String validateAndFormatPhone(String phone) {
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }
        if (!phone.matches(PHONE_REGEX)) {
            throw new IllegalArgumentException(Constants.INVALID_PHONE_MSG);
        }
        return phone.replaceAll("[^0-9]", "");
    }

    public static int validateAge(int age) {
        if (age < Constants.MIN_PASSENGER_AGE || age > Constants.MAX_PASSENGER_AGE) {
            throw new IllegalArgumentException(
                    String.format("Age must be between %d-%d",
                            Constants.MIN_PASSENGER_AGE,
                            Constants.MAX_PASSENGER_AGE)
            );
        }
        return age;
    }

    public static void validateTickets(int tickets) {
        if (tickets < 1 || tickets > Constants.MAX_SEATS_PER_BOOKING) {
            throw new IllegalArgumentException(
                    String.format("Tickets must be between 1-%d", Constants.MAX_SEATS_PER_BOOKING)
            );
        }
    }
}
