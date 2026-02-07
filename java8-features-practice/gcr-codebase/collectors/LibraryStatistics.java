import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String genre;
    private int pages;

    public Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }
}

public class LibraryStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Fiction", 300),
                new Book("Fiction", 450),
                new Book("Science", 500),
                new Book("Science", 350),
                new Book("History", 400)
        );

        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));

        System.out.println(statsByGenre);
    }
}
