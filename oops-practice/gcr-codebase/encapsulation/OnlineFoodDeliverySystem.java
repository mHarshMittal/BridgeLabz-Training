/* Online Food Delivery System
Description: Create an online food delivery system:
Define an abstract class FoodItem with fields like itemname, price, and quantity.
Add abstract methods calculateTotalPrice() and concrete methods like getItemDetails().
Extend it into classes VegItem and NonVegItem, overriding calculateTotalPrice() to include additional charges 
(e.g., for non-veg items).
Use an interface Discountable with methods applyDiscount() and getDiscountDetails().
Demonstrate encapsulation to restrict modifications to order details and use polymorphism to handle different 
types of food items in a single order-processing method.
*/


interface Discountable {
    double getDiscountRate();
    String getDiscountDetails();
}

abstract class FoodItem implements Discountable {

    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    protected double getBasePrice() {
        return price * quantity;
    }

    public String getItemDetails() {
        return itemName + " | Price: " + price + " | Qty: " + quantity;
    }

    public final double calculateTotalPrice() {
        double base = getBasePrice();
        double extra = getExtraCharge();
        double discount = base * getDiscountRate();
        return (base + extra) - discount;
    }
    protected abstract double getExtraCharge();
}
class VegItem extends FoodItem {

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    protected double getExtraCharge() {
        return 0;
    }

    public double getDiscountRate() {
        return 0.10;
    }

    public String getDiscountDetails() {
        return "Veg Discount: 10%";
    }
}

class NonVegItem extends FoodItem {

    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    protected double getExtraCharge() {
        return 50;
    }

    public double getDiscountRate() {
        return 0.05;
    }

    public String getDiscountDetails() {
        return "Non-Veg Discount: 5% + Extra Charge: 50";
    }
}

class OrderProcessor {

    public static void process(FoodItem item) {
        System.out.println(item.getItemDetails());
        System.out.println("Total Amount: " + item.calculateTotalPrice());
        System.out.println(item.getDiscountDetails());
        System.out.println("---------------------------");
    }
}

public class OnlineFoodDeliverySystem {

    public static void main(String[] args) {

        FoodItem veg = new VegItem("Veg Sandwich", 100, 2);
        FoodItem nonVeg = new NonVegItem("Chicken Burger", 200, 1);

        OrderProcessor.process(veg);
        OrderProcessor.process(nonVeg);
    }
}
