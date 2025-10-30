import java.util.*;

public class School {
    String schoolName;
    ArrayList<Student> students = new ArrayList<>();

    School(String schoolName) {
        this.schoolName = schoolName;
    }

    public static void main(String[] args) {
        class Course {
            String courseName;
            ArrayList<Student> students = new ArrayList<>();

            Course(String courseName) {
                this.courseName = courseName;
            }
        }

        class Student {
            String studentName;
            ArrayList<Course> courses = new ArrayList<>();

            Student(String studentName) {
                this.studentName = studentName;
            }
        }

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");
        Course c3 = new Course("English");

        Student s1 = new Student("Raghuraj");
        Student s2 = new Student("Ananya");
        Student s3 = new Student("Rahul");

        s1.courses.add(c1);
        s1.courses.add(c2);
        s2.courses.add(c1);
        s2.courses.add(c3);
        s3.courses.add(c2);
        s3.courses.add(c3);

        c1.students.add(s1);
        c1.students.add(s2);
        c2.students.add(s1);
        c2.students.add(s3);
        c3.students.add(s2);
        c3.students.add(s3);

        School school = new School("Sunrise School");
        school.students.add(s1);
        school.students.add(s2);
        school.students.add(s3);

        System.out.println("School: " + school.schoolName);
        System.out.println("Students and their courses:");
        for (Student s : school.students) {
            System.out.print(" " + s.studentName + " enrolled in: ");
            for (Course c : s.courses) {
                System.out.print(c.courseName + " ");
            }
            System.out.println();
        }

        System.out.println("\nCourses and their enrolled students:");
        Course[] allCourses = {c1, c2, c3};
        for (Course c : allCourses) {
            System.out.print(" " + c.courseName + " has students: ");
            for (Student s : c.students) {
                System.out.print(s.studentName + " ");
            }
            System.out.println();
        }
    }
}
