import java.util.*;

class SmartHomeController {
    public static void main(String[] args) {
        SmartDevice livingRoomLight = new SmartLight("Living Room");
        SmartDevice bedroomAC = new AirConditioner("Bedroom");
        SmartDevice livingRoomTV = new Television("Living Room");

        livingRoomLight.turnOn();
        bedroomAC.turnOn();
        livingRoomTV.turnOn();

        System.out.println();

        livingRoomLight.turnOff();
        bedroomAC.turnOff();
        livingRoomTV.turnOff();
    }
}

interface SmartDevice {
    void turnOn();
    void turnOff();
}

class SmartLight implements SmartDevice {
    private String location;
    public SmartLight(String location) { this.location = location; }
    public void turnOn() { System.out.println(location + " Light is ON"); }
    public void turnOff() { System.out.println(location + " Light is OFF"); }
}

class AirConditioner implements SmartDevice {
    private String location;
    public AirConditioner(String location) { this.location = location; }
    public void turnOn() { System.out.println(location + " AC is ON"); }
    public void turnOff() { System.out.println(location + " AC is OFF"); }
}

class Television implements SmartDevice {
    private String location;
    public Television(String location) { this.location = location; }
    public void turnOn() { System.out.println(location + " TV is ON"); }
    public void turnOff() { System.out.println(location + " TV is OFF"); }
}
