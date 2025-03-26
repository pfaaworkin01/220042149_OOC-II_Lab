class SecurityAlarm extends SecurityDevice implements Notify, AdjustSettings {

    public SecurityAlarm(String location) {
        super(location);
    }

    private boolean passwordVerification() {
        return false;
    }

    public void turnOn() {
        System.out.println(location + " alarm turned on.");
    }

    public void turnOff() {
        System.out.println(location + " alarm turned off.");
    }

    public void adjustSettings() {
        System.out.println("Adjusting \"" + location + "\" alarm settings.");
    }

    public void sendNotification() {
        if(passwordVerification()) {
            System.out.println(location + " alarm password verified.");
        }
        else {
            System.out.println(location + " alarm password not verified.");
        }
    }

}
