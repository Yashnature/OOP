import java.util.*;  

interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;
}

class Chef extends Person implements Worker {
    String specialty;

    public void performDuties() {
        System.out.println("Chef " + name + " (ID: " + id + ") is cooking dishes.");
        System.out.println("Specialty: " + specialty);
    }
}

class Waiter extends Person implements Worker {
    int tableNumber;

    public void performDuties() {
        System.out.println("Waiter " + name + " (ID: " + id + ") is serving at table " + tableNumber + ".");
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef();
        chef.name = "Gordon";
        chef.id = 101;
        chef.specialty = "Italian Cuisine";

        Waiter waiter = new Waiter();
        waiter.name = "Alice";
        waiter.id = 201;
        waiter.tableNumber = 5;

        Worker[] workers = {chef, waiter};

        for (Worker w : workers) {
            w.performDuties();
            System.out.println();
        }
    }
}
