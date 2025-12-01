import java.util.*;

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalProcessor();
        PaymentProcessor stripe = new StripeProcessor();

        paypal.processPayment(500);
        paypal.refund(200);

        stripe.processPayment(1000);
        stripe.refund(300);
    }
}

interface PaymentProcessor {
    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Refunded: $" + amount);
    }
}

class PayPalProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}

class StripeProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment: $" + amount);
    }
}
