import java.util.*;  

class Device {
    String deviceId;
    String status;

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    void displayStatus() {
        System.out.println("Thermostat ID: " + deviceId);
        System.out.println("Status: " + status);
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Thermostat t = new Thermostat();
        t.deviceId = "T1001";
        t.status = "ON";
        t.temperatureSetting = 24;

        t.displayStatus();
    }
}
