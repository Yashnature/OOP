import java.util.*;

class Account {
    String accountId;
    double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String toString() {
        return accountId + " (Balance: " + balance + ")";
    }
}

class Transaction {
    String fromAccount;
    String toAccount;
    double amount;

    public Transaction(String fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public String toString() {
        return "Transaction{" + fromAccount + " -> " + toAccount + ", Amount: " + amount + "}";
    }
}

public class BankingSystem {
    List<Transaction> transactionHistory = new ArrayList<>();
    Queue<Transaction> pendingTransactions = new LinkedList<>();
    Set<String> validAccounts = new HashSet<>();
    Stack<Transaction> rollbackStack = new Stack<>();
    Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.accountId, account);
        validAccounts.add(account.accountId);
    }

    public void addTransaction(Transaction t) {
        pendingTransactions.add(t);
    }

    public void executeTransactions() {
        while (!pendingTransactions.isEmpty()) {
            Transaction t = pendingTransactions.poll();
            if (validAccounts.contains(t.fromAccount) && validAccounts.contains(t.toAccount)) {
                Account from = accounts.get(t.fromAccount);
                Account to = accounts.get(t.toAccount);
                if (from.balance >= t.amount) {
                    from.balance -= t.amount;
                    to.balance += t.amount;
                    transactionHistory.add(t);
                    rollbackStack.push(t);
                }
            }
        }
    }

    public void rollbackLastTransaction() {
        if (!rollbackStack.isEmpty()) {
            Transaction last = rollbackStack.pop();
            Account from = accounts.get(last.fromAccount);
            Account to = accounts.get(last.toAccount);
            to.balance -= last.amount;
            from.balance += last.amount;
            transactionHistory.remove(last);
        }
    }

    public void showAccounts() {
        for (Account a : accounts.values()) System.out.println(a);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount(new Account("A1", 1000));
        bank.addAccount(new Account("A2", 500));

        bank.addTransaction(new Transaction("A1", "A2", 200));
        bank.addTransaction(new Transaction("A2", "A1", 100));

        bank.executeTransactions();
        bank.showAccounts();

        System.out.println("Rolling back last transaction...");
        bank.rollbackLastTransaction();
        bank.showAccounts();
    }
}
