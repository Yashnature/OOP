import java.util.*;  

class Employee {
    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println("Employee Details");
    }
}

class Manager extends Employee {
    int teamSize;

    void displayDetails() {
        System.out.println("Manager Name: " + name);
        System.out.println("Manager ID: " + id);
        System.out.println("Manager Salary: " + salary);
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    void displayDetails() {
        System.out.println("Developer Name: " + name);
        System.out.println("Developer ID: " + id);
        System.out.println("Developer Salary: " + salary);
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String duration;

    void displayDetails() {
        System.out.println("Intern Name: " + name);
        System.out.println("Intern ID: " + id);
        System.out.println("Intern Salary: " + salary);
        System.out.println("Internship Duration: " + duration);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.name = "Alice";
        m.id = 101;
        m.salary = 90000;
        m.teamSize = 10;

        Developer d = new Developer();
        d.name = "Bob";
        d.id = 102;
        d.salary = 60000;
        d.programmingLanguage = "Java";

        Intern i = new Intern();
        i.name = "Charlie";
        i.id = 103;
        i.salary = 20000;
        i.duration = "6 months";

        m.displayDetails();
        System.out.println();
        d.displayDetails();
        System.out.println();
        i.displayDetails();
    }
}
