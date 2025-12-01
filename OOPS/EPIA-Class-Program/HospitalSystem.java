import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public void addToHistory(String record) { medicalHistory.add(record); }
    public List<String> getMedicalHistory() { return new ArrayList<>(medicalHistory); }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis;
    }
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records = new ArrayList<>();

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        addToHistory(record);
    }

    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(records);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        addToHistory(record);
    }

    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(records);
    }
}

public class HospitalSystem {
    public static void processPatient(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Bill Amount: " + patient.calculateBill());
    }

    public static void main(String[] args) {
        InPatient inPatient = new InPatient("P101", "Ramesh", 45, "Pneumonia", 5, 2000);
        OutPatient outPatient = new OutPatient("P202", "Sita", 30, "Fever", 500);

        inPatient.addRecord("Admitted for treatment.");
        inPatient.addRecord("Discharged after 5 days.");

        outPatient.addRecord("Consultation done.");
        outPatient.addRecord("Follow-up scheduled.");

        processPatient(inPatient);
        System.out.println("In-Patient Records: " + inPatient.viewRecords());

        processPatient(outPatient);
        System.out.println("Out-Patient Records: " + outPatient.viewRecords());
    }
}
