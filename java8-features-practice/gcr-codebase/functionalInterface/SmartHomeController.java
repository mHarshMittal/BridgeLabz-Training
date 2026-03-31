interface SmartDevice {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevice {
    public void turnOn() {
        System.out.println("Light is ON");
    }
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class AirConditioner implements SmartDevice {
    public void turnOn() {
        System.out.println("AC is ON");
    }
    public void turnOff() {
        System.out.println("AC is OFF");
    }
}

class Television implements SmartDevice {
    public void turnOn() {
        System.out.println("TV is ON");
    }
    public void turnOff() {
        System.out.println("TV is OFF");
    }
}

public class SmartHomeController {
    public static void main(String[] args) {
        SmartDevice device1 = new Light();
        SmartDevice device2 = new AirConditioner();
        SmartDevice device3 = new Television();

        device1.turnOn();
        device2.turnOn();
        device3.turnOn();

        device1.turnOff();
        device2.turnOff();
        device3.turnOff();
    }
}
