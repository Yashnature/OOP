import java.util.*;

public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("1234567890", "Alice", 1000.0, 2.5);
        System.out.println("Account Number: " + sa.accountNumber);
        System.out.println("Account Holder: " + sa.accountHolder);
        System.out.println("Balance: $" + sa.getBalance());
        System.out.println("Interest Rate: " + sa.interestRate + "%");

        sa.setBalance(1200.0);
        System.out.println("Updated Balance: $" + sa.getBalance());
    }
}

class SavingsAccount extends BankAccount {
    public double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
}
