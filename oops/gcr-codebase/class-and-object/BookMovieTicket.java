public class BookMovieTicket {
    String movieName;
    int seatNum;
    double price;

    //  Book a ticket
    public void bookTicket(String movieName, int seatNum, double price) {
        this.movieName = movieName;
        this.seatNum = seatNum;
        this.price = price;
    }

    // Display ticket details
    public void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNum);
        System.out.println("Ticket Price: " + price);
    }

    // Main method 
    public static void main(String[] args) {
        BookMovieTicket ticket = new BookMovieTicket();
        ticket.bookTicket("Inception", 45, 250);
        ticket.displayTicketDetails();
    }
}