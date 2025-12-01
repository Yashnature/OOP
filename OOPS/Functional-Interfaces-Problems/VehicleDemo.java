import java.util.*;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle electricCar = new ElectricCar();

        car.displaySpeed();
        electricCar.displaySpeed();
        electricCar.displayBattery();
    }
}

interface Vehicle {
    void displaySpeed();

    default void displayBattery() {
    }
}

class Car implements Vehicle {
    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Electric Car speed: 70 km/h");
    }

    public void displayBattery() {
        System.out.println("Battery: 85%");
    }
}
