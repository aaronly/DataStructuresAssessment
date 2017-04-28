package bhp1;
/**
 *AE; An interface for the ADT sorted list
 * @author Aaron Echols
 *
 * @param <T> the data type (which is comparable) to store in the list
 */
public interface SortedListInterface<T extends Comparable<? super T>> {
	/**
	 *AE; Adds an object to the list in its sorted position
	 * @param entry the object to be added to the sorted list
	 */
	public void add(T entry);
	/**
	 *AE; Removes an object from the sorted list
	 * @param entry the object to remove from the sorted list
	 * @return true if object was removed successfully, false if not
	 */
	public boolean remove(T entry);
	/**
	 *AE; Removes an object from the sorted list at a given position
	 * @param position the index of the object to remove from the sorted list
	 * @return the object that was removed 
	 */
	public T remove(int position);
	/**
	 *AE; Get the position of a an object in the sorted list
	 * @param entry the object to find in the sorted list
	 * @return the position of the object, or if the object is not found,
	 * the position where the object would go is returned as a negative
	 */
	public int getPosition(T entry);
	/**
	 *AE; Retrieve an entry from the sorted list at a give position
	 * @param position the position of the object to retrieve
	 * @return the object that was in the sorted list at the given position
	 */
	public T getEntry(int position);
	/**
	 *AE; Check if an object is in the sorted list
	 * @param entry the object to check existence for
	 * @return true if the object was in the sorted list, false if not
	 */
	public boolean contains(T entry);
	/**
	 *AE; Remove all items from the sorted list
	 */
	public void clear();
	/**
	 *AE; Get the length of the sorted list
	 * @return the length of the sorted list
	 */
	public int getLength();
	/**
	 *AE; Check if the sorted listed is empty
	 * @return true if there are no objects in the sorted list, false if not
	 */
	public boolean isEmpty();
	/**
	 *AE; Convert the sorted list into an array of objects
	 * @return an array of all the objects in the sorted list
	 */
	public T[] toArray();
}
