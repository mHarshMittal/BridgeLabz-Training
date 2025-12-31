
class Book {
	private String title;
	private String author;
	private double price;

	Book() {
		this.title = "Unknown";
		this.author = "Unknown";
		this.price = 0.0;
	}

	Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	void display() {
		System.out.println("Title: " + title + ", Author: " + author + ", Price: Rs" + price);
	}
}

public class DisplayBookDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book();
		Book b2 = new Book("Lord Of The Rings", "Tolkien", 999.99);
		b.display();
		b2.display();
	}

}
