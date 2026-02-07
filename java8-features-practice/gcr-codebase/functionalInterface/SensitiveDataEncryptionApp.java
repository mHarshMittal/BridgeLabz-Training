interface SensitiveData {
}

class BankAccountDetails implements SensitiveData {
    int accountNumber = 123456;
    double balance = 50000;
}

public class SensitiveDataEncryptionApp {
    public static void main(String[] args) {
        BankAccountDetails account = new BankAccountDetails();
        System.out.println("Class marked as SensitiveData for encryption");
    }
}
