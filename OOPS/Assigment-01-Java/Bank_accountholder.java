import java.util.Scanner;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class Bank_accountholder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.print("Enter Account Holder Name: ");
        account.accountHolder = sc.nextLine();

        System.out.print("Enter Account Number: ");
        account.accountNumber = sc.nextLine();

        account.balance = 0;

        account.deposit(1000);
        account.displayBalance();

        account.withdraw(500);
        account.displayBalance();

        account.withdraw(600);
        account.displayBalance();
        
        sc.close();
    }
}
