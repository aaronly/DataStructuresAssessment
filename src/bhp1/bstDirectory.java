package bhp1;
/**
 *AE; A binary search tree based directory
 * @author Aaron Echols
 *
 * @param <T> A generic item that will be stored in the directory
 */
public class bstDirectory implements DirectoryInterface{

	//AE; initialize the binary search tree directory
	BinarySearchTree<DirectoryEntry> tree;
	
	public bstDirectory() {
		tree = new BinarySearchTree<DirectoryEntry>();
	}
	
	public void add(String firstName, String lastName, String email, String phone) {
		//AE; create a new directory entry based on the information given
		DirectoryEntry entry = new DirectoryEntry(firstName, lastName, phone, email);
		tree.add(entry);
	}

	public boolean remove(String firstName, String lastName) {
		//AE; create a new entry so that we can get the hash index on the name
		DirectoryEntry entry = new DirectoryEntry(firstName, lastName);
		return tree.remove(entry);
	}

	public DirectoryEntry lookup(String firstName, String lastName) {
		DirectoryEntry result = null;
		result = tree.getEntry(new DirectoryEntry(firstName, lastName));
		
		return result;
	}

	public void clear() {
		tree.clear();
	}

	public int getCount() {
		return tree.getNumberOfNodes();
	}

	public boolean isEmpty() {
		return tree.isEmpty();
	}

	public DirectoryEntry[] toArray() {
		if (tree.isEmpty()) return null; //AE; return null if the directory is empty
		DirectoryEntry[] finalList = new DirectoryEntry[getCount()]; //AE; create an array for directory entries
		
		BinaryNodeInterface<DirectoryEntry> rootNode = tree.getRootNode();
		toArrayTraverse(rootNode, finalList, 0);
		
		return finalList;
	}

	/**
	 *AE; Traverse the directory tree in order and add the nodes to an array
	 * @param node the root node to being traversing
	 * @param array an array of directory entries to add nodes to
	 * @param index a running index that increases when each node is added to the array
	 * @return
	 */
	private int toArrayTraverse(BinaryNodeInterface<DirectoryEntry> node, DirectoryEntry[] array, int index) {
		//AE; if the node has a left child, traverse the left child node
		if (node.hasLeftChild()) {
			index = toArrayTraverse(node.getLeftChild(), array, index);
		}
		//AE; if the node has a right child, traverse the right child node
		if (node.hasRightChild()) {
			//AE; since we want nodes in order, add the root node before traversing the right tree
			array[index] = node.getData();
			index++; //AE; increase the index
			//AE; traverse the right child node
			index = toArrayTraverse(node.getRightChild(), array, index);
		}
		//AE; if node is a leaf, add the node to the array and increase the index
		else {
			array[index] = node.getData();
			index++;
		}
		return index;
	}
}
