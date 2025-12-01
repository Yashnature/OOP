import java.util.*;

public class PrototypeDemo {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John", 101);
            Employee clone = (Employee) original.clone();

            System.out.println("Original: " + original);
            System.out.println("Clone: " + clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Employee implements Cloneable {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "Employee{name='" + name + "', id=" + id + "}";
    }
}
