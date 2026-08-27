import java.util.*;

class Fruit {
    String name;
    double price;
    double discount;

    Fruit(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
}

class Node {
    String fruitName;
    int quantity;

    Node(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }
}

public class FruitBill {

    public static void generateBill(List<Fruit> fruits, List<Node> nodes) {

        // Store fruit details using fruit name
        Map<String, Fruit> fruitMap = new HashMap<>();

        for (Fruit fruit : fruits) {
            fruitMap.put(fruit.name, fruit);
        }

        // Combine quantities of same fruit
        Map<String, Integer> quantityMap = new TreeMap<>();

        for (Node node : nodes) {
            quantityMap.put(
                node.fruitName,
                quantityMap.getOrDefault(node.fruitName, 0) + node.quantity
            );
        }

        // TreeMap automatically gives alphabetical order
        for (String fruitName : quantityMap.keySet()) {

            Fruit fruit = fruitMap.get(fruitName);
            int quantity = quantityMap.get(fruitName);

            double finalPrice = quantity * fruit.price
                    * (1 - fruit.discount / 100);

            System.out.printf(
                "%s %d %.2f%n",
                fruitName,
                quantity,
                finalPrice
            );
        }
    }

    public static void main(String[] args) {

        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("Apple", 100, 10));
        fruits.add(new Fruit("Banana", 50, 5));
        fruits.add(new Fruit("Mango", 80, 20));

        List<Node> purchases = new ArrayList<>();

        purchases.add(new Node("Mango", 2));
        purchases.add(new Node("Apple", 3));
        purchases.add(new Node("Mango", 1));
        purchases.add(new Node("Banana", 4));
        purchases.add(new Node("Apple", 2));

        generateBill(fruits, purchases);
    }
}