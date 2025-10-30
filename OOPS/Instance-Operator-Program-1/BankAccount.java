import java.util.*;

public class BankAccount {
    private static String bankName = "State bank of India";
    private static int totalAccounts = 0;

    private String accountHolderName;
    private final int accountNumber;

    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1001);
        BankAccount acc2 = new BankAccount("Bob", 1002);

        acc1.displayDetails();
        acc2.displayDetails();

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
