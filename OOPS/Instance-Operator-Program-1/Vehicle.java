import java.util.*;

public class Vehicle {
    private static double registrationFee = 1000.0;

    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: " + registrationFee);
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car", "REG123");
        Vehicle v2 = new Vehicle("Bob", "Motorcycle", "REG456");

        v1.displayDetails();
        v2.displayDetails();

        Vehicle.updateRegistrationFee(1500);

        v1.displayDetails();
        v2.displayDetails();
    }
}
