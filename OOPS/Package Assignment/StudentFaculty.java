import college.student.Student;
import college.faculty.Faculty;

public class MainApp {
    public static void main(String[] args) {
        Student student = new Student("Riya Sharma", 101);
        Faculty faculty = new Faculty("Dr. Mehta", "Computer Science");
        System.out.println("=== Student Details ===");
        student.displayStudentDetails();
        System.out.println("\n=== Faculty Details ===");
        faculty.displayFacultyDetails();
    }
}
