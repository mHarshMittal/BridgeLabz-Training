interface PaymentProcessor {
    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refund processed: " + amount);
    }
}

class PaytmProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Payment done using Paytm: " + amount);
    }
}

public class PaymentGatewayApp {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaytmProcessor();
        processor.pay(500);
        processor.refund(200);
    }
}
