abstract class SmartDevice {

    protected String location;

    public SmartDevice(String location) {
        this.location = location;
    }

    public abstract void turnOn();
    public abstract void turnOff();

}
