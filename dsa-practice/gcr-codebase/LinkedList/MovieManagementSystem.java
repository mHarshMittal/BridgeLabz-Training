class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + " | " + director + " | " + year + " | Rating: " + rating;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head;
    private MovieNode tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode node = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode node = new MovieNode(title, director, year, rating);

        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode curr = head;
        int index = 0;

        while (curr.next != null && index < position - 1) {
            curr = curr.next;
            index++;
        }

        if (curr.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        MovieNode node = new MovieNode(title, director, year, rating);
        node.next = curr.next;
        node.prev = curr;
        curr.next.prev = node;
        curr.next = node;
    }

    public void removeByTitle(String title) {
        if (head == null) return;

        MovieNode curr = head;

        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {

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

                System.out.println("Movie removed: " + title);
                return;
            }
            curr = curr.next;
        }

        System.out.println("Movie not found: " + title);
    }

    // Search by director
    public void searchByDirector(String director) {
        MovieNode curr = head;
        boolean found = false;

        while (curr != null) {
            if (curr.director.equalsIgnoreCase(director)) {
                System.out.println(curr);
                found = true;
            }
            curr = curr.next;
        }

        if (!found) System.out.println("No movies found for director: " + director);
    }

    public void searchByRating(double rating) {
        MovieNode curr = head;
        boolean found = false;

        while (curr != null) {
            if (curr.rating == rating) {
                System.out.println(curr);
                found = true;
            }
            curr = curr.next;
        }

        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    public void updateRating(String title, double newRating) {
        MovieNode curr = head;

        while (curr != null) {
            if (curr.title.equalsIgnoreCase(title)) {
                curr.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            curr = curr.next;
        }

        System.out.println("Movie not found: " + title);
    }

    // Display forward
    public void displayForward() {
        System.out.println("\nMovies (Forward):");
        MovieNode curr = head;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        System.out.println("\nMovies (Reverse):");
        MovieNode curr = tail;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        list.addAtEnd("Inception", "Nolan", 2010, 9.0);
        list.addAtBeginning("Interstellar", "Nolan", 2014, 8.8);
        list.addAtEnd("Titanic", "Cameron", 1997, 8.0);
        list.addAtPosition(1, "Avatar", "Cameron", 2009, 7.9);

        list.displayForward();
        list.displayReverse();

        System.out.println("\nSearch by Director (Nolan):");
        list.searchByDirector("Nolan");

        System.out.println("\nSearch by Rating (8.0):");
        list.searchByRating(8.0);

        list.updateRating("Titanic", 8.5);

        list.removeByTitle("Avatar");

        list.displayForward();
    }
}