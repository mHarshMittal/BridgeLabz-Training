/*Vehicle and Transport System
Description: Design a vehicle hierarchy where Vehicle is the superclass, and Car, Truck, and Motorcycle are subclasses with unique attributes.
Tasks:
Define a superclass Vehicle with maxSpeed and fuelType attributes and a method displayInfo().
Define subclasses Car, Truck, and Motorcycle, each with additional attributes, such as seatCapacity for Car.
Demonstrate polymorphism by storing objects of different subclasses in an array of Vehicle type and calling displayInfo() on each.
Goal: Understand how inheritance helps in organizing shared and unique features across subclasses and use polymorphism for dynamic method calls.
 */


class Vehicle {
    int maxSpeed;
    String fuel;

    Vehicle(int maxSpeed, String fuel) {
        this.maxSpeed = maxSpeed;
        this.fuel = fuel;
    }

    void displayInfo() {
        System.out.println("Speed: " + maxSpeed);
        System.out.println("Fuel: " + fuel);
    }
}

class Car extends Vehicle {
    int seats;

    Car(int maxSpeed, String fuel, int seats) {
        super(maxSpeed, fuel);
        this.seats = seats;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seats: " + seats);
    }
}

class Truck extends Vehicle {
    int load;

    Truck(int maxSpeed, String fuel, int load) {
        super(maxSpeed, fuel);
        this.load = load;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + load);
    }
}

class Motorcycle extends Vehicle {

    Motorcycle(int maxSpeed, String fuel) {
        super(maxSpeed, fuel);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Two Wheeler");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle[] v = {
            new Car(180, "Petrol", 5),
            new Truck(120, "Diesel", 1000),
            new Motorcycle(150, "Petrol")
        };

        for (Vehicle x : v) {
            x.displayInfo();
            System.out.println();
        }
    }
}
