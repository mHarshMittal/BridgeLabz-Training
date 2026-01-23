import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BankingSystem {
    private HashMap<String, Account> accountMap;
    private TreeMap<Double, Account> balanceSortedMap;
    private Queue<String> withdrawalQueue;
    
    public BankingSystem() {
        this.accountMap = new HashMap<>();
        this.balanceSortedMap = new TreeMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }
    
    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
        balanceSortedMap.put(account.getBalance(), account);
    }
    
    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }
    
    public void requestWithdrawal(String accountNumber) {
        withdrawalQueue.add(accountNumber);
    }
    
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            Account account = accountMap.get(accountNumber);
            if (account != null) {
                System.out.println("Processing withdrawal for: " + account);
            }
        }
    }
    
    public Map<String, Account> getAllAccounts() {
        return new HashMap<>(accountMap);
    }
    
    public TreeMap<Double, Account> getAccountsSortedByBalance() {
        return new TreeMap<>(balanceSortedMap);
    }
}
