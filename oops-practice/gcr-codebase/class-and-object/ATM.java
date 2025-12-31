public class ATM {
    String accHolder;
    String accNumber;
    double bal;

    // Constructor to initialize account details
    public ATM(String accHolder, String accNumber, double bal) {
        this.accHolder = accHolder;
        this.accNumber = accNumber;
        this.bal = bal;
    }

    // Method to deposit money in account
    public void deposit(double amount) {
        bal += amount;
    }

    // Withdraw money from account if sufficient bal exist in account 
    public void withdraw(double amount) {
        if (amount <= bal) {
            bal -= amount;
        } else {
            System.out.println("Insufficient bal.");
        }
    }

    // Display current bal in account
    public void displayBal() {
        System.out.println("Account Holder: " + accHolder);
        System.out.println("Account Number: " + accNumber);
        System.out.println("Current Bal: " + bal);
    }

    // Main method 
    public static void main(String[] args) {
        ATM account = new ATM("Bob", "1234567890", 10000);
        account.deposit(5000);
        account.withdraw(3000);
        account.displayBal();
    }
}