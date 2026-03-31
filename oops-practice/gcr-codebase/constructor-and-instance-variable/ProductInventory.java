
class Product {
	private String productName;
	private double price;
	private static int totalProducts = 0;

	Product() {
		this("Unknown", 0.0);
	}

	Product(String productName, double price) {
		this.productName = productName;
		this.price = price;
		totalProducts++;
	}

	void displayProductDetails() {
		System.out.println(productName + " " + price);
	}

	void displayTotalProducts() {
		System.out.println("Total Number of Products: " + totalProducts);
	}
}

public class ProductInventory {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product("Dove Soap", 150);
		p1.displayProductDetails();
		p2.displayProductDetails();
		p1.displayTotalProducts();
	}

}
