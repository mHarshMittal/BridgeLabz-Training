import java.util.ArrayList;
import java.util.List;

class InvalidPhoneNumberException extends Exception {
    InvalidPhoneNumberException(String m) {
        super(m);
    }
}

// contact class
class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class ContactOrganizer {

    static List<Contact> list = new ArrayList<>();

    // add contact in list
    static void addContact(String name, String phone)
            throws InvalidPhoneNumberException {

        if (phone.length() != 10) {
            throw new InvalidPhoneNumberException("Phone must be 10 digits");
        }

        for (Contact c : list) {
            if (c.phone.equals(phone)) {
                System.out.println("Duplicate contact not allowed");
                return;
            }
        }

        list.add(new Contact(name, phone));
        System.out.println("Contact added");
    }

    // delete contact
    static void deleteContact(String phone) {
        for (Contact c : list) {
            if (c.phone.equals(phone)) {
                list.remove(c);
                System.out.println("Contact deleted");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    // search contact
    static void searchContact(String phone) {
        for (Contact c : list) {
            if (c.phone.equals(phone)) {
                System.out.println(c.name + " - " + c.phone);
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public static void main(String[] args) {
        try {
            addContact("Aman", "9876543210");
            searchContact("9876543210");
            deleteContact("9876543210");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
