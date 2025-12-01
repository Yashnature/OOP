import java.util.*;

public class University {
    String universityName;
    ArrayList<Department> departments = new ArrayList<>();

    University(String universityName) {
        this.universityName = universityName;
    }

    public static void main(String[] args) {
        class Faculty {
            String name;
            String designation;

            Faculty(String name, String designation) {
                this.name = name;
                this.designation = designation;
            }
        }

        class Department {
            String deptName;
            ArrayList<Faculty> facultyList = new ArrayList<>();

            Department(String deptName) {
                this.deptName = deptName;
            }
        }

        Faculty f1 = new Faculty("Dr. Raghuraj", "Professor");
        Faculty f2 = new Faculty("Dr. Ananya", "Associate Professor");
        Faculty f3 = new Faculty("Dr. Rahul", "Assistant Professor");

        Department d1 = new Department("Computer Science");
        d1.facultyList.add(f1);
        d1.facultyList.add(f2);

        Department d2 = new Department("Mechanical Engineering");
        d2.facultyList.add(f3);

        University uni = new University("Global University");
        uni.departments.add(d1);
        uni.departments.add(d2);

        System.out.println("University: " + uni.universityName);
        for (Department d : uni.departments) {
            System.out.println(" Department: " + d.deptName);
            for (Faculty f : d.facultyList) {
                System.out.println("  Faculty: " + f.name + " | " + f.designation);
            }
        }

        System.out.println("\nFaculty f1 exists independently: " + f1.name);

        uni = null;
        System.gc();
        System.out.println("\nUniversity deleted. Departments are also deleted but faculty can exist independently.");
    }
}
