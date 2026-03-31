
public class Book {
    // Static variable 
    private static String libName = "Central Library";
    
    // Final variable to ensure ISBN cannot be changed once assigned
    private final String isbn;
    private String title;
    private String author;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn; // Final variable assigned only once
    }
    
    // Static method to display library name
    public static void displayLibName() {
        System.out.println("Library Name: " + libName);
    }
    
    // Method to display book details
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid book instance.");
        }
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create a book
        Book book1 = new Book("Learn Java", "Harsh Mittal", "978-991");
        
        // Display library name
        displayLibName();
        
        // Display book details
        book1.displayBookDetails();
    }
}

