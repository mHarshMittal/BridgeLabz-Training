/* Vehicle Rental Application (CRUD)
● Concepts: Vehicle, Bike, Car, Truck, Customer.
● Access Modifiers: protected fields.
● Interface: IRentable with CalculateRent(int days). */

// Interface for rent calculation
interface IRentable {
    double calculateRent(int days);
}

// Base Vehicle class
class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected double rentPerDay;

    public Vehicle(String vehicleNumber, String brand, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
    }

    public void displayVehicle() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Brand: " + brand);
    }
}

// Bike class
class Bike extends Vehicle implements IRentable {

    public Bike(String number, String brand, double rent) {
        super(number, brand, rent);
    }

    public double calculateRent(int days) {
        return days * rentPerDay;
    }
}

// Car class
class Car extends Vehicle implements IRentable {

    public Car(String number, String brand, double rent) {
        super(number, brand, rent);
    }

    public double calculateRent(int days) {
        return days * rentPerDay;
    }
}

// Truck class
class Truck extends Vehicle implements IRentable {

    public Truck(String number, String brand, double rent) {
        super(number, brand, rent);
    }

    public double calculateRent(int days) {
        return days * rentPerDay;
    }
}

// Customer class
class Customer {
    
    private String customerName;

    public Customer(int id, String name) {
        
        customerName = name;
    }

    public void displayCustomer() {
        System.out.println("Customer: " + customerName);
    }
}

// Main class
public class VehicleRentalApp {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Amit");

        IRentable car = new Car("UP85AB1234", "Honda", 1500);
        IRentable bike = new Bike("DL04QW1234", "Yamaha", 500);
        IRentable truck = new Truck("UP83AS9999", "Tata", 3000);

        customer.displayCustomer();
        System.out.println("Car Rent for 3 days: " + car.calculateRent(3));
        System.out.println("Bike Rent for 5 days: " + bike.calculateRent(5));
        System.out.println("Truck Rent for 2 days: " + truck.calculateRent(2));
    }
}
