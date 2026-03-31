import java.util.*;

// Demonstrates core OOP for an online banking flow.
public class OnlineBankingSystem {
    public static void main(String[] args) {
        BankService bank = new SimpleBankService();
        bank.createSavingsAccount("A100", "Alex", 5000);
        bank.createSavingsAccount("A200", "Sam", 2000);

        bank.deposit("A100", 1500);
        bank.transfer("A100", "A200", 1200);
        bank.withdraw("A200", 300);

        System.out.println("Alex balance: " + bank.getBalance("A100"));
        System.out.println("Sam balance: " + bank.getBalance("A200"));
        bank.getHistory("A100").forEach(System.out::println);
    }
}

interface BankService {
    void createSavingsAccount(String id, String owner, double openingBalance);
    void deposit(String id, double amount);
    void withdraw(String id, double amount);
    void transfer(String fromId, String toId, double amount);
    double getBalance(String id);
    List<String> getHistory(String id);
}

abstract class Account {
    private final String id;
    private final String owner;
    protected double balance;
    private final List<String> history = new ArrayList<>();

    protected Account(String id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        addHistory("Account opened with " + balance);
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    protected void addHistory(String entry) {
        history.add(entry);
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public abstract double applyInterest();
}

class SavingsAccount extends Account {
    private static final double RATE = 0.03;

    SavingsAccount(String id, String owner, double balance) {
        super(id, owner, balance);
    }

    @Override
    public double applyInterest() {
        double interest = balance * RATE;
        balance += interest;
        addHistory("Interest added: " + interest);
        return interest;
    }
}

class InsufficientBalanceException extends RuntimeException {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

class SimpleBankService implements BankService {
    private final Map<String, Account> accounts = new HashMap<>();

    @Override
    public void createSavingsAccount(String id, String owner, double openingBalance) {
        accounts.put(id, new SavingsAccount(id, owner, openingBalance));
    }

    @Override
    public void deposit(String id, double amount) {
        Account account = getAccount(id);
        account.balance += amount;
        account.addHistory("Deposited: " + amount);
    }

    @Override
    public void withdraw(String id, double amount) {
        Account account = getAccount(id);
        if (account.balance < amount) {
            throw new InsufficientBalanceException("Balance too low for " + id);
        }
        account.balance -= amount;
        account.addHistory("Withdrew: " + amount);
    }

    @Override
    public void transfer(String fromId, String toId, double amount) {
        withdraw(fromId, amount);
        deposit(toId, amount);
        getAccount(fromId).addHistory("Transferred " + amount + " to " + toId);
        getAccount(toId).addHistory("Received " + amount + " from " + fromId);
    }

    @Override
    public double getBalance(String id) {
        return getAccount(id).getBalance();
    }

    @Override
    public List<String> getHistory(String id) {
        return getAccount(id).getHistory();
    }

    private Account getAccount(String id) {
        Account account = accounts.get(id);
        if (account == null) {
            throw new IllegalArgumentException("No account " + id);
        }
        return account;
    }
}

