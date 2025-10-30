import java.util.*;

public class SensitiveDataDemo {
    public static void main(String[] args) {
        SensitiveDataProcessor processor = new SensitiveDataProcessor();

        UserCredentials creds = new UserCredentials("Alice", "password123");
        TransactionInfo txn = new TransactionInfo(5001, 250.75);
        GeneralInfo info = new GeneralInfo("General Note");

        processor.process(creds);
        processor.process(txn);
        processor.process(info);
    }
}

interface SensitiveData {
}

class UserCredentials implements SensitiveData {
    String username;
    String password;

    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class TransactionInfo implements SensitiveData {
    int transactionId;
    double amount;

    TransactionInfo(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }
}

class GeneralInfo {
    String info;

    GeneralInfo(String info) {
        this.info = info;
    }
}

class SensitiveDataProcessor {
    void process(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting: " + obj.getClass().getSimpleName());
        } else {
            System.out.println("No encryption needed for: " + obj.getClass().getSimpleName());
        }
    }
}
