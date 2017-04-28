package bhp1;

public class BinarySearchTree<T extends Comparable<? super T>>
		implements SearchTreeInterface<T> {

	/**
	 *AE; a reference to the root node in the tree
	 */
	private BinaryNodeInterface<T> root;
	
	/**
	 *AE; Create a new (empty) binary search tree
	 */
 	public BinarySearchTree() {
 		root = null;
	}
	/**
	 *AE; Create a new binary search tree with a root node and no child nodes
	 * @param data the data to put in the root node
	 */
	public BinarySearchTree(T data) {
		this(data, null, null);
	}
	/**
	 *AE; Create a new binary search tree with a root node and to child nodes that can also be binary search trees
	 * @param data the data to put in the root node
	 * @param leftTree a binary search tree to set as the left child node
	 * @param rightTree a binary search tree to set as the right child node
	 */
	public BinarySearchTree(T data, BinarySearchTree<T> leftTree, BinarySearchTree<T> rightTree) {
		//setPrivateTree(data, leftTree, rightTree);
		root = new BinaryNode<T>(data);
		//AE; if the left tree is not null and has a root node
		if (leftTree != null && !leftTree.isEmpty())
			//AE; set the left child node to the root node of the left tree
			root.setLeftChild(leftTree.root); 

		//AE; if the right tree is not null and has a root node
		if (rightTree != null && !rightTree.isEmpty()) {
			//AE; if the right tree and the left tree are not referencing the same tree
			if (rightTree != leftTree)
				//AE; set the right child node to the root node of the right tree
				root.setRightChild(rightTree.root);
			else
				//AE; otherwise, create a copy of the right tree at the root node and set that as the right child node
				root.setRightChild(rightTree.root.copy());
		}
		
		//AE; this will clear the left tree (to prevent duplication) as long as it doesn't reference this tree
		if (leftTree != null && leftTree != this) leftTree.clear();
		//AE; this will clear the right tree (to prevent duplication) as long as it doesn't reference this tree
		if (rightTree != null && rightTree != this) rightTree.clear();
	}

	public T getRootData() {
		T rootData = root.getData();
		return rootData;
	}
	public void setRootData(T newData) {
		root.setData(newData);
	}
	public BinaryNodeInterface<T> getRootNode() {
		return root;
	}
	public void setRootNode(BinaryNodeInterface<T> newNode) {
		root = newNode;
	}

	public T add(T newData) {
		T result = null;
		//AE; if the tree is empty, set the root node to a new node with the given data
		if(isEmpty()) setRootNode(new BinaryNode<T>(newData));
		//AE; otherwise, add using the private method with the root node as the first node to search
		else result = privateAdd(root, newData);
		return result;
	}
	/**
	 *AE; Private method to add an entry to the binary search tree in the correct location
	 * @param tree the binary search tree to add the data to
	 * @param newData the data to add to the binary search tree
	 * @return 
	 */
	private T privateAdd(BinaryNodeInterface<T> rootNode, T newData) {
		T result = null;

		//AE; if the data given matches the root data, update the data in the root node
		if (rootNode.getData().equals(newData)) {
			result = rootNode.getData();
			rootNode.setData(result);
		}
		//AE; if the data in the root is greater than the data given, traverse the left tree
		else if (rootNode.getData().compareTo(newData) > 0 ) {
			//AE; if the root node has a left child, search that node
			if (rootNode.hasLeftChild())
				result = privateAdd(rootNode.getLeftChild(), newData);
			else //AE; otherwise, add the data to a new node as the left child
				rootNode.setLeftChild(new BinaryNode<T>(newData));	
		}
		//AE; if the data in the root is less than the data given, traverse the right tree
		else if (rootNode.getData().compareTo(newData) < 0 ) {
			//AE; if the root node has a right child, search that node
			if (rootNode.hasRightChild())
				result = privateAdd(rootNode.getRightChild(), newData);
			else //AE; otherwise, add the data to a new node as the right child
				rootNode.setRightChild(new BinaryNode<T>(newData));	
		}
		return result;
	}

	public boolean remove(T data) {
		//AE; if the entry was not found return false;
		if(getEntry(data) == null) return false;
		privateRemove(root, data);
//		BinaryNodeInterface<T> newRoot = privateRemove(root, data);
//		setRootNode(newRoot);

		return true;
	}
	/**
	 * Private method to remove an entry from the binary search tree
	 * @param rootNode the root node to search from the given data
	 * @param givenData the data to remove
	 * @return the parent node of the tree after the node is removed
	 */
	private BinaryNodeInterface<T> privateRemove(BinaryNodeInterface<T> rootNode, T givenData) {
		BinaryNodeInterface<T> parentNode = null;
		
		//AE; return null if rootNode is null
		if (rootNode == null) return null;
		
		//AE; if the data is in the root node
		if (rootNode.getData().equals(givenData))
			rootNode = removeRootNode(rootNode);
		//AE; if the data in the root is greater than the data given
		else if (rootNode.getData().compareTo(givenData) > 0) {
			//AE; continue to traverse the left tree, remove node and set parent node
			parentNode = privateRemove(rootNode.getLeftChild(), givenData);
			//AE; set the root node's left child to the new parent node
			rootNode.setLeftChild(parentNode);
		}
		//AE; if the data in the root is less than the data given
		else if (rootNode.getData().compareTo(givenData) < 0 ) {
			//AE; continue to traverse the right tree, remove node and set parent node
			parentNode = privateRemove(rootNode.getRightChild(), givenData);
			//AE; set the root node's right child to the new parent node
			rootNode.setRightChild(parentNode);
		}
		return rootNode;
	}
	/**
	 *AE; Remove the root node from the tree
	 * @param rootNode the root node to remove
	 * @return the node that replaces the root node
	 */
	private BinaryNodeInterface<T> removeRootNode(BinaryNodeInterface<T> rootNode) {
		//AE; if the root node has two child nodes
		if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			BinaryNodeInterface<T> leftChildNode = rootNode.getLeftChild();
			//AE; find the largest (right-most) child node in the left tree
			BinaryNodeInterface<T> largestChildNode = findLargestNode(leftChildNode);
			//AE; set the data in the root node to the largest data found
			rootNode.setData(largestChildNode.getData());
			//AE; remove the largest (right-most) child node in the left tree
			rootNode.setLeftChild(removeLargestNode(leftChildNode));
		}
		//AE; if the root node has only a left child node
		else if (rootNode.hasLeftChild())
			//AE; set the data in the root node to the
			rootNode = rootNode.getLeftChild();
		//AE; if the root node has only a right child node
		else if (rootNode.hasRightChild())
			//AE; set the data in the root node to the
			rootNode = rootNode.getRightChild();
		//AE; if the root node is a leaf, remove the root node
		else rootNode = null;
		
		return rootNode;
	}
	/**
	 *AE; Find the largest child node of a given node
	 * @param rootNode the node to find the largest child node for
	 * @return the largest child node
	 */
	private BinaryNodeInterface<T> findLargestNode(BinaryNodeInterface<T> rootNode) {
		//AE; if the root node has a right child i.e. a larger node
		if(rootNode.hasRightChild())
			//AE; keep looking for larger nodes
			rootNode = findLargestNode(rootNode.getRightChild());
		return rootNode;
	}
	/**
	 *AE; Remove the largest child node of a given node
	 * @param rootNode the node to find and remove the largest child node for
	 * @return the parent node of the node removed
	 */
	private BinaryNodeInterface<T> removeLargestNode(BinaryNodeInterface<T> rootNode) {
		//AE; if the root node has a right child i.e. a larger node
		if(rootNode.hasRightChild()) {
			//AE; keep looking for larger nodes, return the parent node of the largest node found
			BinaryNodeInterface<T> newRoot = removeLargestNode(rootNode.getRightChild());
			//AE; set the right child node of the root node to the parent of the node removed
			rootNode.setRightChild(newRoot);
		}
		else
			//AE; return the left child node if there is not a right child node
			rootNode = rootNode.getLeftChild();
		return rootNode;
	}
	
	
	
	public T getEntry(T data) {
		return privateGetEntry(root, data);
	}
	/**
	 *AE; Private method to find an entry in a binary search method
	 * @param tree the binary search tree to look in
	 * @param data the data to search from
	 * @return the data object of the item found that matched the data given, null otherwise
	 */
	private T privateGetEntry(BinaryNodeInterface<T> rootNode, T givenData) {
		T result = null;

		//AE; if the data given matches the root data, get the data in the root node
		if (rootNode.getData().equals(givenData)) {
			result = rootNode.getData();
		}
		//AE; if the data in the root is greater than the data given, traverse the left tree
		else if (rootNode.getData().compareTo(givenData) > 0 ) {
			//AE; if the root node has a left child, search that node
			if (rootNode.hasLeftChild())
				result = privateGetEntry(rootNode.getLeftChild(), givenData);
		}
		//AE; if the data in the root is less than the data given, traverse the right tree
		else if (rootNode.getData().compareTo(givenData) < 0 ) {
			//AE; if the root node has a right child, search that node
			if (rootNode.hasRightChild())
				result = privateGetEntry(rootNode.getRightChild(), givenData);
		}
		return result;
	}

	public int getHeight() {
		return root.getHeight();
	}
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}
	public boolean isEmpty() {
		return (root == null);
	}
	public void clear() {
		root = null;
	}
}
