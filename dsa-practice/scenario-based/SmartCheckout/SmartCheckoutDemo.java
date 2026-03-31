import java.util.Arrays;
import java.util.List;

public class SmartCheckoutDemo {
    public static void main(String[] args) {
        ItemCatalog catalog = new ItemCatalog();
        catalog.upsertItem("apple", 3, 10);
        catalog.upsertItem("milk", 25, 5);
        catalog.upsertItem("bread", 20, 2);

        CheckoutQueue queue = new CheckoutQueue();
        queue.addCustomer(new Customer("Harsh", List.of("apple", "milk")));
        queue.addCustomer(new Customer("Agraj", List.of("bread", "bread")));
        queue.addCustomer(new Customer("Mukul", Arrays.asList("apple", "bread", "milk")));

        while (queue.size() > 0) {
            Customer current = queue.pollCustomer();
            if (current == null) {
                break;
            }
            int bill = 0;
            boolean canCheckout = true;
            for (String item : current.getItems()) {
                Integer price = catalog.getPrice(item);
                if (price == null) {
                    System.out.println(current.getName() + ": item not found -> " + item);
                    canCheckout = false;
                    break;
                }
                if (!catalog.purchase(item, 1)) {
                    System.out.println(current.getName() + ": out of stock -> " + item);
                    canCheckout = false;
                    break;
                }
                bill += price;
            }
            if (canCheckout) {
                System.out.println(current.getName() + " billed: " + bill);
            }
        }
    }
}
