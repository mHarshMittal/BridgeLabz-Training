interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract Vehicle class
abstract class Vehicle {

    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    //private String location; 

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + " | Driver: " + driverName;
    }

    public abstract double calculateFare(double distance);
}

// Car class
class Car extends Vehicle implements GPS {

    private String location;

    public Car(String id, String driver) {
        super(id, driver, 15);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {

    private String location;

    public Bike(String id, String driver) {
        super(id, driver, 8);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {

    private String location;

    public Auto(String id, String driver) {
        super(id, driver, 10);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

// Polymorphic fare calculator
class RideService {

    public static void calculateRideFare(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Fare for " + distance + " km: " + vehicle.calculateFare(distance));
        System.out.println("------------------------------");
    }
}

// Main class
public class RideHailingApp {

    public static void main(String[] args) {

        Vehicle car = new Car("CAR101", "Amit");
        Vehicle bike = new Bike("BIKE202", "Rohit");
        Vehicle auto = new Auto("AUTO303", "Suresh");

        RideService.calculateRideFare(car, 10);
        RideService.calculateRideFare(bike, 10);
        RideService.calculateRideFare(auto, 10);
    }
}
