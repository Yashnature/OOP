import java.util.*;
import java.util.stream.Collectors;

public class InvoiceDemo {
    public static void main(String[] args) {
        List<Integer> transactionIds = Arrays.asList(101, 102, 103);

        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}

class Invoice {
    int transactionId;

    Invoice(int transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "Invoice{transactionId=" + transactionId + "}";
    }
}
