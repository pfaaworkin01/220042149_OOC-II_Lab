public class Main {
    public static void main(String[] args) {

        Light livingRoomLight = new Light("Living Room");
        AirConditioner bedroomAC = new AirConditioner("Bedroom");
        SecurityAlarm frontDoorAlarm = new SecurityAlarm("Front Door");
        SecurityCamera backyardCamera = new SecurityCamera("Backyard");
        SmokeDetector kitchenSmokeDetector = new SmokeDetector("Kitchen");
        HumiditySensor basementHumiditySensor = new HumiditySensor("Basement");

        livingRoomLight.turnOn();
        bedroomAC.adjustSettings();
        frontDoorAlarm.sendNotification();
        backyardCamera.turnOn();
        kitchenSmokeDetector.sendNotification();
        basementHumiditySensor.sendNotification();

    }
}