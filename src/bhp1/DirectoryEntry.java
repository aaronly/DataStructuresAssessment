package bhp1;
/**
 *AE; A class to hold a directory entry which includes name, email, and telephone number.
 * @author Aaron Echols
 *
 */
public class DirectoryEntry implements Comparable<DirectoryEntry>{

	/**
	 *AE; the person's first name
	 */
	private String firstName;
	/**
	 *AE; the person's last name
	 */
	private String lastName;
	/**
	 *AE; the person's phone number
	 */
	private String phoneNumber;
	/**
	 *AE; the person's email address
	 */
	private String emailAddress;
	
	//AE; CONSTRUCTORS
	
	/**
	 *AE; A directory entry which includes name, email, and telephone number.
	 * @param first First name
	 * @param last Last name
	 * @param phone Telephone number
	 * @param email Email address
	 */
	public DirectoryEntry(String first, String last, String phone, String email) {
		firstName = first;
		lastName = last;
		phoneNumber = phone;
		emailAddress = email;
	}
	/**
	 *AE; A directory entry which includes name, email, and telephone number.
	 * @param name First and last name
	 * @param phone Telephone number
	 * @param email Email address
	 */
	public DirectoryEntry(String name, String phone, String email) {
		setName(name);
		phoneNumber = phone;
		emailAddress = email;
	}
	/**
	 *AE; A directory entry which includes name, email, and telephone number.
	 * @param first First name
	 * @param last Last name
	 */
	public DirectoryEntry(String first, String last) {
		this(first, last, null, null);
	}
	/**
	 *AE; A directory entry which includes name, email, and telephone number.
	 * @param name
	 */
	public DirectoryEntry(String name) {
		this(name, null, null);
	}
	
	//AE; FIRST NAME
	
 	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first) {
		firstName = first;
	}

	//AE; LAST NAME
	
	public String getLastName()	{
		return lastName;
	}
	public void setLastName(String last) {
		lastName = last;
	}

	//AE; FULL NAME
	
	public String getName()	{
		return firstName + " " + lastName;
	}
	public void setName(String name) {
		if(!name.contains(" "))
			setFirstName(name);
		else
		{
			firstName = name.substring(0, name.indexOf(" "));
			lastName = name.substring(name.indexOf(" ") + 1);
		}
	}

	//AE; EMAIL ADDRESS
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String email) {
		emailAddress = email;
	}

	//AE; PHONE NUMBER
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phone) {
		phoneNumber = phone;
	}
	
	//AE; COMPARATOR METHODS
	
	@Override
	public int compareTo(DirectoryEntry entry) {
		return this.getName().toUpperCase().compareTo(entry.getName().toUpperCase());
	}
	@Override
	public boolean equals(Object obj) {
		//AE; if the object is null, return false
		if (obj == null) return false;
		//AE; the object can;t be cast to DirectoryEntry, return false
		if (!DirectoryEntry.class.isAssignableFrom(obj.getClass())) return false;
		//AE; cast the object to the DirectoryEntry class
		DirectoryEntry entry = (DirectoryEntry)obj;
		//AE; compare the full names
		return this.getName().toUpperCase().equals(entry.getName().toUpperCase());
	}
	
	/**
	 *AE; Get the hash code based on the name
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		int hash = 0; //AE; a running hash adder
		int g = 1; //AE; the multiplication factor
		String name = getName().toUpperCase();
		int n = name.length(); // the length of the name
		
		//AE; generate large hash code
		for (int i = 0; i < n; i++)
			hash = g * hash + name.charAt(i);
		
		return hash;
	}
	
	public String toString() {
		String result = getName() + "; " + phoneNumber + "; " + emailAddress;
		return result;
	}
}
