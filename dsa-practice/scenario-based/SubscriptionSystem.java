import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Custom Exception
class PaymentDeclinedException extends Exception {
    public PaymentDeclinedException(String msg) {
        super(msg);
    }
}

// Strategy Pattern
interface DiscountStrategy {
    double applyDiscount(double amount);
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount;
    }
}

class FestivalDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.8; // 20% discount
    }
}

// User class
class User {
    String name;
    LocalDate expiryDate;
    boolean active;
    double amount;

    public User(String name, LocalDate expiryDate, boolean active, double amount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.active = active;
        this.amount = amount;
    }
}

// Main System
public class SubscriptionSystem {

    static void processPayment(double amount) throws PaymentDeclinedException {
        if (amount <= 0) {
            throw new PaymentDeclinedException("Payment Declined");
        }
        System.out.println("Payment Successful: " + amount);
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Harsh", LocalDate.now().minusDays(2), true, 500));
        users.add(new User("Amit", LocalDate.now().plusDays(5), true, 500));
        users.add(new User("Riya", LocalDate.now().minusDays(1), true, 0));

        DiscountStrategy discount = new FestivalDiscount();

        // Find expired users using streams
        List<User> expiredUsers = users.stream()
                .filter(u -> u.expiryDate.isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        for (User user : expiredUsers) {
            if (user.active) {
                double finalAmount = discount.applyDiscount(user.amount);

                try {
                    processPayment(finalAmount);
                    user.expiryDate = LocalDate.now().plusDays(30);
                    System.out.println(user.name + " renewed till " + user.expiryDate);
                } catch (PaymentDeclinedException e) {
                    System.out.println(user.name + " -- " + e.getMessage());
                }
            }
        }
    }
}