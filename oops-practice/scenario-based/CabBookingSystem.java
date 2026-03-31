/*
Cab Booking / Ride Management System : Key Features (CRUD)
Real Scenario
Users book rides, drivers accept, and fare is calculated.Key Features
Ride booking
Driver assignment
Fare calculation
Ride history
Concepts Used
OOP: User, Driver, Ride
Interface: FareCalculator
Polymorphism: Peak vs normal pricing
Exception Handling: NoDriverAvailableException
*/

import java.util.*;
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String msg) {
        super(msg);
    }
}

interface FareCalculator {
    double calculateFare(double distance);
}

// Normal Pricing
class NormalFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

// Peak Pricing
class PeakFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

// User Class
class User {
    int id;
    String name;
    List<Ride> rideHistory = new ArrayList<>();

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void addRide(Ride ride) {
        rideHistory.add(ride);
    }
}

// Driver Class
class Driver {
    int id;
    String name;
    boolean available = true;

    Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Ride Class
class Ride {
    static int counter = 1;
    int rideId;
    User user;
    Driver driver;
    double distance;
    double fare;

    Ride(User user, Driver driver, double distance, double fare) {
        this.rideId = counter++;
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
    }
}

// Ride Manager (CRUD Logic)
class RideManager {
    List<Driver> drivers = new ArrayList<>();

    void addDriver(Driver driver) {
        drivers.add(driver);
    }

    Driver assignDriver() throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.available) {
                d.available = false;
                return d;
            }
        }
        throw new NoDriverAvailableException("No driver available at the moment");
    }

    Ride bookRide(User user, double distance, FareCalculator calculator)
            throws NoDriverAvailableException {

        Driver driver = assignDriver();
        double fare = calculator.calculateFare(distance);

        Ride ride = new Ride(user, driver, distance, fare);
        user.addRide(ride);

        return ride;
    }
}

// Main Class
public class CabBookingSystem {
    public static void main(String[] args) {

        RideManager manager = new RideManager();

        manager.addDriver(new Driver(1, "Ramesh"));
        manager.addDriver(new Driver(2, "Suresh"));

        User user = new User(101, "Amit");

        FareCalculator calculator = new PeakFareCalculator();

        try {
            Ride ride = manager.bookRide(user, 12, calculator);
            System.out.println("Ride Booked");
            System.out.println("Driver: " + ride.driver.name);
            System.out.println("Fare: " + ride.fare);
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
