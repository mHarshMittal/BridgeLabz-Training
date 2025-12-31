class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    HotelBooking() {
        this("Guest", "Standard", 1);
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking other) {
        this(other.guestName, other.roomType, other.nights);
    }

    void display() {
        System.out.println("Guest Name: " + guestName + ", Room Type: " + roomType + ", Nights: " + nights);
    }
}

public class HotelBookingSystem {

	public static void main(String[] args) {
	
		HotelBooking hb1 = new HotelBooking();
		HotelBooking hb2 = new HotelBooking("Govind", "Single", 3);
		HotelBooking hb3 = new HotelBooking(hb2);
		hb1.display();
		hb2.display();
		hb3.display();
	}

}