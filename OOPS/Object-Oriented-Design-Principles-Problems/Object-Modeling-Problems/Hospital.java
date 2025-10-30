import java.util.*;

public class Hospital {
    String hospitalName;
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public static void main(String[] args) {
        class Patient {
            String name;

            Patient(String name) {
                this.name = name;
            }
        }

        class Doctor {
            String name;
            ArrayList<Patient> patientList = new ArrayList<>();

            Doctor(String name) {
                this.name = name;
            }

            void consult(Patient p) {
                patientList.add(p);
                System.out.println(name + " consulted patient " + p.name);
            }
        }

        Hospital hospital = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dr. Raghuraj");
        Doctor d2 = new Doctor("Dr. Ananya");

        Patient p1 = new Patient("Rahul");
        Patient p2 = new Patient("Priya");
        Patient p3 = new Patient("Amit");

        hospital.doctors.add(d1);
        hospital.doctors.add(d2);

        hospital.patients.add(p1);
        hospital.patients.add(p2);
        hospital.patients.add(p3);

        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p2);
        d2.consult(p3);

        System.out.println("\nDoctor-patient relationships:");
        for (Doctor d : hospital.doctors) {
            System.out.print(d.name + " has consulted: ");
            for (Patient p : d.patientList) {
                System.out.print(p.name + " ");
            }
            System.out.println();
        }
    }
}
