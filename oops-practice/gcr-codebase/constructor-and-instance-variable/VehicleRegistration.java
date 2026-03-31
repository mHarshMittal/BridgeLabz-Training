
class Vehicle {
	private String ownerName;
	private String vehicleType;
	private static double registrationFee = 1000;

	public Vehicle() {
		this("Unknown", "Unknown");
	}

	Vehicle(String ownerName, String vehicleType) {
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
	}

	void displayVehicleDetails() {
		System.out.println(
				"Name: " + ownerName + ", Vehicle Type: " + vehicleType + ", Registration Fee: " + registrationFee);
	}

	void updateRegistrationFee(double updatedFees) {
		registrationFee = updatedFees;
	}
}

public class VehicleRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v1 = new Vehicle("Govind", "Scooter");
		Vehicle v2 = new Vehicle("Akash", "Cycle");
		v1.displayVehicleDetails();
		v2.displayVehicleDetails();
		v1.updateRegistrationFee(5000);
		v2.displayVehicleDetails();
	}

}
