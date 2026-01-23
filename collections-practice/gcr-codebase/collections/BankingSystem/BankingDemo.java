import java.util.Map;

public class BankingDemo {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        
        Account account1 = new Account("ACC001", "Rajesh Kumar", 5000.0);
        Account account2 = new Account("ACC002", "Priya Sharma", 12000.0);
        Account account3 = new Account("ACC003", "Amit Patel", 7500.0);
        
        bankingSystem.addAccount(account1);
        bankingSystem.addAccount(account2);
        bankingSystem.addAccount(account3);
        
        System.out.println("=== All Accounts (HashMap) ===");
        Map<String, Account> allAccounts = bankingSystem.getAllAccounts();
        for (Account account : allAccounts.values()) {
            System.out.println(account);
        }
        
        System.out.println("\n=== Accounts Sorted by Balance (TreeMap) ===");
        Map<Double, Account> sortedAccounts = bankingSystem.getAccountsSortedByBalance();
        for (Account account : sortedAccounts.values()) {
            System.out.println(account);
        }
        
        System.out.println("\n=== Processing Withdrawal Requests (Queue) ===");
        bankingSystem.requestWithdrawal("ACC001");
        bankingSystem.requestWithdrawal("ACC002");
        bankingSystem.requestWithdrawal("ACC003");
        bankingSystem.processWithdrawals();
    }
}
