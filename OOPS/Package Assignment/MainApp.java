
package com.company.main;

import com.company.hr.*;       
import com.company.payroll.Payroll; 

public class MainApp {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Alice", "IT", 50000);
        System.out.println("Employee Details:");
        System.out.println("ID: " + emp1.getId());
        System.out.println("Name: " + emp1.getName());
        System.out.println("Department: " + emp1.getDepartment());
        System.out.println("Salary: " + emp1.getSalary());
        Payroll payroll = new Payroll();
        double totalSalary = payroll.calculateBonus(emp1);
        System.out.println("Salary after 10% bonus: " + totalSalary);
    }
}
