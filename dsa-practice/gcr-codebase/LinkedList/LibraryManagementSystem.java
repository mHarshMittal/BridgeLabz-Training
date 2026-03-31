class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;

    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
    }

    @Override
    public String toString() {
        return bookId + " | " + title + " | " + author + " | " + genre +
                " | " + (available ? "Available" : "Not Available");
    }
}

class LibraryDoublyLinkedList {
    private BookNode head;
    private BookNode tail;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        BookNode node = new BookNode(title, author, genre, id, available);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, int id, boolean available) {
        BookNode node = new BookNode(title, author, genre, id, available);

        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void addAtPosition(int pos, String title, String author, String genre, int id, boolean available) {
        if (pos <= 0 || head == null) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }

        BookNode curr = head;
        int index = 0;

        while (curr.next != null && index < pos - 1) {
            curr = curr.next;
            index++;
        }

        if (curr.next == null) {
            addAtEnd(title, author, genre, id, available);
            return;
        }

        BookNode node = new BookNode(title, author, genre, id, available);
        node.next = curr.next;
        node.prev = curr;
        curr.next.prev = node;
        curr.next = node;
    }


    public void removeById(int id) {
        if (head == null) return;

        BookNode curr = head;

        while (curr != null) {
            if (curr.bookId == id) {

                if (curr == head) {
                    head = curr.next;
                    if (head != null) head.prev = null;
                }
                else if (curr == tail) {
                    tail = curr.prev;
                    if (tail != null) tail.next = null;
                }
                else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }

                System.out.println("Book removed: " + id);
                return;
            }
            curr = curr.next;
        }

        System.out.println("Book not found: " + id);
    }


    public void searchByTitle(String title) {
        BookNode curr = head;
        boolean found = false;

        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {
                System.out.println(curr);
                found = true;
            }
            curr = curr.next;
        }

        if (!found) System.out.println("No book found with title: " + title);
    }

    public void searchByAuthor(String author) {
        BookNode curr = head;
        boolean found = false;

        while (curr != null) {
            if (curr.author.equalsIgnoreCase(author)) {
                System.out.println(curr);
                found = true;
            }
            curr = curr.next;
        }

        if (!found) System.out.println("No books found by author: " + author);
    }


    public void updateAvailability(int id, boolean status) {
        BookNode curr = head;

        while (curr != null) {
            if (curr.bookId == id) {
                curr.available = status;
                System.out.println("Availability updated for book ID: " + id);
                return;
            }
            curr = curr.next;
        }

        System.out.println("Book not found: " + id);
    }


    public void displayForward() {
        System.out.println("\nBooks (Forward):");
        BookNode curr = head;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.next;
        }
    }

    public void displayReverse() {
        System.out.println("\nBooks (Reverse):");
        BookNode curr = tail;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.prev;
        }
    }


    public int countBooks() {
        int count = 0;
        BookNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtEnd("1984", "George Orwell", "Dystopian", 101, true);
        library.addAtBeginning("The Hobbit", "Tolkien", "Fantasy", 102, true);
        library.addAtEnd("Dune", "Frank Herbert", "Sci-Fi", 103, false);
        library.addAtPosition(1, "The Alchemist", "Paulo Coelho", "Fiction", 104, true);

        library.displayForward();
        library.displayReverse();

        System.out.println("\nSearch by Title:");
        library.searchByTitle("Dune");

        System.out.println("\nSearch by Author:");
        library.searchByAuthor("Tolkien");

        library.updateAvailability(103, true);

        System.out.println("\nAfter Update:");
        library.displayForward();

        library.removeById(104);

        System.out.println("\nAfter Deletion:");
        library.displayForward();

        System.out.println("\nTotal Books in Library: " + library.countBooks());
    }
}