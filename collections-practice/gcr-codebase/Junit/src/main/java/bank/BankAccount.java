package bank;

public class BankAccount {

    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Adds money to the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraws money; returns true if successful, false if insufficient funds
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false; // insufficient funds
    }

    // Returns current balance
    public double getBalance() {
        return balance;
    }
}
