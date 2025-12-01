import java.util.*;

class Parcel implements Comparable<Parcel> {
    String parcelId;
    String recipient;
    int priority;

    public Parcel(String parcelId, String recipient, int priority) {
        this.parcelId = parcelId;
        this.recipient = recipient;
        this.priority = priority;
    }

    @Override
    public int compareTo(Parcel other) {
        return Integer.compare(other.priority, this.priority);
    }

    public String toString() {
        return parcelId + " -> " + recipient + " (Priority: " + priority + ")";
    }
}

public class CourierRoutingSystem {
    PriorityQueue<Parcel> priorityParcels = new PriorityQueue<>();
    Queue<Parcel> normalParcels = new LinkedList<>();
    Set<String> assignedParcelIds = new HashSet<>();
    List<Parcel> completedDeliveries = new ArrayList<>();

    public void addParcel(Parcel p) {
        if (!assignedParcelIds.contains(p.parcelId)) {
            assignedParcelIds.add(p.parcelId);
            if (p.priority > 5) priorityParcels.add(p);
            else normalParcels.add(p);
        }
    }

    public void assignDelivery() {
        Parcel p = null;
        if (!priorityParcels.isEmpty()) p = priorityParcels.poll();
        else if (!normalParcels.isEmpty()) p = normalParcels.poll();

        if (p != null) {
            System.out.println("Delivering: " + p);
            completedDeliveries.add(p);
        }
    }

    public void showCompletedDeliveries() {
        System.out.println("=== Completed Deliveries ===");
        for (Parcel p : completedDeliveries) System.out.println(p);
    }

    public static void main(String[] args) {
        CourierRoutingSystem system = new CourierRoutingSystem();

        system.addParcel(new Parcel("D001", "Alice", 8));
        system.addParcel(new Parcel("D002", "Bob", 4));
        system.addParcel(new Parcel("D003", "Charlie", 6));
        system.addParcel(new Parcel("D001", "Duplicate", 7)); // ignored

        system.assignDelivery();
        system.assignDelivery();
        system.assignDelivery();

        system.showCompletedDeliveries();
    }
}
