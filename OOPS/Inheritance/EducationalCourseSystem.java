import java.util.*;  

class Course {
    String courseName;
    int duration; // in hours

    void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // in percentage

    void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class EducationalCourseSystem {
    public static void main(String[] args) {
        Course c = new Course();
        c.courseName = "Basic Programming";
        c.duration = 40;

        OnlineCourse o = new OnlineCourse();
        o.courseName = "Java Fundamentals";
        o.duration = 50;
        o.platform = "Udemy";
        o.isRecorded = true;

        PaidOnlineCourse p = new PaidOnlineCourse();
        p.courseName = "Advanced Java";
        p.duration = 60;
        p.platform = "Coursera";
        p.isRecorded = true;
        p.fee = 200;
        p.discount = 20;

        c.displayCourseInfo();
        System.out.println();
        o.displayCourseInfo();
        System.out.println();
        p.displayCourseInfo();
    }
}
