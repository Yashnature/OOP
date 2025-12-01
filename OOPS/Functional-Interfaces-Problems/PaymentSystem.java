import java.util.*;

class PaymentSystem {
    public static void main(String[] args) {
        Payment upi = new UPI("user@bank");
        Payment creditCard = new CreditCard("1234-5678-9012-3456");
        Payment wallet = new Wallet("MyWallet");

        upi.pay(500);
        creditCard.pay(1500);
        wallet.pay(200);
    }
}

interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    private String id;
    public UPI(String id) { this.id = id; }
    public void pay(double amount) { System.out.println("Paid " + amount + " via UPI: " + id); }
}

class CreditCard implements Payment {
    private String cardNumber;
    public CreditCard(String cardNumber) { this.cardNumber = cardNumber; }
    public void pay(double amount) { System.out.println("Paid " + amount + " via Credit Card: " + cardNumber); }
}

class Wallet implements Payment {
    private String walletName;
    public Wallet(String walletName) { this.walletName = walletName; }
    public void pay(double amount) { System.out.println("Paid " + amount + " via Wallet: " + walletName); }
}
