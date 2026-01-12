import java.util.*;

// Digital wallet with transfers and balance checks.
public class DigitalWalletSystem {
    public static void main(String[] args) {
        WalletService service = new WalletService();
        service.createWallet("U1");
        service.createWallet("U2");

        service.addMoney("U1", 1000);
        service.transfer("U1", "U2", 300, new WalletTransfer());
        System.out.println("U2 balance: " + service.getBalance("U2"));
    }
}

class Wallet {
    private final String userId;
    private double balance;
    private final List<String> history = new ArrayList<>();

    Wallet(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void add(double amount) {
        balance += amount;
        history.add("Added " + amount);
    }

    public void deduct(double amount) {
        balance -= amount;
        history.add("Deducted " + amount);
    }

    public List<String> history() {
        return history;
    }
}

interface TransferService {
    void transfer(Wallet from, Wallet to, double amount);
}

class WalletInsufficientBalanceException extends RuntimeException {
    WalletInsufficientBalanceException(String msg) {
        super(msg);
    }
}

class WalletTransfer implements TransferService {
    @Override
    public void transfer(Wallet from, Wallet to, double amount) {
        if (from.getBalance() < amount) {
            throw new WalletInsufficientBalanceException("Wallet balance low");
        }
        from.deduct(amount);
        to.add(amount);
    }
}

class BankTransfer implements TransferService {
    @Override
    public void transfer(Wallet from, Wallet to, double amount) {
        if (from.getBalance() < amount) {
            throw new WalletInsufficientBalanceException("Bank transfer failed: low balance");
        }
        from.deduct(amount);
        to.add(amount);
    }
}

class WalletService {
    private final Map<String, Wallet> wallets = new HashMap<>();

    void createWallet(String userId) {
        wallets.put(userId, new Wallet(userId));
    }

    void addMoney(String userId, double amount) {
        wallet(userId).add(amount);
    }

    void withdraw(String userId, double amount) {
        Wallet wallet = wallet(userId);
        if (wallet.getBalance() < amount) {
            throw new WalletInsufficientBalanceException("Not enough funds");
        }
        wallet.deduct(amount);
    }

    void transfer(String fromId, String toId, double amount, TransferService transferService) {
        transferService.transfer(wallet(fromId), wallet(toId), amount);
    }

    double getBalance(String userId) {
        return wallet(userId).getBalance();
    }

    List<String> history(String userId) {
        return wallet(userId).history();
    }

    private Wallet wallet(String userId) {
        Wallet wallet = wallets.get(userId);
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet missing " + userId);
        }
        return wallet;
    }
}

