/* Banking System
Description: Create a banking system with different account types:
Define an abstract class BankAccount with fields like accountNumber, holderName, and balance.
Add methods like deposit(double amount) and withdraw(double amount) (concrete) and calculateInterest() (abstract).
Implement subclasses SavingsAccount and CurrentAccount with unique interest calculations.
Create an interface Loanable with methods applyForLoan() and calculateLoanEligibility().
Use encapsulation to secure account details and restrict unauthorized access.
Demonstrate polymorphism by processing different account types and calculating interest dynamically.
 */


interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}
abstract class BankAccount {
    private String accountNumber;   
    private String holderName;    
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient balance");
        }
    }

    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Abstract method
    abstract double calculateInterest();
}

// Savings Account class
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Savings account interest
    @Override
    double calculateInterest() {
        return balance * 0.05; // 5 % interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings account loan applied for: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5; // eligible up to 5 times balance
    }
}

// Current Account class
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Current account interest
    @Override
    double calculateInterest() {
        return balance * 0.02; // 2% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current account loan applied for: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 3; // eligible up to 3 times balance
    }
}

// Main class polymorphism
public class BankingSystem {
    public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount("SA101", "Rahul", 50000);
        BankAccount acc2 = new CurrentAccount("CA201", "Neha", 80000);

        BankAccount[] accounts = {acc1, acc2};

        for (BankAccount acc : accounts) {
            acc.deposit(5000);
            acc.withdraw(3000);

            
            System.out.println("Interest: " + acc.calculateInterest());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("-----------------------");
        }
    }
}
