
public abstract class BankAccount {
    private final String accountNumber;
    private final double balance;

    protected BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final String getAccountNumber() {
        return accountNumber;
    }

    public final double getBalance() {
        return balance;
    }

    public abstract double calculateFee();
}

