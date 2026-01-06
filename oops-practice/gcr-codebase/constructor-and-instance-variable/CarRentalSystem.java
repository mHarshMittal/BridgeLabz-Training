class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double totalCost;
    final double ratePerDay = 1000;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = calculateCost();
    }

    private double calculateCost() {
        return rentalDays * ratePerDay;
    }

    void display() {
        System.out.println("Name: " + customerName + ", Car Model: " + carModel + ", Total Cost: ₹" + totalCost);
    }
}

public class CarRentalSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarRental c1 = new CarRental("Govind", "BMW" , 11);
		c1.display();
	}

}
