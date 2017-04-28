package bhp1;
/**
 *AE; An interface for a node in a binary tree
 * @author Aaron Echols
 *
 * @param <T> the data type (which is comparable) to store in the node
 */
public interface BinaryNodeInterface<T extends Comparable<? super T>> {

	/**
	 *AE; Get the data contained in the node
	 * @return the data contained in the node
	 */
	public T getData();
	/**
	 *AE; Set the data contained in the node
	 * @param newEntry the data to put in the node
	 */
	public void setData(T newEntry);
	/**
	 *AE; Get the left child of the node
	 * @return the node set as the left child
	 */
	public BinaryNodeInterface<T> getLeftChild();
	/**
	 *AE; Get the right child of the node
	 * @return the node set as the right child
	 */
	public BinaryNodeInterface<T> getRightChild();
	/**
	 *AE; Set the left child of this node
	 * @param leftChild the node to set as the left child node
	 */
	public void setLeftChild(BinaryNodeInterface<T> leftChild);
	/**
	 *AE; Set the right child of this node
	 * @param rightChild the node to set as the right child node
	 */
	public void setRightChild(BinaryNodeInterface<T> rightChild);
	/**
	 *AE; Check if node has a left child node
	 * @return true if there exists a left child node, false if not
	 */
	public boolean hasLeftChild();
	/**
	 *AE; Check if node has a right child node
	 * @return true if there exists a right child node, false if not
	 */
	public boolean hasRightChild();
	/**
	 *AE; Get the max height of the node
	 * @return the max height of the node
	 */
	public int getHeight();
	/**
	 *AE; Get the number of nodes this node has
	 * @return the number of child nodes this node has
	 */
	public int getNumberOfNodes();
	/**
	 *AE; Check if node has no child nodes
	 * @return true if there are no child nodes, false if not
	 */
	public boolean isLeaf();
	/**
	 *AE; Copy a node and its child nodes to a new node with a new reference
	 * @return a copy of the node and child nodes with new reference
	 */
	public BinaryNodeInterface<T> copy();
}
