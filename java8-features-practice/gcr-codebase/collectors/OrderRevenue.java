import java.util.*;
import java.util.stream.Collectors;

class Order {
    private String customer;
    private double amount;

    public Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
}

public class OrderRevenue {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Rahul", 2000),
                new Order("Neha", 1500),
                new Order("Rahul", 3000),
                new Order("Neha", 1000),
                new Order("Amit", 2500)
        );

        Map<String, Double> revenueByCustomer =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        System.out.println(revenueByCustomer);
    }
}
