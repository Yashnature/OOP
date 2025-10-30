import java.util.*;

public class Bank {
    String bankName;
    ArrayList<Customer> customers = new ArrayList<>();

    Bank(String bankName) {
        this.bankName = bankName;
    }

    void openAccount(Customer c, int accNumber, double initialDeposit) {
        Account a = new Account(accNumber, initialDeposit);
        c.accounts.add(a);
        if (!customers.contains(c)) {
            customers.add(c);
        }
        System.out.println("Account opened for " + c.name + " in " + bankName + " with ₹" + initialDeposit);
    }

    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank of India");
        Bank bank2 = new Bank("HDFC Bank");

        Customer c1 = new Customer("Raghuraj Rajpoot");
        Customer c2 = new Customer("Ananya Sharma");

        bank1.openAccount(c1, 101, 5000);
        bank1.openAccount(c1, 102, 8000);
        bank2.openAccount(c2, 201, 12000);

        System.out.println();
        c1.viewBalance();
        System.out.println();
        c2.viewBalance();
    }
}

class Customer {
    String name;
    ArrayList<Account> accounts = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void viewBalance() {
        System.out.println("Account details for " + name + ":");
        for (Account a : accounts) {
            System.out.println("Account No: " + a.accountNumber + " | Balance: ₹" + a.balance);
        }
    }
}

class Account {
    int accountNumber;
    double balance;

    Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
