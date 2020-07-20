package phoneBook;

import java.util.Scanner;

public class Menu {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		phoneBook();

	}

	public static void phoneBook() {
		boolean exit = false;
		while (exit != true) {
			System.out.println("Select an option below to continue");
			System.out.println("1. Find Record By First Name");
			System.out.println("2. Find Record By Last Name");
			System.out.println("3. Find Record By Telephone Number");
			System.out.println("4. Update Record");
			System.out.println("5. Delete Record");
			System.out.println("6. Add a new Record");
			System.out.println("7. print Records");
			System.out.println("8. Exit");

			int choice = scan.nextInt();
			scan.nextLine();
			System.out.println(choice);

			switch (choice) {
			case 1:
				System.out.println("Find Record By First Name");
				System.out.println("Enter first name");
				String firstName = scan.nextLine();
				// System.out.println("test");
				Repository.printArray(Repository.findRecords(firstName, choice));
				break;
			case 2:
				System.out.println("Find Record By Last Name");
				System.out.println("Enter last name");
				String lastName = scan.nextLine();
				// System.out.println("test");
				Repository.printArray(Repository.findLastName(lastName));

				break;
			case 3:
				System.out.println("Find Record By Telephone Number. ");
				System.out.println("Enter the telephone number");
				String numToSearch = scan.nextLine();
				Contacts telNum = Repository.updateFinder(numToSearch);
				System.out.println(telNum); // returning just one contact instead of two
				break;
			case 4:
				System.out.println("Update Record");
				updateMenu();

				break;
			case 5:
				System.out.println("Delete Record");
				System.out.println("Enter phone number for record to be deleted");
				String phoneNumber = scan.nextLine();
				Repository.contacts = Repository.deleteRecord(phoneNumber);
				

				break;

			case 6:
				System.out.println("Add a new Record");
				System.out.println("Enter name and address");
				String newContact = scan.nextLine();
				createNewContact(newContact);
				break;
			case 7:
				Repository.printArray(Repository.contacts);
				break;
			case 8:
				System.out.println("Exit");
				exit = true;
				break;

			default:
				System.out.println("please enter a valid choice");
			}
		}

	}

	

	private static void createNewContact(String newContact) { // for option 6
		String[] name = newContact.split(",");

		String streetAddress = name[1].strip();
		String city = name[2].strip();
		String State = name[3].strip();
		String zip = name[4].strip();
		String phoneNumber = name[5].strip();

		String[] fullNameArray = name[0].split(" ");
		String firstName = fullNameArray[0].strip();
		String lastName = fullNameArray[fullNameArray.length - 1].strip();
		String fullName = name[0].strip();

		Address address = new Address(streetAddress, city, State, zip);
		Contacts contact = new Contacts(fullName, firstName, lastName, phoneNumber, address);
		Repository.contacts = Repository.addContact(contact,Repository.contacts);
	}

	// methods just for this class => less cumbersome code;
	private static void updateMenu() {// for case 4
		System.out.println(" enter the telephonenumber for record to be updated ");

		String numToSearch = scan.nextLine();
		// System.out.println("test");
		Contacts updateContact = Repository.updateFinder(numToSearch);

		System.out.println("1. update first Name ");
		System.out.println("2.update Last Name ");
		System.out.println("3.update phone number ");
		System.out.println("4.update Address ");

		int updateChoice = scan.nextInt();
		scan.nextLine();

		switch (updateChoice) {
		case 1:
			System.out.println("Enter new first name");
			String newName = scan.nextLine();
			updateContact.setFirstName(newName);
			System.out.println(updateContact);
		case 2:
			System.out.println("Enter new Last name");
			String newLastName = scan.nextLine();
			updateContact.setLastName(newLastName);
			System.out.println(updateContact);
		case 3:
			System.out.println("Enter new phone Number");
			String newPhoneNumber = scan.nextLine();
			updateContact.setPhoneNumber(newPhoneNumber);
			System.out.println(newPhoneNumber);

		case 4:
			System.out.println("Enter new address");
			String updateAddressString = scan.nextLine();/// user inputs a string which we need to 
																// make into an array and equate to 
			String[] newAddress = updateAddressString.split(",");  //an object as the setAddress takes an 
			String street = newAddress[0];							// object as an arg
			String city = newAddress[1];							
			String state = newAddress[2];
			String zip = newAddress[3];
			
			Address updateAddress = new Address(street,city,state,zip);
			
			updateContact.setAddress(updateAddress);
			System.out.println(updateAddress);

		}

	}
}
