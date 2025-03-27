class HumiditySensor extends SensoryDevice implements Notify, AdjustSettings {

    private String measurementSettings;
    private boolean notificationSettings;

    public HumiditySensor(String location) {
        super(location);
    }

    @Override
    public void AdjustNotificationSettings() {
        if (notificationSettings) {
            System.out.println("Humidity sensor notification enabled.");
        }
        else {
            System.out.println("Humidity sensor notification disabled.");
        }
    }

    public void turnOn() {
        System.out.println("Humidity Sensor at " + location + " activated.");
    }

    public void turnOff() {
        System.out.println("Humidity Sensor at " + location + " deactivated.");
    }

    public void adjustSettings() {
        System.out.println("Adjusting \"" + location + "\" humidity sensor settings.");
    }

    public void sendNotification() {
        System.out.println("Humidity level changed at " + location + "!");
    }



}
