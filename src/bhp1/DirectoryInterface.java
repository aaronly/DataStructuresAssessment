package bhp1;
/**
 *AE; A directory interface that contains objects representing people 
 * @author Aaron Echols
 *
 * @param <T> The person object
 */
public interface DirectoryInterface {
	/**
	 *AE; Add an person to the directory
	 * @param firstName the first name of the person to add
	 * @param lastName the last name of the person to add
	 * @param email the email address of the person to add
	 * @param phone the telephone number of the person to add
	 * @return true if the person was added successfully, false if not
	 */
	public void add(String firstName, String lastName, String email, String phone);
	/**
	 *AE; Remove an person from the directory
	 * @param firstName the first name of the person to remove
	 * @param lastName the last name of the person to remove
	 * @return true if the person was removed successfully, false if not
	 */
	public boolean remove(String firstName, String lastName);
	/**
	 *AE; Lookup a person from the directory
	 * @param firstName the first name of the person to lookup
	 * @param lastName the last name of the person to lookup
	 * @return An object that contains the directory entry
	 */
	public DirectoryEntry lookup(String firstName, String lastName);
	/**
	 *AE; Remove all people from the directory
	 */
	public void clear();
	/**
	 *AE; Get the number of people in the directory
	 * @return The number of people contained in the directory
	 */
	public int getCount();
	/**
	 *AE; Check if the directory is empty
	 * @return true if the directory contain no people, false if not
	 */
	public boolean isEmpty();
	/**
	 *AE; Put all people into an array of objects
	 * @return The array of objects
	 */
	public DirectoryEntry[] toArray();
}
