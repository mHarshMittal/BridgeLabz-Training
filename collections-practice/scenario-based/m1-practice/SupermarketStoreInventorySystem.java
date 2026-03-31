
import java.util.*;

abstract class Product {
	String name;
	double price;
	int quantity;

	Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	abstract void displayDetails();

	double getTotalValue() {
		return price * quantity;
	}
}

class Electronics extends Product {
	int warranty;

	Electronics(String name, double price, int quantity, int warranty) {
		super(name, price, quantity);
		this.warranty = warranty;
	}

	@Override
	void displayDetails() {
		System.out.println(
				name + " - Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty + " months");
	}
}

class Clothing extends Product {
	String size;

	Clothing(String name, double price, int quantity, String size) {
		super(name, price, quantity);
		this.size = size;
	}

	@Override
	void displayDetails() {
		System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Size: " + size);
	}
}

public class SupermarketStoreInventorySystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		List<Product> inventory = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			String line = sc.nextLine().trim();
			String[] parts = line.split(",\\s*");
			String type = parts[0];
			String name = parts[1];
			double price = Double.parseDouble(parts[2]);
			int quantity = Integer.parseInt(parts[3]);

			Product product = null;
			if (type.equals("Electronics")) {
				int warranty = Integer.parseInt(parts[4]);
				product = new Electronics(name, price, quantity, warranty);
			} else if (type.equals("Clothing")) {
				String size = parts[4];
				product = new Clothing(name, price, quantity, size);
			}

			if (product != null) {
				inventory.add(product);
				System.out.println("Product added to inventory: " + name);
			}
		}

		System.out.println("Inventory:");
		for (Product p : inventory) {
			p.displayDetails();
		}

		double totalValue = inventory.stream().mapToDouble(Product::getTotalValue).sum();
		System.out.printf("Total value of the inventory: %.2f\n", totalValue);

		sc.close();
	}
}