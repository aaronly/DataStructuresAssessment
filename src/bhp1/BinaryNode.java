package bhp1;
/**
 *AE; A binary node class
 * @author Aaron Echols
 *
 * @param <T> A class that is comparable that will be stored in the binary node
 */
public class BinaryNode<T extends Comparable<? super T>>
		implements BinaryNodeInterface<T> {

	/**
	 *AE; the data contained in the node
	 */
	private T data;
	/**
	 *AE; the left child node
	 */
	private BinaryNodeInterface<T> leftChild;
	/**
	 *AE; the right child node
	 */
	private BinaryNodeInterface<T> rightChild;
	
	/**
	 *AE; Create a new binary node with no data and no child nodes
	 */
	public BinaryNode() {
		this(null, null, null);
	}
	/**
	 *AE; Create a new binary node with data and no child nodes
	 * @param newEntry the data to put in the node
	 */
	public BinaryNode(T newData) {
		this(newData, null, null);
	}
	/**
	 *AE; Create a new binary node with data and at least one child node
	 * @param newEntry the data to put in the node
	 * @param leftChild a binary node to link as the left child node
	 * @param rightChild a binary node to link as the right child node
	 */
	public BinaryNode(T newData, BinaryNodeInterface<T> leftChild, BinaryNodeInterface<T> rightChild) {
		data = newData;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T newData) {
		data = newData;
	}

	public BinaryNodeInterface<T> getLeftChild() {
		return leftChild;
	}

	public BinaryNodeInterface<T> getRightChild() {
		return rightChild;
	}

	public void setLeftChild(BinaryNodeInterface<T> leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		this.rightChild = rightChild;
	}

	public boolean hasLeftChild() {
		return leftChild != null;
	}

	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public int getHeight() {
		//AE; initialize counters for both left and right nodes
		int leftHeight = 0;
		int rightHeight = 0;
		//AE; if there is a left node, get the height of that child node and add it and 1 to the running total
		if(hasLeftChild()) leftHeight += 1 + getLeftChild().getHeight();
		//AE; if there is a right node, get the height of that child node and add it and 1 to the running total
		if(hasRightChild())	rightHeight += 1 + getRightChild().getHeight();
		//AE; return the larger of the the two counters
		return Math.max(leftHeight, rightHeight);
	}

	public int getNumberOfNodes() {
		//AE; initialize total by counting the root
		int total = 1;
		//AE; if the left child is not null, get the number of nodes for the left node
		if (leftChild != null) total += leftChild.getNumberOfNodes();
		//AE; if the right child is not null, get the number of nodes for the right node
		if (rightChild != null)	total += rightChild.getNumberOfNodes();
		return total;
	}
	
	public boolean isLeaf() {
		if (leftChild == null && rightChild == null) return true;
		return false;
	}

	public BinaryNodeInterface<T> copy() {
		BinaryNodeInterface<T> newNode = new BinaryNode<T> (data, leftChild, rightChild);
		return newNode;
	}
}