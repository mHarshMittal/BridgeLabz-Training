
public class Vehicle {
    private static double regFees = 1500.0;
    
    private final String regNumber;
    private String ownerName;
    private String vehicleType;
    
    public Vehicle(String ownerName, String vehicleType, String regNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.regNumber = regNumber; // Final variable assigned only once
    }
    
    // Static method to update registration fee
    public static void updateRegFees(double newFee) {
        regFees = newFee;
    }
    
    // Method to display vehicle registration details
    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + regNumber);
            System.out.println("Registration Fee: Rs/- " + regFees);
        } else {
            System.out.println("Invalid vehicle instance.");
        }
    }
    
    // Getters and setters
    public String getOwnerName() {
        return ownerName;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    public String getRegNumber() {
        return regNumber;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create two vehicles
        Vehicle veh1 = new Vehicle("Harsh ", "Sedan", "ABC123");
        Vehicle veh2 = new Vehicle("Agraj", "Truck", "XYZ789");
        
        // Display registration details
        System.out.println();
        veh1.displayRegistrationDetails();
        System.out.println();
        veh2.displayRegistrationDetails();
    }
}

