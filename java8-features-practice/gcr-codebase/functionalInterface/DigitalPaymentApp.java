interface PaymentMethod {
    void pay(double amount);
}

class UPI implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid via UPI: " + amount);
    }
}

class CreditCard implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid via Credit Card: " + amount);
    }
}

class Wallet implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid via Wallet: " + amount);
    }
}

public class DigitalPaymentApp {
    public static void main(String[] args) {
        PaymentMethod payment = new UPI();
        payment.pay(1000);

        payment = new CreditCard();
        payment.pay(2000);

        payment = new Wallet();
        payment.pay(500);
    }
}
