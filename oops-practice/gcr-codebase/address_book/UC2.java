import java.util.*;

// UC-2 Add new Contact to address Book
class AddressBook {
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
}

class UC2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		while(true) {
			boolean hasLast = false;
			boolean hasZip = false;
			boolean hasEmail = false;
			System.out.println("Enter First name");
			String firstName = sc.next();
			System.out.println("Enter last name. Otherwise enter continue");
			String lastName = sc.next();
			if(lastName.equalsIgnoreCase("continue")) {
				hasLast = true;
			}
			System.out.println("Enter Address");
			String address = sc.nextLine();
			System.out.println("Enter City");
			String city = sc.nextLine();
			System.out.println("Enter state");
			String state = sc.nextLine();
			System.out.println("Enter zip code. Else enter continue");
			String zip = sc.next();
			if(zip.equalsIgnoreCase("continue")) {
				hasZip = true;
			}
			System.out.println("Enter contact Number");
			String phoneNumber = sc.next();
			System.out.println("Enter email address. Else enter continue");
			String email = sc.next();
			if(email.equalsIgnoreCase("continue")) {
				hasEmail = true;
			}
			Contacts contact;
			if(hasLast && hasZip && hasEmail) {
				contact = new Contacts(firstName, address, city, state, phoneNumber);
			}
			else if(hasLast && hasEmail) {
				contact = new Contacts(firstName, address, city, state, phoneNumber, Integer.valueOf(zip));
			}
			else if(hasLast) {
				contact = new Contacts(firstName, address, city, state, phoneNumber, Integer.valueOf(zip), email);
			}
			else {
				contact = new Contacts(firstName, lastName, address, city, state, Integer.valueOf(zip), phoneNumber, email);
			}
			addressBook.addContact(contact);
			break;
		}
	}

}