import java.util.ArrayList;
import java.util.List;

// custom exception
class BookNotAvailableException extends Exception {
    BookNotAvailableException(String m) {
        super(m);
    }
}

// book class
class Book {
    String title;
    String author;
    boolean available;

    Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }
}

public class LibrarySystem {

    static List<Book> list = new ArrayList<>();

    // load books from array
    static void loadBooks() {
        Book[] arr = {
            new Book("Java Basics", "James", true),
            new Book("Data Structures", "Mark", true)
        };

        for (Book b : arr) {
            list.add(b);
        }
    }

    // search by partial title
    static void search(String key) {
        for (Book b : list) {
            if (b.title.toLowerCase().contains(key.toLowerCase())) {
                System.out.println(b.title + " - " + b.author);
            }
        }
    }

    // checkout book
    static void checkout(String t)
            throws BookNotAvailableException {

        for (Book b : list) {
            if (b.title.equals(t)) {
                if (!b.available) {
                    throw new BookNotAvailableException("Book not available");
                }
                b.available = false;
                System.out.println("Book checked out");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void main(String[] args) {
        loadBooks();
        search("Java");

        try {
            checkout("Java Basics");
            checkout("Java Basics");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
