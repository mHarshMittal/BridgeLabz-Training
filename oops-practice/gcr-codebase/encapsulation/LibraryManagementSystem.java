// Interface for reservation-related features
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Abstract base class
abstract class LibraryItem {

    // Encapsulated fields
    private String itemId;
    private String title;
    private String author;

    // Sensitive borrower data (encapsulated)
    private String borrowerName;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    // Controlled access to sensitive data
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    protected String getBorrowerName() {
        return borrowerName;
    }

    // Abstract method
    public abstract int getLoanDuration();
}

// Book class
class Book extends LibraryItem implements Reservable {

    private boolean available = true;

    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 21 days
    }

    @Override
    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("Book reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {

    private boolean available = true;

    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("Magazine reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {

    private boolean available = true;

    public DVD(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("DVD reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}

// Main class demonstrating polymorphism
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Polymorphism: general LibraryItem reference
        LibraryItem[] items = {
            new Book("B101", "Java Programming", "James Gosling"),
            new Magazine("M201", "Tech Monthly", "Editorial Team"),
            new DVD("D301", "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Interface-based access
            Reservable r = (Reservable) item;
            System.out.println("Available: " + r.checkAvailability());
            r.reserveItem();

            System.out.println("-----------------------------");
        }
    }
}
