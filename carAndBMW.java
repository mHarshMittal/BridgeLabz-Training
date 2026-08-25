class Car {
    int speed;
    int numberOfTyres;

    Car(int speed, int numberOfTyres) {
        this.speed = speed;
        this.numberOfTyres = numberOfTyres;
    }

    void accelerate() {
        speed += 10;
        System.out.println("Car is accelerating");
    }

    void showSpeed() {
        System.out.println("Car speed: " + speed);
    }
}

class BMW extends Car {

    BMW(int speed, int numberOfTyres) {
        super(speed, numberOfTyres);
    }

    @Override
    void accelerate() {
        speed += 20;
        System.out.println("BMW is accelerating faster");
    }

    @Override
    void showSpeed() {
        System.out.println("BMW speed: " + speed);
    }
}

public class carAndBMW {
    public static void main(String[] args) {

        BMW bmw = new BMW(100, 4);

        System.out.println("Number of tyres: " + bmw.numberOfTyres);

        bmw.accelerate();
        bmw.showSpeed();
    }
}