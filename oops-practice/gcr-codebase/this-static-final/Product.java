
public class Product {
    private static double discount = 10.0;
    
    private final String productID;
    private String productName;
    private double price;
    private int quantity;
    
    public Product(String productName, String productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID; // Final variable assigned only once
        this.price = price;
        this.quantity = quantity;
    }
    
    // Static method to update discount percentage
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    
    // Method to display product details
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: Rs/- " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price after Discount: Rs/- " + discountedPrice);
        } else {
            System.out.println("Invalid product instance.");
        }
    }
    
    // Getters and setters
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductID() {
        return productID;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create two products
        Product prod1 = new Product("Laptop", "P001", 1200.0, 5);
        Product prod2 = new Product("Smartphone", "P002", 800.0, 10);
        
        // Display product details
        prod1.displayProductDetails();
        System.out.println();
        prod2.displayProductDetails();
    }
}

