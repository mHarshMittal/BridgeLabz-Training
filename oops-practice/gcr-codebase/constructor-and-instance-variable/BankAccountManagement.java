class BankAccount{
	public String accountNumber;
	protected String accountHolder;
	private double balance;
	BankAccount(String accountNumber, String accountHolder, double balance){
		this.accountNumber = accountHolder;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
class SavingsAccount extends BankAccount{
	public SavingsAccount(String accountNumber, String accountHolder, double balance) {
		// TODO Auto-generated constructor stub
		super(accountNumber, accountHolder, balance);
	}
	
	public void display() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Holder Name: " + accountHolder);
		System.out.println("Balance: " + getBalance());
	}
}
public class BankAccountManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount s = new SavingsAccount("231312314", "Govind", 10000);
		s.display();
		s.setBalance(1000000);
		s.display();
	}

}
