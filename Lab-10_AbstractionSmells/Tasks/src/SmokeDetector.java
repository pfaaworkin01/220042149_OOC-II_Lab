class SmokeDetector extends SensoryDevice implements Notify, AdjustSettings {

    private boolean sprinkleControl;
    private boolean notificationSettings;

    public SmokeDetector(String location) {
        super(location);
    }

    @Override
    public void AdjustNotificationSettings() {
        if (notificationSettings) {
            System.out.println("Smoke detector notification enabled.");
        }
        else {
            System.out.println("Smoke detector notification disabled.");
        }
    }

    public void turnOn() {
        System.out.println("Smoke Detector at " + location + " activated.");
    }

    public void turnOff() {
        System.out.println("Smoke Detector at " + location + " deactivated.");
    }

    public void adjustSettings() {
        System.out.println("Adjusting \"" + location + "\" smoke detector sprinkle.");
    }

    public void sendNotification() {
        System.out.println("Smoke detected at " + location + "! Activating sprinklers.");
    }

}
