import static java.lang.Math.pow;

class InterestCalculator {
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static double calculateCompoundInterest(double principal, double rate, double time) {
        return principal * (pow((1 + rate / 100), time)) - principal;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        double principal = 10000;
        double rate = 5;
        double time = 3;

        double simpleInterest = InterestCalculator.calculateSimpleInterest(principal, rate, time);
        double compoundInterest = InterestCalculator.calculateCompoundInterest(principal, rate, time);

        System.out.println("Principal: " + principal);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Time: " + time + " years");
        System.out.println("Simple Interest: " + simpleInterest);
        System.out.println("Compound Interest: " + compoundInterest);
    }
}
