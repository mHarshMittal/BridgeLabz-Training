
public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        return getBalance() < 1000.0 ? 1.0 : 0.0;
    }
}

