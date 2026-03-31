class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

interface BankService {
    void deposit(double amt);

    void withdraw(double amt) throws InsufficientBalanceException;

    double getBalance();
}

class Account implements BankService {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // synchronized
    public synchronized void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt);
    }

    public synchronized void withdraw(double amt) throws InsufficientBalanceException {
        if (amt > balance)
            throw new InsufficientBalanceException("Not enough balance!");
        balance -= amt;
        System.out.println("Withdrawn: " + amt);
    }

    public double getBalance() {
        return balance;
    }

    public double calculateInterest() {
        return 0; // base account has no interest
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.05; // 5% interest
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02; // 2% interest
    }
}

public class OnlineBankDemo {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount(1000);
        Account acc2 = new CurrentAccount(2000);

        // multithreading
        Thread t1 = new Thread(() -> {
            try {
                acc1.withdraw(300);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> acc1.deposit(500));

        t1.start();
        t2.start();
        System.out.println("Savings Balance: " + acc1.getBalance());
        System.out.println("Savings Interest: " + acc1.calculateInterest());

        System.out.println("Current Balance: " + acc2.getBalance());
        System.out.println("Current Interest: " + acc2.calculateInterest());
    }
}