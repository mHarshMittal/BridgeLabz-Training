package java8_features_practice.gcr_codebase.lambda_expressions_and_method_references;

import java.util.ArrayList;
import java.util.List;

class Product {
	private String name;
	private double price;
	private double rating;
	private double discount;

	public Product(String name, double price, double rating, double discount) {
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	public String toString() {
		return name + " | Price: " + price + " | Rating: " + rating + " | Discount: " + discount + "%\n";
	}

}

public class CustomSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Laptop", 76000, 4.5, 10));
		products.add(new Product("Phone", 13000, 4.8, 15));
		products.add(new Product("Headphones", 800, 4.2, 25));
		products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		System.out.println(products + "\n");
		products.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
		System.out.println(products + "\n");
		products.sort((p1, p2) -> Double.compare(p2.getDiscount(), p2.getDiscount()));
		System.out.println(products + "\n");
	}

}
