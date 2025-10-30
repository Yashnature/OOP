import java.util.*;

interface Department {
    void assignDepartment(String deptName);
    void getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    protected double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary);
    }
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary;
    }

    @Override
    public void assignDepartment(String deptName) {
        department = deptName;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + department);
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
    }

    @Override
    double calculateSalary() {
        return baseSalary * workHours;
    }

    @Override
    public void assignDepartment(String deptName) {
        department = deptName;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + department);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(101, "Alice", 30000));
        employees.add(new PartTimeEmployee(102, "Bob", 500, 40));

        for (Employee e : employees) {
            e.displayDetails();
            System.out.println("Salary: " + e.calculateSalary());
            if (e instanceof Department) {
                ((Department) e).assignDepartment(e.getName().equals("Alice") ? "HR" : "Finance");
                ((Department) e).getDepartmentDetails();
            }
            System.out.println();
        }
    }
}
