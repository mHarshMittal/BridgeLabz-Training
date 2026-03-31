package library;

import java.util.*;

public class BookShelf {

    private Map<String, LinkedList<Book>> catalog = new HashMap<>();

    // Add / return book
    public void addBook(String genre, Book book) {
        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
    }

    // Borrow book
    public void removeBook(String genre, String title) {
        LinkedList<Book> books = catalog.get(genre);
        if (books == null) return;

        books.removeIf(b -> b.title.equals(title));

        if (books.isEmpty()) {
            catalog.remove(genre);
        }
    }

    // Print catalog
    public void printCatalog() {
        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book b : catalog.get(genre)) {
                System.out.println("  " + b);
            }
        }
    }
}

