import java.util.Scanner;

class InvalidFlightException extends Exception {

    public InvalidFlightException(String message) {
        super(message);
    }
}

class FlightUtil {

    public boolean validateFlightNumber(String flightNumber)
            throws InvalidFlightException {

        if (!flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException(
                    "The flight number " + flightNumber + " is invalid"
            );
        }

        return true;
    }

    public boolean validateFlightName(String flightName)
            throws InvalidFlightException {

        if (!(flightName.equals("SpiceJet")
                || flightName.equals("Vistara")
                || flightName.equals("IndiGo")
                || flightName.equals("Air Arabia"))) {

            throw new InvalidFlightException(
                    "The flight name " + flightName + " is invalid"
            );
        }

        return true;
    }

    public boolean validatePassengerCount(int passengerCount,
                                          String flightName)
            throws InvalidFlightException {

        int maxCapacity = 0;

        switch (flightName) {
            case "SpiceJet":
                maxCapacity = 396;
                break;

            case "Vistara":
                maxCapacity = 615;
                break;

            case "IndiGo":
                maxCapacity = 230;
                break;

            case "Air Arabia":
                maxCapacity = 130;
                break;
        }

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount
                            + " is invalid for " + flightName
            );
        }

        return true;
    }

    public double calculateFuelToFillTank(String flightName,
                                          double currentFuelLevel)
            throws InvalidFlightException {

        double maxFuelCapacity = 0;

        switch (flightName) {
            case "SpiceJet":
                maxFuelCapacity = 200000;
                break;

            case "Vistara":
                maxFuelCapacity = 300000;
                break;

            case "IndiGo":
                maxFuelCapacity = 250000;
                break;

            case "Air Arabia":
                maxFuelCapacity = 150000;
                break;
        }

        if (currentFuelLevel < 0
                || currentFuelLevel > maxFuelCapacity) {

            throw new InvalidFlightException(
                    "Invalid fuel level for " + flightName
            );
        }

        return maxFuelCapacity - currentFuelLevel;
    }
}

public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FlightUtil flightUtil = new FlightUtil();

        System.out.println("Enter flight details");

        try {
            String input = scanner.nextLine();

            String[] details = input.split(":");

            String flightNumber = details[0];
            String flightName = details[1];
            int passengerCount = Integer.parseInt(details[2]);
            double currentFuelLevel = Double.parseDouble(details[3]);

            flightUtil.validateFlightNumber(flightNumber);

            flightUtil.validateFlightName(flightName);

            flightUtil.validatePassengerCount(
                    passengerCount,
                    flightName
            );

            double fuelRequired =
                    flightUtil.calculateFuelToFillTank(
                            flightName,
                            currentFuelLevel
                    );

            System.out.println(
                    "Fuel required to fill the tank: "
                            + fuelRequired + " liters"
            );

        } catch (InvalidFlightException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            // Handles invalid input format
            System.out.println("Invalid input");
        }

        scanner.close();
    }
}