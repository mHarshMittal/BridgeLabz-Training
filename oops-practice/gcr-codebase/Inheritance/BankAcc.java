// Base class
class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accNo, double bal) {
        accountNumber = accNo;
        balance = bal;
    }
}

// Savings account
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accNo, double bal, double rate) {
        super(accNo, bal);
        interestRate = rate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

// Checking account
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(int accNo, double bal, double limit) {
        super(accNo, bal);
        withdrawalLimit = limit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}

// Fixed deposit account
class FixedDepositAccount extends BankAccount {
    int lockPeriod; // in years

    FixedDepositAccount(int accNo, double bal, int period) {
        super(accNo, bal);
        lockPeriod = period;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}

// Test class
public class BankAcc{
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(101, 50000, 4.5);
        CheckingAccount ca = new CheckingAccount(102, 20000, 10000);
        FixedDepositAccount fd = new FixedDepositAccount(103, 100000, 5);

        sa.displayAccountType();
        ca.displayAccountType();
        fd.displayAccountType();
        
    }
}
