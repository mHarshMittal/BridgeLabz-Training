public class FlightUtil {

    public boolean validateFlightNumber(String flightNumber)
            throws InvalidFlightException {

        if (!flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException(
                "The flight number " + flightNumber + " is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName)
            throws InvalidFlightException {

        if (!(flightName.equals("SpiceJet") ||
              flightName.equals("Vistara") ||
              flightName.equals("IndiGo") ||
              flightName.equals("Air Arabia"))) {

            throw new InvalidFlightException(
                "The flight name " + flightName + " is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int count, String flightName)
            throws InvalidFlightException {

        int max = switch (flightName) {
            case "SpiceJet" -> 396;
            case "Vistara" -> 615;
            case "IndiGo" -> 230;
            case "Air Arabia" -> 130;
            default -> 0;
        };

        if (count <= 0 || count > max) {
            throw new InvalidFlightException(
                "The passenger count " + count + " is invalid for " + flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuel)
            throws InvalidFlightException {

        double capacity = switch (flightName) {
            case "SpiceJet" -> 200000;
            case "Vistara" -> 300000;
            case "IndiGo" -> 250000;
            case "Air Arabia" -> 150000;
            default -> 0;
        };

        if (currentFuel < 0 || currentFuel > capacity) {
            throw new InvalidFlightException(
                "Invalid fuel level for " + flightName);
        }
        return capacity - currentFuel;
    }
}