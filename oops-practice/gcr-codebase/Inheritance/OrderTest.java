/*Multilevel Inheritance
Sample Problem 1: Online Retail Order Management
Description: Create a multilevel hierarchy to manage orders, where Order is the base class, ShippedOrder is a subclass, and DeliveredOrder extends ShippedOrder.
Tasks:
Define a base class Order with common attributes like orderId and orderDate.
Create a subclass ShippedOrder with additional attributes like trackingNumber.
Create another subclass DeliveredOrder extending ShippedOrder, adding a deliveryDate attribute.
Implement a method getOrderStatus() to return the current order status based on the class level.
Goal: Explore multilevel inheritance, showing how attributes and methods can be added across a chain of classes.
 */

class Order {
    
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

// First level subclass
class ShippedOrder extends Order {
    String trackNo;

    ShippedOrder(int orderId, String orderDate, String trackNo) {
        super(orderId, orderDate);
        this.trackNo = trackNo;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped (Tracking No: " + trackNo + ")";
    }
}

// Second level subclass
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackNo, String deliveryDate) {
        super(orderId, orderDate, trackNo);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

// Main class
public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order(101, "10-Jan");
        Order o2 = new ShippedOrder(102, "11-Jan", "TRK123");
        Order o3 = new DeliveredOrder(103, "12-Jan", "TRK456", "15-Jan");

        System.out.println(o1.getOrderStatus());
        System.out.println(o2.getOrderStatus());
        System.out.println(o3.getOrderStatus());
    }
}
