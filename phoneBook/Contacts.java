package phoneBook;



public class Contacts {
	 private String fullName;
	private String firstName;
	private String lastName;
    private String phoneNumber;
    private Address address;
    
	//public Contacts() {}
	public Contacts(String fullName, String firstName, String lastName,String phoneNumber, Address address) {
		
			this.firstName = firstName;
			this.fullName = fullName;
			this.lastName = lastName;
			this.phoneNumber= phoneNumber;
			this.address = address;
		
	}
	
	
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName= lastName;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public String toString() {
		return firstName +" "+ lastName + " "+ address.toString() +" "+ this.phoneNumber;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return this.address;
	}
	
}
