// File: CollegeApp.java
import static java.lang.System.out;

class Student {
    private String studentId;
    private String name;
    private String course;

    public Student(String studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    @Override
    public String toString() {
        return "Student[ID=" + studentId + ", Name=" + name + ", Course=" + course + "]";
    }
}

class Faculty {
    private String facultyId;
    private String name;
    private String departmentName;

    public Faculty(String facultyId, String name, String departmentName) {
        this.facultyId = facultyId;
        this.name = name;
        this.departmentName = departmentName;
    }

    public String getFacultyId() { return facultyId; }
    public String getName() { return name; }
    public String getDepartmentName() { return departmentName; }

    @Override
    public String toString() {
        return "Faculty[ID=" + facultyId + ", Name=" + name + ", Dept=" + departmentName + "]";
    }
}

class Department {
    private String deptName;
    private String headOfDept;
    private java.util.List<String> coursesOffered;

    public Department(String deptName, String headOfDept) {
        this.deptName = deptName;
        this.headOfDept = headOfDept;
        this.coursesOffered = new java.util.ArrayList<>();
    }

    public String getDeptName() { return deptName; }
    public String getHeadOfDept() { return headOfDept; }

    public void addCourse(String course) {
        coursesOffered.add(course);
    }

    public java.util.List<String> getCoursesOffered() {
        return coursesOffered;
    }

    @Override
    public String toString() {
        return "Department[Name=" + deptName + ", Head=" + headOfDept + ", Courses=" + coursesOffered + "]";
    }
}

public class CollegeApp {
    public static void main(String[] args) {
        Student s1 = new Student("S101", "Alice", "Computer Science");
        Student s2 = new Student("S102", "Bob", "Mechanical Engineering");

        Faculty f1 = new Faculty("F201", "Dr. Smith", "Computer Science");
        Faculty f2 = new Faculty("F202", "Dr. Jones", "Mechanical Engineering");

        Department d1 = new Department("Computer Science", "Dr. Smith");
        d1.addCourse("Data Structures");
        d1.addCourse("Algorithms");

        Department d2 = new Department("Mechanical Engineering", "Dr. Jones");
        d2.addCourse("Thermodynamics");
        d2.addCourse("Fluid Mechanics");

        out.println("=== Students ===");
        out.println(s1);
        out.println(s2);

        out.println("\n=== Faculties ===");
        out.println(f1);
        out.println(f2);

        out.println("\n=== Departments ===");
        out.println(d1);
        out.println(d2);
    }
}
