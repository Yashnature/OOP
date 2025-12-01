import java.util.*;

public class PatientIDDemo {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(101, "Alice"));
        patients.add(new Patient(102, "Bob"));
        patients.add(new Patient(103, "Charlie"));

        System.out.println("Patient IDs:");
        patients.stream().map(Patient::getId).forEach(System.out::println);
    }
}

class Patient {
    private int id;
    private String name;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
