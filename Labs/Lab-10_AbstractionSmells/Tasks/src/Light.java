class Light extends PoweredDevice implements AdjustSettings {

    private String intensity;
    private String color;

    public Light(String location) {
        super(location);
    }

    public void turnOn() {
        System.out.println(location + " light turned on.");
    }

    public void turnOff() {
        System.out.println(location + " light turned off.");
    }

    public void adjustSettings() {
        System.out.println("Adjusting \"" + location + "\" light intensity and color.");
    }

}
