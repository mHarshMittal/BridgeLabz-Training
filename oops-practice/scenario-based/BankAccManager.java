/*Methods – Bank Account Manager
1. Scenario: A banking app needs to perform operations like deposit, withdraw, and check balance for a user.
● Problem: Design a BankAccount class with:
● Fields/Properties: AccountNumber, Balance.
● Methods: Deposit(double), Withdraw(double), CheckBalance().
● Include logic to prevent overdraft. */

class BankAccount {

    int accountNumber;
    double balance;

    // Constructor
    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: " + amount);
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Check balance method
    public double checkBalance() {
        return balance;
    }

    // Main method
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(123456);

        myAccount.deposit(500);
        System.out.println("Current Balance: " + myAccount.checkBalance());

        myAccount.withdraw(200);
        System.out.println("Current Balance: " + myAccount.checkBalance());

        myAccount.withdraw(400); // overdraft prevented
        System.out.println("Current Balance: " + myAccount.checkBalance());
    }
}
