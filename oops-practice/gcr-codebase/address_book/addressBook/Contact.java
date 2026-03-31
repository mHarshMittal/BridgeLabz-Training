package addressBook;

public class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String mail;
	public Contact(String firstName,String lastName,String address,String city,String state,int zip,long phoneNumber,String mail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		
	}
	
	//setters and getters
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName; 
	}
	
    public String getAddress() {
    	return address;
    }
    public String getCity() {
    	return city; 
    }
    
    public String getState() {
    	return state; 
    }
    
    public int getZip() {
    	return zip; 
    }
    
    public long getPhoneNumber() {
    	return phoneNumber; 
    }
    
    public String getMail() {
    	return mail; 
    }

    public void setCity(String city) {
    	this.city = city; 
    }
    
    public void setPhoneNumber(long phoneNumber) {
    	this.phoneNumber = phoneNumber; 
    }
    
    public void setMail(String mail) {
    	this.mail = mail; 
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact c = (Contact) o;
        return firstName.equalsIgnoreCase(c.firstName) &&
               lastName.equalsIgnoreCase(c.lastName);
    }

    @Override
    public int hashCode() {
        return firstName.toLowerCase().hashCode() + lastName.toLowerCase().hashCode();
    }
}
