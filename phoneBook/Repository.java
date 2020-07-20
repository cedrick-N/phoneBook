package phoneBook;

public class Repository {// extends Contacts {

	public Repository() {

	}

	public static Contacts[] contacts = new Contacts[0];

	public static Contacts[] addContact(Contacts newContact, Contacts[] array) {
		
		Contacts[] newArray = new Contacts[array.length + 1];

		for (int i = 0; i < array.length; i++) {
			newArray[i] = contacts[i];
		}

		newArray[newArray.length - 1] = newContact; // array length -1 to get last index
		return newArray;
	}

	public static Contacts[] findRecords(String firstName, int choice) {
		Contacts[] temp = new Contacts[0];
		//System.out.println("the lenght of tempest;" + temp.length);
		//System.out.println("the length of contacts is " + contacts.length);
		switch (choice) {

		case 1:
			for (Contacts contact : contacts) {
				if (firstName.equalsIgnoreCase(contact.getFirstName())) {
					temp = addContact(contact,temp);
					// System.out.println("test");

				}

			}
//		case 2:
//			for(Contacts contact: contacts) {
//				if(firstName.equalsIgnoreCase(contact.getLastName())) {
//					temp = addContact(contact);
//					//System.out.println("test lastName");
		}
		//System.out.println("the length is of temp is" + temp.length);
		return temp;
	}

	public static void printArray(Contacts[] array) {
		for (Contacts contact : array) {
			System.out.println(contact);
			System.out.println();
		}
	} // note comparison of enhanced for loop and the regular thing!

	public static Contacts updateFinder(String numToSearch) {
		for (int i = 0; i < contacts.length; i++) {
			Contacts contact = contacts[i];
			if (contact.getPhoneNumber().strip().equals(numToSearch.strip())) {
				return contact;
			}
		}
		return null;
	}

	public static Contacts[] findLastName(String lastName) {
		// int counter=0;
		Contacts[] temp = new Contacts[0];
		for (Contacts contact : contacts) {
			if (lastName.strip().equalsIgnoreCase(contact.getLastName().strip())) {
				temp = addContact(contact,temp);

				// counter++;
				// System.out.println("test");
				// check line 67 need to update temp not the original contacts array
			}

		}
		// printArray(temp);
		return temp;

	}

	public static Contacts[] deleteRecord(String phoneNumber) {

		Contacts[] deleteArray = new Contacts[0];
		for (Contacts contacts : contacts) {
			if (!phoneNumber.strip().equals(contacts.getPhoneNumber().strip())) {
				deleteArray = addContact(contacts, deleteArray);
			}

		}
		return deleteArray;
	}

}
