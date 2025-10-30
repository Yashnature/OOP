import java.util.*;

interface Discountable {
    void applyDiscount(double discountPercent);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { 
        if(price > 0) this.price = price; 
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        if(quantity > 0) this.quantity = quantity; 
    }

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discount;
    }

    @Override
    public void applyDiscount(double discountPercent) {
        discount = (getPrice() * getQuantity()) * (discountPercent / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied on Veg Item: " + discount;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge = 20.0;
    private double discount;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + extraCharge) - discount;
    }

    @Override
    public void applyDiscount(double discountPercent) {
        discount = (getPrice() * getQuantity()) * (discountPercent / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied on Non-Veg Item: " + discount;
    }
}

public class FoodDeliverySystem {
    public static void processOrder(FoodItem item) {
        System.out.println(item.getItemDetails());
        System.out.println("Total Price: " + item.calculateTotalPrice());
    }

    public static void main(String[] args) {
        VegItem veg = new VegItem("Paneer Butter Masala", 200, 2);
        NonVegItem nonVeg = new NonVegItem("Chicken Biryani", 300, 1);

        veg.applyDiscount(10);
        nonVeg.applyDiscount(5);

        processOrder(veg);
        System.out.println(veg.getDiscountDetails());

        processOrder(nonVeg);
        System.out.println(nonVeg.getDiscountDetails());
    }
}
