public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee()); // expected 5.00

        BankAccount s2 = new SavingsAccount("67890", 500.0);
        System.out.printf("Savings 500 -> %.2f%n", s2.calculateFee()); // 2.50

        BankAccount c1 = new CheckingAccount("c1", 1500.0);
        System.out.printf("Checking 1500 -> %.2f%n", c1.calculateFee()); // 0.00

        BankAccount c2 = new CheckingAccount("c2", 500.0);
        System.out.printf("Checking 500 -> %.2f%n", c2.calculateFee()); // 1.00
    }
}

