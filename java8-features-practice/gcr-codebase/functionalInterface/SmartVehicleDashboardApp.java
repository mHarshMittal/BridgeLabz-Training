interface VehicleDashboard {
    void displaySpeed();

    default void displayBatteryPercentage() {
        System.out.println("Battery: 85%");
    }
}

class ElectricCarDashboard implements VehicleDashboard {
    public void displaySpeed() {
        System.out.println("Speed: 70 km/h");
    }
}

public class SmartVehicleDashboardApp {
    public static void main(String[] args) {
        VehicleDashboard dashboard = new ElectricCarDashboard();
        dashboard.displaySpeed();
        dashboard.displayBatteryPercentage();
    }
}
