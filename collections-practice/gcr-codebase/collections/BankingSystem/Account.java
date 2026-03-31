public class Account {
    private String accountNumber;
    private double balance;
    private String customerName;
    
    public Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "Account{accountNumber='" + accountNumber + "', customerName='" + 
               customerName + "', balance=" + balance + "}";
    }
}
