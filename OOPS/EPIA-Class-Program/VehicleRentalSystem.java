import java.util.*;

interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.1;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Car Insurance Policy: " + policyNumber);
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days * 0.8;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.05;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Bike Insurance Policy: " + policyNumber);
    }
}

class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days * 1.5;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.2;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Truck Insurance Policy: " + policyNumber);
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C101", 2000, "CAR123"));
        vehicles.add(new Bike("B202", 500, "BIKE456"));
        vehicles.add(new Truck("T303", 3000, "TRUCK789"));

        int days = 5;
        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(days);
            double insurance = 0;
            if (v instanceof Insurable) {
                insurance = ((Insurable) v).calculateInsurance();
                ((Insurable) v).getInsuranceDetails();
            }
            System.out.println("Vehicle: " + v.getType() +
                               ", Number: " + v.getVehicleNumber() +
                               ", Rental for " + days + " days: " + rentalCost +
                               ", Insurance: " + insurance +
                               ", Total: " + (rentalCost + insurance));
            System.out.println();
        }
    }
}
