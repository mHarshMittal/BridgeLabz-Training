
// UC-1 Create Contact Class 
class Contacts {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private String phoneNumber;
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Contacts(String firstName, String lastName, String address, String city, String state, int zip, String phoneNumber,
			String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}

	// for those contacts that do not have a last name, zip-code or email
	Contacts(String firstName, String address, String city, String state, String phoneNumber) {
		setFirstName(firstName);
		setAddress(address);
		setCity(city);
		setState(state);
		setPhoneNumber(phoneNumber);
	}

	// for those contacts that do not have a last name or email
	Contacts(String firstName, String address, String city, String state, String phoneNumber, int zip) {
		setFirstName(firstName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
		setPhoneNumber(phoneNumber);
	}

	// for those contacts that do not have a last name
	Contacts(String firstName, String address, String city, String state, String phoneNumber, int zip, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}

	@Override
	public String toString() {
		return firstName + " " + (lastName != null ? lastName
				: "") + ", Address: " + address + ", " + city + ", " + (zip != 0 ? zip + ","
						: "") + state + "\nContact Info: " + phoneNumber + " " + (email != null ? email : "");
	}
}