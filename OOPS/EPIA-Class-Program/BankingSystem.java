import java.util.*;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient funds for " + holderName);
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.04;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.02;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 10000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount(101, "Alice", 8000));
        accounts.add(new CurrentAccount(102, "Bob", 15000));

        for (BankAccount acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() +
                               ", Holder: " + acc.getHolderName() +
                               ", Balance: " + acc.getBalance() +
                               ", Interest: " + acc.calculateInterest());
            if (acc instanceof Loanable) {
                ((Loanable) acc).applyForLoan(5000);
                System.out.println("Eligible for Loan: " + ((Loanable) acc).calculateLoanEligibility());
            }
            System.out.println();
        }
    }
}
