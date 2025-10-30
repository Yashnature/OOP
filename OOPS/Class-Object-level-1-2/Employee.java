import java.util.Scanner;

public class Employee {
    String name;
    int id;
    double salary;

    employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : " + salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        employee emp = new employee(name, id, salary);
        System.out.println("\n-------------------------");
        emp.displayDetails();
        sc.close();
    }
}
