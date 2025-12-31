public class InventoryTracker {
    int itemCode;
    String itemName;
    double price;

    // Constructor to initialize item 
    public InventoryTracker(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item and calcu;ate the  total cost
    public void displayDetails(int quantity) {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Total Cost for " + quantity + " items: " + (price * quantity));
    }

    // Main method
    public static void main(String[] args) {
        InventoryTracker item = new InventoryTracker(201, "Pen", 10);
        item.displayDetails(3);
    }
}