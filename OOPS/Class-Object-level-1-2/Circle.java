import java.util.Scanner;

public class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    void displayDetails() {
        System.out.println("Radius         : " + radius);
        System.out.println("Area           : " + calculateArea());
        System.out.println("Circumference  : " + calculateCircumference());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        double r = sc.nextDouble();
        Circle c = new Circle(r);
        System.out.println("\n--------------------------");
        c.displayDetails();
        sc.close();
    }
}
