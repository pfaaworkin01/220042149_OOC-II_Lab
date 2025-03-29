import java.util.Random;

public final class RandomGenerator {
    private static final Random random = new Random();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public RandomGenerator() {}

    public static String generateId() {
        return String.format("%06d", random.nextInt(1000000));
    }

    public static String generateFlightNumber() {
        return String.format("%s-%03d",
                ALPHABET.charAt(random.nextInt(26)) + ALPHABET.charAt(random.nextInt(26)),
                random.nextInt(1000));
    }

    public static int generateSeats() {
        return Constants.MIN_FLIGHT_SEATS + random.nextInt(Constants.MAX_FLIGHT_SEATS - Constants.MIN_FLIGHT_SEATS);
    }
}