import java.util.*;

interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    abstract double calculateDiscount();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.1;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Electronics Tax: 18%");
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.2;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Clothing Tax: 5%");
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();
        cart.add(new Electronics(1, "Laptop", 50000));
        cart.add(new Clothing(2, "T-Shirt", 2000));
        cart.add(new Groceries(3, "Apples", 500));

        for (Product p : cart) {
            double discount = p.calculateDiscount();
            double tax = 0;
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                ((Taxable) p).getTaxDetails();
            }
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Product: " + p.getName() + 
                               ", Price: " + p.getPrice() + 
                               ", Discount: " + discount + 
                               ", Tax: " + tax + 
                               ", Fin
