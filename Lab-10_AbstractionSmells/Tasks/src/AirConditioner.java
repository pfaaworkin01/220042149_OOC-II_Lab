class AirConditioner extends PoweredDevice implements AdjustSettings {

    private boolean fanSpeed;
    private int temperature;

    public AirConditioner(String location) {
        super(location);
    }

    public void turnOn() {
        System.out.println(location + " AC turned on.");
    }

    public void turnOff() {
        System.out.println(location + " AC turned off.");
    }

    public void adjustSettings() {
        System.out.println("Adjusting \"" + location + "\" AC fan speed and temperature.");
    }

}
