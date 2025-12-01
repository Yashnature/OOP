import java.util.*;  

class Vehicle {
    int maxSpeed;
    String fuelType;

    void displayInfo() {
        System.out.println("Vehicle Information");
    }
}

class Car extends Vehicle {
    int seatCapacity;

    void displayInfo() {
        System.out.println("Car Details:");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int loadCapacity;

    void displayInfo() {
        System.out.println("Truck Details:");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    String type; // e.g., Sports or Cruiser

    void displayInfo() {
        System.out.println("Motorcycle Details:");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Type: " + type);
    }
}

public class VehicleTransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        Car c = new Car();
        c.maxSpeed = 180;
        c.fuelType = "Petrol";
        c.seatCapacity = 5;

        Truck t = new Truck();
        t.maxSpeed = 120;
        t.fuelType = "Diesel";
        t.loadCapacity = 15;

        Motorcycle m = new Motorcycle();
        m.maxSpeed = 150;
        m.fuelType = "Petrol";
        m.type = "Sports";

        vehicles[0] = c;
        vehicles[1] = t;
        vehicles[2] = m;

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
