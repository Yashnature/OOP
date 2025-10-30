import java.util.*;

public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public static void main(String[] args) {
        Student s = new Student(101, "Alice", 8.6);
        System.out.println("Student Details:");
        System.out.println("Roll Number: " + s.rollNumber);
        System.out.println("Name: " + s.name);
        System.out.println("CGPA: " + s.getCGPA());

        s.setCGPA(9.0);
        System.out.println("Updated CGPA: " + s.getCGPA());
    }
}
