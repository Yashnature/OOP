import java.util.*;

class Booking implements Comparable<Booking> {
    String userId;
    boolean isVIP;
    String event;

    public Booking(String userId, boolean isVIP, String event) {
        this.userId = userId;
        this.isVIP = isVIP;
        this.event = event;
    }

    @Override
    public int compareTo(Booking other) {
        return Boolean.compare(other.isVIP, this.isVIP);
    }

    public String toString() {
        return userId + (isVIP ? " (VIP)" : "") + " -> " + event;
    }
}

public class TicketReservationSystem {
    Set<String> registeredUsers = new HashSet<>();
    List<Booking> confirmedBookings = new ArrayList<>();
    Queue<Booking> bookingQueue = new LinkedList<>();
    PriorityQueue<Booking> vipQueue = new PriorityQueue<>();

    public boolean registerUser(String userId) {
        return registeredUsers.add(userId);
    }

    public void addBooking(String userId, boolean isVIP, String event) {
        if (registeredUsers.contains(userId)) {
            Booking b = new Booking(userId, isVIP, event);
            bookingQueue.add(b);
            if (isVIP) vipQueue.add(b);
        }
    }

    public void processBookings() {
        while (!vipQueue.isEmpty()) {
            Booking b = vipQueue.poll();
            confirmedBookings.add(b);
            bookingQueue.remove(b);
        }
        while (!bookingQueue.isEmpty()) {
            Booking b = bookingQueue.poll();
            confirmedBookings.add(b);
        }
    }

    public void showConfirmedBookings() {
        System.out.println("=== Confirmed Bookings ===");
        for (Booking b : confirmedBookings) System.out.println(b);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.registerUser("Alice");
        system.registerUser("Bob");
        system.registerUser("Charlie");

        system.addBooking("Alice", false, "Concert");
        system.addBooking("Bob", true, "Concert");
        system.addBooking("Charlie", false, "Concert");

        system.processBookings();
        system.showConfirmedBookings();
    }
}
