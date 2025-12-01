public class BankTransaction {

    public static double remainingLimit(Double limit, double withdrawn) {
        if (limit == null) {
            return 0.0;
        }
        return limit - withdrawn;
    }

    public static void main(String[] args) {
        Double limit1 = 5000.0;
        Double limit2 = null;
        double withdrawn = 1500.0;

        System.out.println("Remaining limit 1: " + remainingLimit(limit1, withdrawn));
        System.out.println("Remaining limit 2: " + remainingLimit(limit2, withdrawn));
    }
}
