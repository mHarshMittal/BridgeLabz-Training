import java.util.*;

// Simple e-commerce flow using core Java OOP.
public class ECommerceOrderSystem {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.addProduct(new Product("P1", "Laptop", 75000));
        catalog.addProduct(new Product("P2", "Mouse", 1200));

        Customer customer = new Customer("C1", "Priya");
        OrderService service = new OrderService(catalog);

        Order order = service.placeOrder(customer, List.of("P1", "P2"), new CardPayment());
        service.pay(order, 76200);
        service.cancel(order.getId());
    }
}

class Product {
    private final String id;
    private final String name;
    private final double price;

    Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private final String id;
    private final String name;

    Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Order {
    enum Status {CREATED, PAID, CANCELLED}

    private final String id;
    private final Customer customer;
    private final List<Product> items;
    private final Payment payment;
    private Status status = Status.CREATED;

    Order(String id, Customer customer, List<Product> items, Payment payment) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.payment = payment;
    }

    public String getId() {
        return id;
    }

    public double totalAmount() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public Payment getPayment() {
        return payment;
    }

    public Status getStatus() {
        return status;
    }

    public void markPaid() {
        status = Status.PAID;
    }

    public void cancel() {
        status = Status.CANCELLED;
    }
}

interface Payment {
    void pay(double amount);
}

class CardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Card charged: " + amount);
    }
}

class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("UPI debited: " + amount);
    }
}

class WalletPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Wallet used: " + amount);
    }
}

class PaymentFailedException extends RuntimeException {
    PaymentFailedException(String message) {
        super(message);
    }
}

class Catalog {
    private final Map<String, Product> products = new HashMap<>();

    void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    Product getById(String id) {
        Product product = products.get(id);
        if (product == null) {
            throw new IllegalArgumentException("Unknown product " + id);
        }
        return product;
    }
}

class OrderService {
    private final Catalog catalog;
    private final Map<String, Order> orders = new HashMap<>();

    OrderService(Catalog catalog) {
        this.catalog = catalog;
    }

    Order placeOrder(Customer customer, List<String> productIds, Payment payment) {
        List<Product> items = new ArrayList<>();
        for (String id : productIds) {
            items.add(catalog.getById(id));
        }
        Order order = new Order(UUID.randomUUID().toString(), customer, items, payment);
        orders.put(order.getId(), order);
        System.out.println("Order created for " + customer.getName());
        return order;
    }

    void pay(Order order, double amount) {
        if (order.getStatus() != Order.Status.CREATED) {
            throw new PaymentFailedException("Order not payable");
        }
        order.getPayment().pay(amount);
        if (amount < order.totalAmount()) {
            throw new PaymentFailedException("Underpayment detected");
        }
        order.markPaid();
        System.out.println("Order paid: " + order.getId());
    }

    void cancel(String orderId) {
        Order order = getOrder(orderId);
        order.cancel();
        System.out.println("Order cancelled: " + orderId);
    }

    private Order getOrder(String id) {
        Order order = orders.get(id);
        if (order == null) {
            throw new IllegalArgumentException("Unknown order " + id);
        }
        return order;
    }
}

