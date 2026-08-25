import java.util.ArrayList;
import java.util.List;

class Movie {

    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class MovieLibrary {

    private List<Movie> movies = new ArrayList<>();

    // Add movie
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Remove movie
    public void removeMovie(String movieName) {

        for (int i = 0; i < movies.size(); i++) {

            if (movies.get(i).getName().equals(movieName)) {
                movies.remove(i);
                break;
            }
        }
    }

    // Get all movies
    public List<Movie> getAllMovie() {
        return movies;
    }
}

public class MovieLibraryManagementSystem {

    public static void main(String[] args) {

        MovieLibrary library = new MovieLibrary();

        library.addMovie(new Movie("Inception"));
        library.addMovie(new Movie("Avatar"));
        library.addMovie(new Movie("Titanic"));

        System.out.println("All Movies:");
        System.out.println(library.getAllMovie());

        library.removeMovie("Avatar");

        System.out.println("After Removing Avatar:");
        System.out.println(library.getAllMovie());
    }
}