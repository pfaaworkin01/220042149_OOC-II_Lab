class SecurityCamera extends SecurityDevice implements Notify, AdjustSettings {

    private boolean autoSave = false;

    public SecurityCamera(String location) {
        super(location);
    }

    public void turnOn() {
        System.out.println(location + " alarm turned on.");
    }

    public void turnOff() {
        System.out.println(location + " alarm turned off.");
    }

    public void adjustSettings() {
        System.out.println("Adjusting \"" + location + "\" camera live feed.");
    }

    public void sendNotification() {
        if(autoSave) {
            System.out.println(location + " camera auto save turned on.");
        }
        else {
            System.out.println(location + " camera auto save turned off.");
        }
    }

}