import java.util.Scanner;

public class MobilePhone {
    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Mobile Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Mobile Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Mobile Price: ");
        double price = sc.nextDouble();

        MobilePhone phone = new MobilePhone(brand, model, price);

        System.out.println("\n-------------------------");
        phone.displayDetails();

        sc.close();
    }
}
