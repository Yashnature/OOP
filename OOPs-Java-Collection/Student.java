import java.util.*;

class Student implements Comparable<Student> {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.marks, this.marks);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return name.equals(s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class CollegeAdmissionSystem {
    List<Student> allApplicants = new ArrayList<>();
    Set<Student> shortlisted = new HashSet<>();
    Queue<Student> interviewQueue = new LinkedList<>();
    TreeSet<Student> meritList = new TreeSet<>();

    public void addApplicant(Student s) {
        allApplicants.add(s);
    }

    public void shortlist(double cutoff) {
        for (Student s : allApplicants) {
            if (s.marks >= cutoff) shortlisted.add(s);
        }
    }

    public void prepareInterviewQueue() {
        interviewQueue.addAll(shortlisted);
    }

    public void finalizeMeritList() {
        while (!interviewQueue.isEmpty()) {
            Student s = interviewQueue.poll();
            meritList.add(s);
        }
    }

    public void showMeritList() {
        System.out.println("=== Final Merit List ===");
        for (Student s : meritList) System.out.println(s);
    }

    public static void main(String[] args) {
        CollegeAdmissionSystem system = new CollegeAdmissionSystem();

        system.addApplicant(new Student("Amit", 88));
        system.addApplicant(new Student("Neha", 92));
        system.addApplicant(new Student("Ravi", 76));
        system.addApplicant(new Student("Priya", 85));

        system.shortlist(80);
        system.prepareInterviewQueue();
        system.finalizeMeritList();
        system.showMeritList();
    }
}
