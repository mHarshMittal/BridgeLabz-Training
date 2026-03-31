/* E-Commerce Platform
Description: Develop a simplified e-commerce platform:
Create an abstract class Product with fields like productId, name, and price, and an abstract method calculateDiscount().
Extend it into concrete classes: Electronics, Clothing, and Groceries.
Implement an interface Taxable with methods calculateTax() and getTaxDetails() for applicable product categories.
Use encapsulation to protect product details, allowing updates only through setter methods.
Showcase polymorphism by creating a method that calculates and prints the final price (price + tax - discount) for a list of Product.
 */


interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

// Abstract Product class
abstract class Product {

    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation - getters and setters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public abstract double calculateDiscount();

    // Display basic details
    public void displayProduct() {
        System.out.println("ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: " + price);
    }
}

class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    // Lets Assume 10% discount or we can take this as user input
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    // 18% tax (can be taken from user also)
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "GST 18% applied";
    }
}

// Clothing product
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    // 20% discount
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    // 5% tax
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "GST 5% applied";
    }
}

// Groceries product
class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    // 5% discount
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

// Main class
public class ECommercePlatform {

    // Polymorphism method
    public static void printFinalPrice(Product[] products) {

        for (Product p : products) {

            double tax = 0;

            // Check if product is taxable
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
            }

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            p.displayProduct();

            if (p instanceof Taxable) {
                System.out.println(((Taxable) p).getTaxDetails());
            } else {
                System.out.println("No tax applied");
            }

            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {

        Product p1 = new Electronics(101, "Laptop", 60000);
        Product p2 = new Clothing(102, "T-Shirt", 1200);
        Product p3 = new Groceries(103, "Rice", 800);

        Product[] products = { p1, p2, p3 };

        printFinalPrice(products);
    }
}
