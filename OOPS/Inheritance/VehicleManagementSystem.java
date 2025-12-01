import java.util.*;  

interface Refuelable {
    void refuel();
}

class Vehicle {
    String model;
    int maxSpeed;
}

class ElectricVehicle extends Vehicle {
    void charge() {
        System.out.println("Electric Vehicle " + model + " is charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;

    public void refuel() {
        System.out.println("Petrol Vehicle " + model + " is refueling with tank capacity " + fuelTankCapacity + " liters.");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle();
        ev.model = "Tesla Model 3";
        ev.maxSpeed = 200;

        PetrolVehicle pv = new PetrolVehicle();
        pv.model = "Toyota Corolla";
        pv.maxSpeed = 180;
        pv.fuelTankCapacity = 50;

        ev.charge();
        System.out.println();
        pv.refuel();
    }
}
