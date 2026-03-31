import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        System.out.println("Enter flight details");
        String input = sc.nextLine();

        try {
            String[] data = input.split(":");

            String flightNumber = data[0];
            String flightName = data[1];
            int passengerCount = Integer.parseInt(data[2]);
            double fuel = Double.parseDouble(data[3]);

            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount, flightName);

            double requiredFuel =
                util.calculateFuelToFillTank(flightName, fuel);

            System.out.println(
                "Fuel required to fill the tank: " +
                requiredFuel + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        }
    }
}