package addressBook;
import java.util.*;
public class AddressBookMainApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		
		Scanner sc = new Scanner(System.in);
        AddressBookService service = new AddressBookService();

        while (true) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Search by City");
            System.out.println("7. Search by State");
            System.out.println("8. View Persons by City");
            System.out.println("9. View Persons by State");
            System.out.println("10. Count by City");
            System.out.println("11. Count by State");
            System.out.println("12. Sort Contacts by First Name");
            System.out.println("13. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String bookName = sc.nextLine();
                    service.createAddressBook(bookName);
                    break;

                case 2:
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();

                    System.out.print("First Name: ");
                    String fn = sc.nextLine();

                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    
                    System.out.println("Address: ");
                    String address = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("State: ");
                    String state = sc.nextLine();
                    
                    System.out.println("Enter Zip code: ");
                    int zip = sc.nextInt();

                    System.out.print("Phone Number: ");
                    long phone = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Contact contact = new Contact(fn, ln,address, city, state, zip, phone, email);
                    service.addContact(bookName, contact);
                    break;

                case 3:
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();
                    service.displayContacts(bookName);
                    break;

                case 4:
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();
                    System.out.print("Enter First Name of Contact to Edit: ");
                    String editName = sc.nextLine();

                    System.out.println("1. Edit Phone");
                    System.out.println("2. Edit City");
                    System.out.println("3. Edit Email");
                    int editChoice = sc.nextInt();
                    sc.nextLine();

                    switch (editChoice) {
                        case 1:
                            System.out.print("Enter new Phone Number: ");
                            long newPhone = sc.nextLong();
                            sc.nextLine();
                            service.editPhoneNumber(bookName, editName, newPhone);
                            break;
                        case 2:
                            System.out.print("Enter new City: ");
                            String newCity = sc.nextLine();
                            service.editCity(bookName, editName, newCity);
                            break;
                        case 3:
                            System.out.print("Enter new Email: ");
                            String newEmail = sc.nextLine();
                            service.editMail(bookName, editName, newEmail);
                            break;
                    }
                    break;

                case 5:
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();
                    System.out.print("Enter First Name of Contact to Delete: ");
                    String delName = sc.nextLine();
                    service.deleteContact(bookName, delName);
                    break;

                case 6:
                    System.out.print("Enter City to search: ");
                    String searchCity = sc.nextLine();
                    service.searchByCity(searchCity);
                    break;

                case 7:
                    System.out.print("Enter State to search: ");
                    String searchState = sc.nextLine();
                    service.searchByState(searchState);
                    break;

                case 8:
                    System.out.print("Enter City to view persons: ");
                    String viewCity = sc.nextLine();
                    service.viewPersonsByCity(viewCity);
                    break;

                case 9:
                    System.out.print("Enter State to view persons: ");
                    String viewState = sc.nextLine();
                    service.viewPersonsByState(viewState);
                    break;

                case 10:
                    System.out.print("Enter City to count persons: ");
                    String countCity = sc.nextLine();
                    service.countByCity(countCity);
                    break;

                case 11:
                    System.out.print("Enter State to count persons: ");
                    String countState = sc.nextLine();
                    service.countByState(countState);
                    break;

                case 12:
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();
                    service.sortByFirstName(bookName);
                    break;

                case 13:
                    System.out.println("Exiting... Bye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
	}

}
