package addressBook;
import java.util.*;
public class AddressBookService {
	
//	private ContactRepository repository = new ContactRepository();
	private AddressBookRepository repository = new AddressBookRepository();
	
	private Map<String, List<Contact>> cityMap = new HashMap<>();
    private Map<String, List<Contact>> stateMap = new HashMap<>();
	
	public void createAddressBook(String name) {
        if (repository.getAddressBook(name) == null) {
            repository.addAddressBook(name, new ContactRepository());
            System.out.println("Address Book '" + name + "' created.");
        } else {
            System.out.println("Address Book already exists!");
        }
    }
	
	
	//addContact
	public void addContact(String bookName,Contact contact) {
		ContactRepository book = repository.getAddressBook(bookName);
		if (book != null) {
            if (book.getAllContacts().contains(contact)) {
                System.out.println("Duplicate Entry! Contact already exists.");
            } else {
                book.addContact(contact);
                System.out.println("Contact added successfully.");
             // Add to City Map
                cityMap
                    .computeIfAbsent(contact.getCity(), k -> new ArrayList<>())
                    .add(contact);

                // Add to State Map
                stateMap
                    .computeIfAbsent(contact.getState(), k -> new ArrayList<>())
                    .add(contact);
            }
        } else {
            System.out.println("Address Book not found!");
        }
	}
	
	//display contacts
	public void displayContacts(String bookName) {
		ContactRepository book = repository.getAddressBook(bookName);
        if (book != null) {
            for (Contact c : book.getAllContacts()) {
                System.out.println(c.getFirstName() + " " + c.getLastName()+ " | " + c.getCity()+ " | " + c.getPhoneNumber()+ " | " + c.getMail());
            }
        }
    }
	
	//edit Contact Number
	public void editPhoneNumber(String bookName, String name, long newNumber) {
        ContactRepository book = repository.getAddressBook(bookName);
        if (book != null) {
            Contact c = book.findByFirstName(name);
            if (c != null) {
                c.setPhoneNumber(newNumber);
            }
        }
    }
	
	//edit Contact City
	public void editCity(String bookName, String name, String newCity) {
        ContactRepository book = repository.getAddressBook(bookName);
        if (book != null) {
            Contact c = book.findByFirstName(name);
            if (c != null) {
                c.setCity(newCity);
            }
        }
    }
	
	//edit Contact Mail
	public void editMail(String bookName, String name, String newMail) {
        ContactRepository book = repository.getAddressBook(bookName);
        if (book != null) {
            Contact c = book.findByFirstName(name);
            if (c != null) {
                c.setMail(newMail);
            }
        }
    }
	
	//deleteContact
	public void deleteContact(String bookName, String name) {
        ContactRepository book = repository.getAddressBook(bookName);
        if (book != null) {
            Contact c = book.findByFirstName(name);
            if (c != null) {
                book.deleteContact(c);
                System.out.println("Contact deleted.");
            }
        }
    }
	
	// Search person by City across all Address Books
	public void searchByCity(String city) {
	    boolean found = false;

	    for (String bookName : repository.books.keySet()) {
	        ContactRepository book = repository.books.get(bookName);

	        for (Contact c : book.getAllContacts()) {
	            if (c.getCity().equalsIgnoreCase(city)) {
	                System.out.println(
	                        c.getFirstName() + " " + c.getLastName() +
	                        " | City: " + c.getCity() +
	                        " | Book: " + bookName
	                );
	                found = true;
	            }
	        }
	    }

	    if (!found) {
	        System.out.println("No person found in city: " + city);
	    }
	}
	
	// Search person by State across all Address Books
	public void searchByState(String state) {
	    boolean found = false;

	    for (String bookName : repository.books.keySet()) {
	        ContactRepository book = repository.books.get(bookName);

	        for (Contact c : book.getAllContacts()) {
	            if (c.getState().equalsIgnoreCase(state)) {
	                System.out.println(
	                        c.getFirstName() + " " + c.getLastName() +
	                        " | State: " + c.getState() +
	                        " | Book: " + bookName
	                );
	                found = true;
	            }
	        }
	    }

	    if (!found) {
	        System.out.println("No person found in state: " + state);
	    }
	}
	
	public void viewPersonsByCity(String city) {
	    List<Contact> persons = cityMap.get(city);

	    if (persons == null || persons.isEmpty()) {
	        System.out.println("No persons found in city: " + city);
	        return;
	    }

	    for (Contact c : persons) {
	        System.out.println(
	            c.getFirstName() + " " + c.getLastName() +
	            " | " + c.getCity() +
	            " | " + c.getPhoneNumber()
	        );
	    }
	}
	
	public void viewPersonsByState(String state) {
	    List<Contact> persons = stateMap.get(state);

	    if (persons == null || persons.isEmpty()) {
	        System.out.println("No persons found in state: " + state);
	        return;
	    }

	    for (Contact c : persons) {
	        System.out.println(
	            c.getFirstName() + " " + c.getLastName() +
	            " | " + c.getState() +
	            " | " + c.getPhoneNumber()
	        );
	    }
	}
	
	// Count by City
	public void countByCity(String city) {
	    List<Contact> persons = cityMap.get(city);
	    int count = (persons == null) ? 0 : persons.size();
	    System.out.println("Number of persons in city '" + city + "': " + count);
	}

	// Count by State
	public void countByState(String state) {
	    List<Contact> persons = stateMap.get(state);
	    int count = (persons == null) ? 0 : persons.size();
	    System.out.println("Number of persons in state '" + state + "': " + count);
	}
}
