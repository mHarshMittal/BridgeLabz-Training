import java.io.*;
import java.util.*;

abstract class Book {
    String title;
    abstract void setTitle(String s);

    String getTitle() {
        return title;
    }
}

class MyBook extends Book {
    void setTitle(String s) {
        title = s;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();

        MyBook book = new MyBook();
        book.setTitle(title);

        System.out.println("The title is: " + book.getTitle());

        scanner.close();
    }
}