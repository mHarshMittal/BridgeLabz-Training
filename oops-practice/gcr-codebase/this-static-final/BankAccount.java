
public class BankAccount {
    // Static variable 
    private static String bankName = "State bank of India";
    private static int totalAcc = 0;

    // Final variable to ensure account number cannot be changed once assigned
    private final String acctNum;
    private String accHolderName;
    private double balance;
    
    // Constructor 
    public BankAccount(String accHolderName, String acctNum, double balance) {
        this.accHolderName = accHolderName;
        this.acctNum = acctNum;
        this.balance = balance;
        totalAcc++; 
    }
    
    // Static method to get the total number of accounts
    public static void getTotalAcc() {
        System.out.println("Total number of accounts: " + totalAcc);
    }
    
    // Method to display account details
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accHolderName);
            System.out.println("Account Number: " + acctNum);
            System.out.println("Balance: Rs/- " + balance);
        } else {
            System.out.println("Invalid account instance.");
        }
    }
    
    // Getters and setters
    public String getAccHolderName() {
        return accHolderName;
    }
    
    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs/- " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs/- " + amount);
        } else {
            System.err.println("Insufficient balance or invalid amount.");
        }
    }
    
    // Main method 
    public static void main(String[] args) {
        // Create two bank accounts
        BankAccount account1 = new BankAccount("Harsh Mittal", "ACC12345", 10000.00);
        BankAccount account2 = new BankAccount("Agraj Gaur", "ACC67890", 5000.00);
        
        // Display account details
        System.out.println("\nAccount 1 Details:");
        account1.displayAccountDetails();
        System.out.println("\nAccount 2 Details:");
        account2.displayAccountDetails();
        
        // Check total accounts
        BankAccount.getTotalAcc();
        
        // Deposit and withdraw operations
        System.out.println("\nPerforming transactions on Account 1:");
        account1.deposit(2000);
        account1.withdraw(1500);
        account1.displayAccountDetails();
        account2.displayAccountDetails();
        account2.deposit(1000);
        account2.withdraw(8000);
    }
}

