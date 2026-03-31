import java.util.*;
//import java.util.stream.*;
class Movie {
    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }
}

public class TopMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("A", 8.5, 2024),
            new Movie("B", 9.0, 2023),
            new Movie("C", 7.8, 2025),
            new Movie("D", 8.9, 2024),
            new Movie("E", 9.2, 2025),
            new Movie("F", 8.0, 2023)
        );

        movies.stream()
              .sorted(Comparator.comparing(Movie::getRating).reversed()
              .thenComparing(Movie::getYear).reversed())
              .limit(5)
              .forEach(m -> System.out.println(m.name + " " + m.rating));
    }
}
