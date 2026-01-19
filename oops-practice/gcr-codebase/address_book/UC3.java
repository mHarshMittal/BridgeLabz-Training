
import java.util.*;

// UC-2 Add new Contact to address Book
class AddressBook2 {
	private Contacts contact;

	public void addContact(Contacts contact) {
		setContact(contact);
	}

	public Contacts getContact() {
		return contact;
	}

	public void setContact(Contacts contact) {
		this.contact = contact;
	}

	// UC-3 edit contact using name
	public void editContact(String name, String firstName, String lastName, String address, String city, String state,
			int zip, String phoneNumber, String email) {
		if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
			System.out.println("Contact found: " + contact);
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setAddress(address);
			contact.setCity(city);
			contact.setState(state);
			contact.setZip(zip);
			contact.setPhoneNumber(phoneNumber);
			contact.setEmail(email);
			System.out.println("Contact edited");
			System.out.println(contact);
			return;
		}
		System.out.println("Contact Not Found");
	}
}

public class UC3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook2 addressBook = new AddressBook2();

		System.out.println("Enter First name");
		String firstName = sc.nextLine();
		System.out.println("Enter last name. Otherwise enter continue");
		String lastName = sc.nextLine();
		if (lastName.equalsIgnoreCase("continue")) {
			firstName = null;
		}
		System.out.println("Enter Address");
		String address = sc.nextLine();
		System.out.println("Enter City");
		String city = sc.nextLine();
		System.out.println("Enter state");
		String state = sc.nextLine();
		System.out.println("Enter zip code. Else enter continue");
		String zip = sc.nextLine();
		if (zip.equalsIgnoreCase("continue")) {
			zip = null;
		}
		System.out.println("Enter contact Number");
		String phoneNumber = sc.nextLine();
		System.out.println("Enter email address. Else enter continue");
		String email = sc.nextLine();
		if (email.equalsIgnoreCase("continue")) {
			email = null;
		}
		Contacts contact = new Contacts(firstName, lastName, address, city, state, Integer.valueOf(zip), phoneNumber,
				email);
		addressBook.addContact(contact);

		System.out.println("Enter first name or last name to search");
		String name = sc.nextLine();
		System.out.println("Enter details to replace");

		System.out.println("Enter First name");
		firstName = sc.nextLine();
		System.out.println("Enter last name. Otherwise enter continue");
		lastName = sc.nextLine();
		if (lastName.equalsIgnoreCase("continue")) {
			firstName = null;
		}
		System.out.println("Enter Address");
		address = sc.nextLine();
		System.out.println("Enter City");
		city = sc.nextLine();
		System.out.println("Enter state");
		state = sc.nextLine();
		System.out.println("Enter zip code. Else enter continue");
		zip = sc.nextLine();
		if (zip.equalsIgnoreCase("continue")) {
			zip = null;
		}
		System.out.println("Enter contact Number");
		phoneNumber = sc.nextLine();
		System.out.println("Enter email address. Else enter continue");
		email = sc.nextLine();
		if (email.equalsIgnoreCase("continue")) {
			email = null;
		}
		addressBook.editContact(name, firstName, lastName, address, city, state, Integer.valueOf(zip), phoneNumber,
				email);

	}

}