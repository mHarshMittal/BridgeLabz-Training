/*Vehicle Rental System
Description: Design a system to manage vehicle rentals:
Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
Add an abstract method calculateRentalCost(int days).
Create subclasses Car, Bike, and Truck with specific implementations of calculateRentalCost().
Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
Demonstrate polymorphism by iterating over a list of vehicles and calculating rental and insurance costs for each.
 */

interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate; // accessible to subclasses

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 500.0; // fixed insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: ****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 2);
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 200.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: ****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 2);
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (rentalRate * days) + 1000; // extra loading charge
    }

    @Override
    public double calculateInsurance() {
        return 1200.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: ****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 2);
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("CAR101", 1500, "CAR98765"),
                new Bike("BIKE202", 500, "BIKE54321"),
                new Truck("TRUCK303", 3000, "TRUCK67890")
        };

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost: " + v.calculateRentalCost(rentalDays));

            Insurable ins = (Insurable) v;
            System.out.println("Insurance Cost: " + ins.calculateInsurance());
            System.out.println(ins.getInsuranceDetails());
            System.out.println("---------------------------");
        }
    }
}
