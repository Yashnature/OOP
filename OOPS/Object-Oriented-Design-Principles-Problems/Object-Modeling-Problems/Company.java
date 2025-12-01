import java.util.*;

public class Company {
    String companyName;
    ArrayList<Department> departments = new ArrayList<>();

    Company(String companyName) {
        this.companyName = companyName;
    }

    public static void main(String[] args) {
        Company comp = new Company("Tech Solutions");

        class Employee {
            String name;
            int id;

            Employee(String name, int id) {
                this.name = name;
                this.id = id;
            }
        }

        class Department {
            String deptName;
            ArrayList<Employee> employees = new ArrayList<>();

            Department(String deptName) {
                this.deptName = deptName;
            }
        }

        Department d1 = new Department("IT");
        d1.employees.add(new Employee("Raghuraj", 101));
        d1.employees.add(new Employee("Ananya", 102));

        Department d2 = new Department("HR");
        d2.employees.add(new Employee("Rahul", 201));
        d2.employees.add(new Employee("Priya", 202));

        comp.departments.add(d1);
        comp.departments.add(d2);

        System.out.println("Company: " + comp.companyName);
        for (Department d : comp.departments) {
            System.out.println(" Department: " + d.deptName);
            for (Employee e : d.employees) {
                System.out.println("  Employee: " + e.name + " | ID: " + e.id);
            }
        }

        comp = null;
        System.gc();
        System.out.println("\nCompany deleted. Departments and Employees no longer exist.");
    }
}
