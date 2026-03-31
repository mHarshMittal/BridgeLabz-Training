import java.util.Map;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.addProduct(new Product("Laptop", 999.99));
        cart.addProduct(new Product("Mouse", 29.99));
        cart.addProduct(new Product("Keyboard", 79.99));
        
        System.out.println("=== Product Prices (HashMap) ===");
        Map<String, Double> prices = cart.getPrices();
        System.out.println(prices);
        
        System.out.println("\n=== Items by Order (LinkedHashMap) ===");
        Map<String, Product> orderItems = cart.getItemsByOrder();
        for (Product product : orderItems.values()) {
            System.out.println(product);
        }
        
        System.out.println("\n=== Items Sorted by Price (TreeMap) ===");
        Map<Double, String> sortedItems = cart.getItemsSortedByPrice();
        for (Map.Entry<Double, String> entry : sortedItems.entrySet()) {
            System.out.println(entry.getValue() + " - $" + entry.getKey());
        }
    }
}
