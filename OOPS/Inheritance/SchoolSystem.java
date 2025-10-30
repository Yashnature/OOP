import java.util.*; 

class Person {
    String name;
    int age;
}

class Teacher extends Person {
    String subject;

    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    String grade;

    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.name = "Alice";
        t.age = 35;
        t.subject = "Mathematics";

        Student s = new Student();
        s.name = "Bob";
        s.age = 15;
        s.grade = "10th Grade";

        Staff st = new Staff();
        st.name = "Charlie";
        st.age = 40;
        st.department = "Administration";

        t.displayRole();
        System.out.println();
        s.displayRole();
        System.out.println();
        st.displayRole();
    }
}
