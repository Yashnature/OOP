import java.util.*;

public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 500.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car");
        Vehicle v2 = new Vehicle("Bob", "Motorbike");

        System.out.println("Before updating registration fee:\n");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        updateRegistrationFee(750.0);

        System.out.println("\nAfter updating registration fee:\n");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
