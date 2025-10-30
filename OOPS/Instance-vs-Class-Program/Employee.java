import java.util.*;

public class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        Manager mgr = new Manager(101, "Sales", 75000);
        System.out.println("Employee ID: " + mgr.employeeID);
        System.out.println("Department: " + mgr.department);
        System.out.println("Salary: $" + mgr.getSalary());

        mgr.setSalary(80000);
        System.out.println("Updated Salary: $" + mgr.getSalary());
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }
}
