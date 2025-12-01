import java.util.*;

class Patient {
    String id;
    String name;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Patient)) return false;
        Patient p = (Patient) obj;
        return id.equals(p.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return id + " - " + name;
    }
}

public class HospitalSystem {
    Set<Patient> admittedPatients = new HashSet<>();
    Queue<Patient> treatmentQueue = new LinkedList<>();
    Stack<Patient> dischargedPatients = new Stack<>();
    List<Patient> patientHistory = new ArrayList<>();

    public void admitPatient(Patient p) {
        if (admittedPatients.add(p)) {
            treatmentQueue.add(p);
            patientHistory.add(p);
        }
    }

    public void treatPatient() {
        if (!treatmentQueue.isEmpty()) {
            Patient p = treatmentQueue.poll();
            System.out.println("Treating: " + p);
        }
    }

    public void dischargePatient() {
        if (!admittedPatients.isEmpty()) {
            Patient p = treatmentQueue.poll();
            if (p != null) {
                admittedPatients.remove(p);
                dischargedPatients.push(p);
                System.out.println("Discharged: " + p);
            }
        }
    }

    public void readmitLastPatient() {
        if (!dischargedPatients.isEmpty()) {
            Patient p = dischargedPatients.pop();
            admittedPatients.add(p);
            treatmentQueue.add(p);
            System.out.println("Re-admitted: " + p);
        }
    }

    public void showPatientHistory() {
        System.out.println("=== Patient History ===");
        for (Patient p : patientHistory) System.out.println(p);
    }

    public static void main(String[] args) {
        HospitalSystem hospital = new HospitalSystem();

        Patient p1 = new Patient("P001", "Alice");
        Patient p2 = new Patient("P002", "Bob");
        Patient p3 = new Patient("P003", "Charlie");

        hospital.admitPatient(p1);
        hospital.admitPatient(p2);
        hospital.admitPatient(p3);

        hospital.treatPatient();
        hospital.dischargePatient();
        hospital.readmitLastPatient();

        hospital.showPatientHistory();
    }
}
