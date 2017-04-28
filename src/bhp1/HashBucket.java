package bhp1;
/**
 *AE; A hash bucket class that uses a sorted list of linked nodes for storing entries
 * @author Aaron Echols
 *
 * @param <T> A class that is comparable that will be stored in the hash bucket
 */
public class HashBucket<T extends Comparable<? super T>>
		implements SortedListInterface<T> {

	/**
	 *AE; the reference to the first node in the linked chain
	 */
	private Node firstNode;
	/**
	 *AE; the number of nodes in the linked chain
	 */
	private int numberOfNodes;

	/**
	 *AE; Create a new, empty hash bucket
	 */
	public HashBucket()
	{
		firstNode = null;
		numberOfNodes = 0;
	}
	
	/**
	 *AE; Get the node before the object given
	 * @param entry the object to check against
	 * @return the node that is before the node that contains the object given, null if object should be at the beginning
	 */
	private Node getNodeBefore(T entry)
	{	
		Node currentNode = firstNode;
		Node nodeBefore = null;
		//AE; while the new entry is bigger than the current node and we are not at the end of the chain
		while ( currentNode !=null && entry.compareTo(currentNode.getData()) > 0 )
		{
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		return nodeBefore;
	}
	
 	public void add(T entry)
	{
		Node newNode = new Node(entry); //AE; the node to add
		Node nodeBefore = getNodeBefore(entry); //AE; the node before the one to add
		//AE; if the list is empty or the new node should be at the beginning
		if (isEmpty() || nodeBefore == null)
		{
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		}
		else //AE; otherwise add the new node after nodeBefore
		{
			Node nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		}
		numberOfNodes++;
	}
	
	public boolean remove(T entry)
	{
		boolean inBucket = contains(entry);
		Node nodeBefore = getNodeBefore(entry);

		 //AE; object is the first object
		if (nodeBefore == null && inBucket) {
			firstNode = firstNode.getNextNode();
			numberOfNodes--;
			return true;
		}
		//AE; object is in the list
		else if (nodeBefore != null && inBucket)
		{
			Node currentNode = nodeBefore.getNextNode();
			nodeBefore.setNextNode(currentNode.getNextNode());
			numberOfNodes--;
			return true;
		}
		
		else //AE; object is not in the list
			return false;
	}
	
	public T getEntry(int position)
	{
		Node currentNode = firstNode;
		
		if(position < 1 || position > numberOfNodes || currentNode == null)
			return null;

		for (int i = 1; i < position; i++)
		{
			currentNode = currentNode.getNextNode();
		}
		return currentNode.getData();
	}
	
	public T remove(int position)
	{
		T entry = getEntry(position);
		if (entry != null)
		{
			remove(entry);
			return entry;
		}
		else
			return null;
	}

	public int getPosition(T entry)
	{
		int pos = 1;
		Node currentNode = firstNode;
		
		while (currentNode != null && entry.compareTo(currentNode.getData()) > 0)
		{
			currentNode = currentNode.getNextNode();
			pos++;
		}
		
		int found = 1;
		//AE; check if we are at the end of the chain, or if we actually found the entry
		if (currentNode == null || !entry.equals(currentNode.getData())) found = -1;
		
		return pos * found;
	}

	public boolean contains(T entry)
	{
		Node currentNode = firstNode;
		while (currentNode != null && entry.compareTo(currentNode.getData()) > 0)
		{
			currentNode = currentNode.getNextNode();
		}
		
		return currentNode != null && entry.equals(currentNode.getData());
	}
	
	public boolean isEmpty()
	{
		if (numberOfNodes == 0)
			return true;
		else
			return false;
	}
	
	public void clear()
	{
		numberOfNodes = 0;
		firstNode = null;
	}
	
	public int getLength()
	{
		return numberOfNodes;
	}
	
	public T[] toArray() {	
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Comparable[numberOfNodes];
		int index = 0;
		Node currentNode = firstNode;
		while (index < numberOfNodes && currentNode != null)
		{
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result;
	}
	
	/**
	 *AE; A node in the sorted linked chain
	 * @author Aaron Echols
	 *
	 */
	private class Node
	{
		private T data; //AE; the data contained in the node
		private Node next; //AE; reference to the next node in the chain
		
		private Node(T newData)
		{
			this(newData, null);
		}
		private Node(T newData, Node nextNode)
		{
			data = newData;
			next = nextNode;
		}
		/**
		 *AE; Retrieve the data at the node
		 * @return the data at the node
		 */
		private T getData()
		{
			return data;
		}
		/**
		 *AE; Set the data at the node
		 * @param newData the new data to set at the node
		 */
		@SuppressWarnings("unused")
		private void setData(T newData)
		{
			data = newData;
		}
		/**
		 *AE; Retrieve the next node in the chain
		 * @return the next node in the chain, null if node is the end of the chain
		 */
		private Node getNextNode()
		{
			return next;
		}
		/**
		 *AE; Set the next node in the chain
		 * @param nextNode the next node in the chain
		 */
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		}
	}

}
