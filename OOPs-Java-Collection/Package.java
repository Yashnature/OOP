import java.util.*;

class Package {
    String packageId;
    String recipient;

    public Package(String packageId, String recipient) {
        this.packageId = packageId;
        this.recipient = recipient;
    }

    public String toString() {
        return packageId + " -> " + recipient;
    }
}

public class WarehouseTrackingSystem {
    Queue<Package> pendingDeliveries = new LinkedList<>();
    Set<String> packageIds = new HashSet<>();
    List<Package> deliveredPackages = new ArrayList<>();
    Stack<Package> returnedPackages = new Stack<>();

    public void addDeliveryRequest(Package p) {
        if (!packageIds.contains(p.packageId)) {
            packageIds.add(p.packageId);
            pendingDeliveries.add(p);
        }
    }

    public void processDelivery(boolean delivered) {
        if (pendingDeliveries.isEmpty()) return;
        Package p = pendingDeliveries.poll();
        if (delivered) deliveredPackages.add(p);
        else returnedPackages.push(p);
    }

    public void showSummary() {
        System.out.println("=== Delivered Packages ===");
        for (Package p : deliveredPackages) System.out.println(p);

        System.out.println("=== Returned Packages ===");
        for (Package p : returnedPackages) System.out.println(p);

        System.out.println("=== Pending Deliveries ===");
        for (Package p : pendingDeliveries) System.out.println(p);
    }

    public static void main(String[] args) {
        WarehouseTrackingSystem system = new WarehouseTrackingSystem();

        system.addDeliveryRequest(new Package("P001", "Alice"));
        system.addDeliveryRequest(new Package("P002", "Bob"));
        system.addDeliveryRequest(new Package("P003", "Charlie"));
        system.addDeliveryRequest(new Package("P001", "Duplicate")); // ignored

        system.processDelivery(true);
        system.processDelivery(false);
        system.processDelivery(true);

        system.showSummary();
    }
}
