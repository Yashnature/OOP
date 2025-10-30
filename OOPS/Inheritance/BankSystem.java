import java.util.*;  

class BankAccount {
    String accountNumber;
    double balance;
}

class SavingsAccount extends BankAccount {
    double interestRate;

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int depositDuration; // in months

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Deposit Duration: " + depositDuration + " months");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount();
        s.accountNumber = "SA1001";
        s.balance = 5000;
        s.interestRate = 4.5;

        CheckingAccount c = new CheckingAccount();
        c.accountNumber = "CA1002";
        c.balance = 3000;
        c.withdrawalLimit = 1000;

        FixedDepositAccount f = new FixedDepositAccount();
        f.accountNumber = "FD1003";
        f.balance = 10000;
        f.depositDuration = 12;

        s.displayAccountType();
        System.out.println();
        c.displayAccountType();
        System.out.println();
        f.displayAccountType();
    }
}
