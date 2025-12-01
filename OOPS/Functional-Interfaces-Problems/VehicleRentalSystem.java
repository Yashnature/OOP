import java.util.*;

class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("Sedan");
        Vehicle bike = new Bike("Mountain Bike");
        Vehicle bus = new Bus("City Bus");

        car.rent();
        bike.rent();
        bus.rent();

        System.out.println();

        car.returnVehicle();
        bike.returnVehicle();
        bus.returnVehicle();
    }
}

interface Vehicle {
    void rent();
    void returnVehicle();
}

class Car implements Vehicle {
    private String model;
    public Car(String model) { this.model = model; }
    public void rent() { System.out.println(model + " car rented"); }
    public void returnVehicle() { System.out.println(model + " car returned"); }
}

class Bike implements Vehicle {
    private String model;
    public Bike(String model) { this.model = model; }
    public void rent() { System.out.println(model + " bike rented"); }
    public void returnVehicle() { System.out.println(model + " bike returned"); }
}

class Bus implements Vehicle {
    private String model;
    public Bus(String model) { this.model = model; }
    public void rent() { System.out.println(model + " bus rented"); }
    public void returnVehicle() { System.out.println(model + " bus returned"); }
}
