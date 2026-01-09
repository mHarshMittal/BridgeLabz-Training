/*Flight Booking System (CRUD)Scenario:
 Simulate a basic flight booking system where users can search flights, book them,
and view booking details. 
 Problem Requirements:
● Use Array to store available flight data.
● Store user bookings in a List.
● Use String operations to allow case-insensitive flight search.
● Use methods for searching, booking, and displaying bookings. */


import java.util.ArrayList;
import java.util.List;

// Flight class
class Flight {
    String flightNumber;
    String source;
    String destination;

    public Flight(String flightNumber, String source, String destination) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
    }

    public void displayFlight() {
        System.out.println(flightNumber + " : " + source + " -> " + destination);
    }
}

// Booking class
class Booking {
    String passengerName;
    Flight flight;

    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public void displayBooking() {
        System.out.println("Passenger: " + passengerName);
        flight.displayFlight();
    }
}

// Main class
public class FlightBookingSystem {

    // Array to store flights
    static Flight[] flights = {
        new Flight("AirIndia101", "Delhi", "Mumbai"),
        new Flight("Indigo202", "Delhi", "Bangalore"),
        new Flight("Vastara303", "Mumbai", "Chennai"),
        new Flight("KingFisher404", "Agra", "Bangalore")
    };

    // List to store bookings
    static List<Booking> bookings = new ArrayList<>();

    // Search flight using case-insensitive comparison
    static Flight searchFlight(String source, String destination) {
        for (Flight flight : flights) {
            if (flight.source.equalsIgnoreCase(source) &&
                flight.destination.equalsIgnoreCase(destination)) {
                return flight;
            }
        }
        return null;
    }

    // Book flight
    static void bookFlight(String passengerName, Flight flight) {
        bookings.add(new Booking(passengerName, flight));
    }

    // Display all bookings
    static void displayBookings() {
        for (Booking booking : bookings) {
            booking.displayBooking();
            System.out.println("-----------");
        }
    }

    public static void main(String[] args) {
        Flight flight = searchFlight("delhi", "mumbai");

        if (flight != null) {
            bookFlight("Rohit", flight);
        }

        displayBookings();
    }
}
