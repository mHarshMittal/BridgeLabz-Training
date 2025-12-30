import java.util.ArrayList;

public class ShoppingCart {
    // Inner class to represent an item in the cart
    static class CartItem {
        String itemName;
        double price;
        int quantity;

        CartItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }
    }

    // List to store the items in cart 
    ArrayList<CartItem> cart = new ArrayList<>();

    // Method 
    public void addItem(String itemName, double price, int quantity) {
        cart.add(new CartItem(itemName, price, quantity));
    }

    // Method to remove an item from the cart
    public void removeItem(String itemName) {
        cart.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
    }

    // Method to display total cost of all items in the cart
    public void displayTotalCost() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.price * item.quantity;
        }
        System.out.println("Total Cost: " + total);
    }

    // Main method 
    public static void main(String[] args) {
        ShoppingCart cartSim = new ShoppingCart();
        cartSim.addItem("Book", 120, 2);
        cartSim.addItem("Pen", 10, 5);
        cartSim.removeItem("Pen");
        cartSim.displayTotalCost();
    }
}