/* Movie Ticket Booking App
Ask users for movie type, seat type (gold/silver), and snacks.
● Use switch and if together.
● Loop through multiple customers.
● Clean structure and helpful variable names
*/
import java.util.Scanner;

public class MovieTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int numCustomers = sc.nextInt();

        for (int i = 1; i <= numCustomers; i++) {
            System.out.println();
            System.out.println("Customer " + i + " -");

            System.out.print("Enter movie type (1-Action, 2-Comedy, 3-Drama): ");
            int movieType = sc.nextInt();

            System.out.print("Enter seat type (1-Gold, 2-Silver): ");
            int seatType = sc.nextInt();

            System.out.print("Want snacks? (1-Yes, 2-No): ");
            int snackChoice = sc.nextInt();

            int ticketPrice = 0;
            int snacksPrice = 0;
            String movieName = "";
            String seatName = "";

            // parse input with switch case statements
            switch (movieType) {
                case 1:
                    movieName = "Action";
                    ticketPrice = 300;
                    break;
                case 2:
                    movieName = "Comedy";
                    ticketPrice = 250;
                    break;
                case 3:
                    movieName = "Drama";
                    ticketPrice = 200;
                    break;
                default:
                    movieName = "Unknown";
                    ticketPrice = 200;
            }

            if (seatType == 1) {
                seatName = "Gold";
                ticketPrice += 100;
            } else {
                seatName = "Silver";
            }

            if (snackChoice == 1) {
                snacksPrice = 150;
            }

            int totalPrice = ticketPrice + snacksPrice;

            System.out.println();
            System.out.println("Booking Summary:");
            System.out.println("Movie: " + movieName);
            System.out.println("Seat: " + seatName);
            System.out.println("Snacks: " + (snackChoice == 1 ? "Yes" : "No"));
            System.out.println("Total Price: Rs." + totalPrice);
        }
        sc.close();
    }
}