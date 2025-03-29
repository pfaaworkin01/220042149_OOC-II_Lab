public record BookingResult(boolean success, String flightNumber,
                            int tickets, String message) {

    public static BookingResult success(String flightNumber, int tickets) {
        return new BookingResult(true, flightNumber, tickets, "Booking successful");
    }

    public static BookingResult error(String message) {
        return new BookingResult(false, null, 0, message);
    }
}
