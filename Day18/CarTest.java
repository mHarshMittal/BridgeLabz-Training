import java.util.*;

abstract class Car {

    public boolean getIsSedan() {
        return false;
    }

    public int getSeats() {
        return 4;
    }

    public abstract String getMileage();
}

class WagonR extends Car {

    @Override
    public boolean getIsSedan() {
        return false;
    }

    @Override
    public int getSeats() {
        return 4;
    }

    @Override
    public String getMileage() {
        return "20 kmpl";
    }
}

class HondaCity extends Car {

    @Override
    public boolean getIsSedan() {
        return true;
    }

    @Override
    public int getSeats() {
        return 4;
    }

    @Override
    public String getMileage() {
        return "15 kmpl";
    }
}

class InnovaCrysta extends Car {

    @Override
    public boolean getIsSedan() {
        return false;
    }

    @Override
    public int getSeats() {
        return 6;
    }

    @Override
    public String getMileage() {
        return "12 kmpl";
    }
}

public class CarTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        Car car;

        if (choice == 0) {
            car = new WagonR();
        } else if (choice == 1) {
            car = new HondaCity();
        } else {
            car = new InnovaCrysta();
        }

        System.out.println("Is Sedan: " + car.getIsSedan());
        System.out.println("Seats: " + car.getSeats());
        System.out.println("Mileage: " + car.getMileage());

        sc.close();
    }
}