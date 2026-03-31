/* Smart Home Devices
Description: Create a hierarchy for a smart home system where Device is the superclass and Thermostat is a subclass.
Tasks:
Define a superclass Device with attributes like deviceId and status.
Create a subclass Thermostat with additional attributes like temperatureSetting.
Implement a method displayStatus() to show each device's current settings.
Goal: Understand single inheritance by adding specific attributes to a subclass, keeping the superclass general. */

// Superclass
class Device {
    int deviceId;
    boolean status; // true = ON, false = OFF

    Device(int deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Displays basic device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }
}

// Subclass
class Thermostat extends Device {
    int temp; // temperature setting

    Thermostat(int deviceId, boolean status, int temp) {
        super(deviceId, status);
        this.temp = temp;
    }

    // Displays thermostat details
    @Override
    void displayStatus() {
        super.displayStatus(); // shows device info
        System.out.println("Temperature: " + temp + "°C");
    }
}

// Main class
public class SmartHome {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat(101, true, 24);
        t1.displayStatus();
    }
}
