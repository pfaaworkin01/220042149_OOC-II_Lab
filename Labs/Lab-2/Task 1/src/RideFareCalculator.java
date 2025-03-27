public class RideFareCalculator {

    private final double baseFare = 5.0;
    private final double fareRate = 0.50;


    public RideFareCalculator() {
    }

    public double totalFare(double distance, double estimatedTime, String rideType, double timeTaken) {
        double totalFare = baseFare + (fareRate * timeTaken);

        switch (rideType) {
            case "Economy":
                totalFare += distance * 1.75;
                break;
            case "Premium":
                totalFare += distance * 3.0;
                totalFare *= 1.20;
                break;
            default:
                throw new IllegalArgumentException("Invalid ride type");
        }
        if (timeTaken < estimatedTime - 10) {
            totalFare *= 0.90;
        }

        return Math.round(totalFare * 100.0) / 100.0;
    }

}