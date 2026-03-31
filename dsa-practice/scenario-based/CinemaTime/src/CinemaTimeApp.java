public class CinemaTimeApp {

    public static void main(String[] args) {

        MovieManager manager = new MovieManager();

        try {
            manager.addMovie("Inception", "18:30");
            manager.addMovie("Interstellar", "21:00");
            manager.addMovie("Avatar", "25:99");
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        manager.displayAllMovies();

        System.out.println();
        manager.searchMovie("inter");

        System.out.println();
        manager.printReport();
    }
}
