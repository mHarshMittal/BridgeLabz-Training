
/* Library Management System – Book Search and Checkout
Scenario: You’re designing a system for a small library to manage books and track checkouts.
Problem Requirements:
● Store book details (title, author, status) in a Array.
● Allow searching by partial title using String operations.
● Store book data in an Array.
● Use methods for searching, displaying, and updating book status (checked out or
available). */


import java.util.Scanner;
public class LibraryApp {
    // book data - title, author, status
    static String[][] bk = {
        {"Java Basics", "Harsh", "available"},
        {"Python Guide", "Agraj", "available"},
        {"DSA", "Rajat", "checked out"},
        {"Java Advanced", "Sajal", "available"}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // show all books
        show();
        System.out.print("\nEnter book title to search: ");
        String key = sc.nextLine();
        int pos = find(key);
        // if book found
        if (pos != -1) {
            System.out.println("Book: " + bk[pos][0]);
            System.out.println("Status: " + bk[pos][2]);

            // update status
            if (bk[pos][2].equals("available")) {
                bk[pos][2] = "checked out";
                System.out.println("Book checked out successfully");
            } else {
                System.out.println("Book already checked out");
            }
        } 
        // if book not found
        else {
            System.out.println("Book not found");
        }

        sc.close();
    }

    // method to display books
    static void show() {
        System.out.println("Library Books:");
        for (int i = 0; i < bk.length; i++) {
            System.out.println(bk[i][0] + " | " + bk[i][1] + " | " + bk[i][2]);
        }
    }

    // method to search book by partial title
    static int find(String key) {
        for (int i = 0; i < bk.length; i++) {
            if (bk[i][0].toLowerCase().contains(key.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}
