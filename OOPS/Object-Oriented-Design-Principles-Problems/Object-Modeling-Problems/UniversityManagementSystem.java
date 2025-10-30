import java.util.*;

public class UniversityManagementSystem {
    public static void main(String[] args) {
        class Student {
            String name;
            ArrayList<Course> courses = new ArrayList<>();

            Student(String name) {
                this.name = name;
            }

            void enrollCourse(Course c) {
                courses.add(c);
                c.students.add(this);
                System.out.println(name + " enrolled in " + c.courseName);
            }
        }

        class Professor {
            String name;
            ArrayList<Course> courses = new ArrayList<>();

            Professor(String name) {
                this.name = name;
            }

            void assignCourse(Course c) {
                courses.add(c);
                c.professor = this;
                System.out.println(name + " assigned to teach " + c.courseName);
            }
        }

        class Course {
            String courseName;
            Professor professor;
            ArrayList<Student> students = new ArrayList<>();

            Course(String courseName) {
                this.courseName = courseName;
            }
        }

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        Student s1 = new Student("Raghuraj");
        Student s2 = new Student("Ananya");

        Professor p1 = new Professor("Dr. Sharma");
        Professor p2 = new Professor("Dr. Verma");

        p1.assignCourse(c1);
        p2.assignCourse(c2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c2);

        System.out.println("\nCourse details:");
        Course[] allCourses = {c1, c2};
        for (Course c : allCourses) {
            System.out.print(c.courseName + " taught by " + c.professor.name + " has students: ");
            for (Student s : c.students) {
                System.out.print(s.name + " ");
            }
            System.out.println();
        }
    }
}
