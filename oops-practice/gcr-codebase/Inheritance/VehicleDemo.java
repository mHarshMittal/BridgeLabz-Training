// Interface
interface Refuelable {
    void refuel();
}

// Base class
class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int s, String m) {
        maxSpeed = s;
        model = m;
    }
}

// Electric vehicle
class ElectricVehicle extends Vehicle {

    ElectricVehicle(int s, String m) {
        super(s, m);
    }

    void charge() {
        System.out.println("Vehicle is charging");
    }
}

// Petrol vehicle
class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(int s, String m) {
        super(s, m);
    }

    public void refuel() {
        System.out.println("Vehicle is refueled with petrol");
    }
}

// Test class
public class VehicleDemo {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(120, "EV-Model");
        PetrolVehicle pv = new PetrolVehicle(180, "Petrol-Model");

        ev.charge();
        pv.refuel();
    }
}
