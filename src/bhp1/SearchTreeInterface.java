package bhp1;
/**
 *AE; An interface for a binary tree structure
 * @author Aaron Echols
 *
 * @param <T> the data type (which is comparable) to store in the node
 */
public interface SearchTreeInterface<T extends Comparable<? super T>> {

	/**
	 *AE; Get the data in the root node
	 * @return the data that is in the root node
	 */
	public T getRootData();
	/**
	 *AE; Set the data of the root node
	 * @param newEntry the data to put in the root node
	 */
	public void setRootData(T newData);
	/**
	 *AE; Get the root node for this tree
	 * @return the root node for this binary tree
	 */
	public BinaryNodeInterface<T> getRootNode();
	/**
	 *AE; Set the root node for this tree
	 * @param newNode the new node to be the root node
	 */
	public void setRootNode(BinaryNodeInterface<T> newNode);
	/**
	 *AE; Add a new node to the binary tree
	 * @param newData the data contained in the node to add
	 * @return null if the new data was added successfully
	 * if matching data was found, replaces old data with new data and returns old data
	 */
	public T add(T newData);
	/**
	 *AE; Remove a specific node from the binary tree
	 * @param data the data contained in the node to remove from the binary tree
	 * @return true if the node containing the data was found and removed, false if not
	 */
	public boolean remove(T data);
	/**
	 *AE; Find data in the search tree based on the generic type's compareTo method
	 * @param data the data to find in the search tree
	 * @return the data object found
	 */
	public T getEntry(T data);
	/**
	 *AE; the height of the binary tree
	 * @return an integer representing the longest path in the tree i.e. from root node to the lowest leaf node
	 */
	public int getHeight();
	/**
	 *AE; Get the number of node in the binary tree
	 * @return the total number of nodes contained in the binary tree
	 */
	public int getNumberOfNodes();
	/**
	 *AE; Check if the binary tree contains no nodes
	 * @return true if the binary tree is empty, false if not
	 */
	public boolean isEmpty();
	/**
	 *AE; Empty tree of any entries
	 */
	public void clear();
	
}
