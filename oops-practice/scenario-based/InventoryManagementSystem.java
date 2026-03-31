import java.util.*;

// Inventory tracking with low-stock alerts.
public class InventoryManagementSystem {
    public static void main(String[] args) {
        AlertService alertService = message -> System.out.println("ALERT: " + message);
        Inventory inventory = new Inventory(alertService, 2);

        inventory.addProduct(new InvProduct("P1", "USB Drive"), 5);
        inventory.updateStock("P1", -4);
        System.out.println("Remaining stock: " + inventory.getStock("P1"));
    }
}

class InvProduct {
    private final String id;
    private final String name;

    InvProduct(String id, String name) {
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

interface AlertService {
    void notifyLowStock(String message);
}

class OutOfStockException extends RuntimeException {
    OutOfStockException(String message) {
        super(message);
    }
}

class Inventory {
    private final Map<String, Integer> stock = new HashMap<>();
    private final Map<String, InvProduct> products = new HashMap<>();
    private final AlertService alertService;
    private final int threshold;

    Inventory(AlertService alertService, int threshold) {
        this.alertService = alertService;
        this.threshold = threshold;
    }

    void addProduct(InvProduct product, int quantity) {
        products.put(product.getId(), product);
        stock.put(product.getId(), quantity);
    }

    void updateStock(String productId, int delta) {
        int newQty = stock.getOrDefault(productId, 0) + delta;
        if (newQty < 0) {
            throw new OutOfStockException("Cannot reduce below zero for " + productId);
        }
        stock.put(productId, newQty);
        if (newQty <= threshold) {
            alertService.notifyLowStock("Low stock for " + productId + ": " + newQty);
        }
    }

    int getStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }
}

