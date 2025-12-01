import java.util.*;

public class Patient {
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Patient ID: " + patientID);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Alice", 30, "Fever", 101);
        Patient p2 = new Patient("Bob", 45, "Diabetes", 102);

        p1.displayDetails();
        p2.displayDetails();

        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}
