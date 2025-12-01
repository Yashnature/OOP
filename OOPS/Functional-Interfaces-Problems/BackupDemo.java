import java.util.*;

public class BackupDemo {
    public static void main(String[] args) {
        BackupProcessor processor = new BackupProcessor();

        UserData user = new UserData("Alice", 101);
        TransactionData transaction = new TransactionData(5001, 250.75);

        processor.backup(user);
        processor.backup(transaction);
        processor.backup(new NonSerializableData("Temp"));
    }
}

interface BackupSerializable {
}

class UserData implements BackupSerializable {
    String name;
    int id;

    UserData(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class TransactionData implements BackupSerializable {
    int transactionId;
    double amount;

    TransactionData(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }
}

class NonSerializableData {
    String info;

    NonSerializableData(String info) {
        this.info = info;
    }
}

class BackupProcessor {
    void backup(Object obj) {
        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up: " + obj.getClass().getSimpleName());
        } else {
            System.out.println("Cannot backup: " + obj.getClass().getSimpleName());
        }
    }
}
