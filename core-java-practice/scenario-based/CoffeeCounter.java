
import java.util.Scanner;

public class CoffeeCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = "";

        while (!order.equalsIgnoreCase("exit")) {
            System.out.println("Enter coffee type (espresso, latte, cappuccino) or 'exit':");
            order = sc.nextLine();

            if (order.equalsIgnoreCase("exit")) {
                break; // Exit the loop if the user types "exit"
            }

            System.out.println("Enter quantity:");
            int qty = sc.nextInt();
            sc.nextLine(); //newline

            double price = 0.0;

            // Determine the price based on the coffee type
            switch (order.toLowerCase()) {
                case "espresso":
                    price = 2.5;
                    break;
                case "latte":
                    price = 3.5;
                    break;
                case "cappuccino":
                    price = 4.0;
                    break;
                default:
                    System.out.println("Invalid coffee type.");
                    continue; 
            }

            // Calculate the total bill before GST
            double bill = price * qty;

            // Calculate GST (assuming 5% GST)
            double gst = 0.05 * bill;

            // Calculate the total bill after GST
            double total = bill + gst;

            System.out.println("Bill before GST: $" + bill);
            System.out.println("GST: $" + gst);
            System.out.println("Total bill: $" + total);
        }

        System.out.println("Exiting Coffee Counter.");
        sc.close();
    }
}
