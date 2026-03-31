package addressBook;

import java.util.*;

public class ContactRepository {
	private ArrayList<Contact> contacts = new ArrayList<>();
	
	//create
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	//read
	public List<Contact> getAllContacts() {
        return contacts;
    }
	
	public Contact findByFirstName(String firstName) {
		for(Contact c: contacts) {
			if(c.getFirstName().equalsIgnoreCase(firstName)) {
				return c;
			}
		}
		return null;
	}
	
	//delete
	public void deleteContact(Contact contact) {
		contacts.remove(contact);
	}
}
