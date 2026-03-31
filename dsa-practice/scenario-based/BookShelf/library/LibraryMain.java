package library;

public class LibraryMain {
    public static void main(String[] args) {

        BookShelf shelf = new BookShelf();

        shelf.addBook("Fiction", new Book("1984", "George Orwell"));
        shelf.addBook("Fiction", new Book("Dune", "Frank Herbert"));
        shelf.addBook("Science", new Book("Cosmos", "Carl Sagan"));

        shelf.printCatalog();

        System.out.println("\nBorrowing Dune...\n");
        shelf.removeBook("Fiction", "Dune");

        shelf.printCatalog();
    }
}

