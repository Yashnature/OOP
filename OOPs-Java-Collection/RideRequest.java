import java.util.*;

class RideRequest implements Comparable<RideRequest> {
    String customerName;
    int priority;

    public RideRequest(String customerName, int priority) {
        this.customerName = customerName;
        this.priority = priority;
    }

    @Override
    public int compareTo(RideRequest other) {
        return Integer.compare(other.priority, this.priority);
    }

    public String toString() {
        return customerName + " (Priority: " + priority + ")";
    }
}

class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Ride {
    RideRequest request;
    Driver driver;

    public Ride(RideRequest request, Driver driver) {
        this.request = request;
        this.driver = driver;
    }

    public String toString() {
        return "Ride{" + request + " with " + driver + "}";
    }
}

public class RideSharingSystem {
    Queue<RideRequest> requestQueue = new LinkedList<>();
    PriorityQueue<RideRequest> priorityQueue = new PriorityQueue<>();
    Set<Driver> availableDrivers = new HashSet<>();
    List<Ride> completedRides = new ArrayList<>();

    public void addRideRequest(RideRequest request) {
        requestQueue.add(request);
        priorityQueue.add(request);
    }

    public void addDriver(Driver driver) {
        availableDrivers.add(driver);
    }

    public void assignRide() {
        if (priorityQueue.isEmpty() || availableDrivers.isEmpty()) return;
        RideRequest request = priorityQueue.poll();
        Driver driver = availableDrivers.iterator().next();
        availableDrivers.remove(driver);
        completedRides.add(new Ride(request, driver));
        requestQueue.remove(request);
    }

    public void showCompletedRides() {
        for (Ride ride : completedRides) System.out.println(ride);
    }

    public static void main(String[] args) {
        RideSharingSystem system = new RideSharingSystem();

        system.addDriver(new Driver("Amit"));
        system.addDriver(new Driver("Neha"));

        system.addRideRequest(new RideRequest("Sam", 2));
        system.addRideRequest(new RideRequest("Ravi", 5));
        system.addRideRequest(new RideRequest("Priya", 3));

        system.assignRide();
        system.assignRide();

        system.showCompletedRides();
    }
}
