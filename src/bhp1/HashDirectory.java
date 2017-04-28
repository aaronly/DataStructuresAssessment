package bhp1;
/**
 *AE; A hash table-based directory
 * @author Aaron Echols
 *
 * @param <T> A generic item that will be stored in the directory
 */
public class HashDirectory implements DirectoryInterface{

	/**
	 *AE; the default bucket count if none is supplied
	 */
	private static final int DEFAULT_BUCKET_COUNT = 13;
	/**
	 *AE; an array of hash table buckets containing directory entries
	 */
	private HashBucket<DirectoryEntry>[] hashTable;
	/**
	 *AE; the number of buckets in the hash table directory
	 */
	private int numberOfBuckets;
	/**
	 *AE; the number of entries in the directory
	 */
	private int numberOfEntries;

	/**
	 *AE; Create a hash table directory with a given number of buckets
	 * @param numberOfBuckets the number of buckets to create the hash table with
	 */
	public HashDirectory(int count)
	{
		numberOfBuckets = count;
		clear();
	}
	/**
	 *AE; Create a hash table directory with the default bucket count if none was given
	 */
	public HashDirectory()
	{
		this(DEFAULT_BUCKET_COUNT);
	}
	
	public void add(String firstName, String lastName, String phone, String email) {
		//AE; create a new directory entry based on the information given
		DirectoryEntry entry = new DirectoryEntry(firstName, lastName, phone, email);
		//AE; find the bucket index based on the hash code and bucket count
		int index = entry.hashCode() % numberOfBuckets;
		//AE; add the person directory entry to the directory
		hashTable[index].add(entry);
		numberOfEntries++;
	}

	public boolean remove(String firstName, String lastName) {
		//AE; create a new entry so that we can get the hash index on the name
		DirectoryEntry entry = new DirectoryEntry(firstName, lastName);
		//AE; get the bucket where that name would be found
		HashBucket<DirectoryEntry> bucket = getBucket(entry);
		
		return bucket.remove(entry);
	}

	public DirectoryEntry lookup(String firstName, String lastName) {
		//AE; create a new entry so that we can get the hash index on the name
		DirectoryEntry entry = new DirectoryEntry(firstName, lastName);
		//AE; get the bucket where that name would be found
		HashBucket<DirectoryEntry> bucket = getBucket(entry);
		//AE; find the position of the entry that has a matching name
		int position = bucket.getPosition(entry);
		//AE; get the entry in the has bucket
		DirectoryEntry foundEntry = bucket.getEntry(position);
		
		return foundEntry;
	}
	
	/**
	 *AE; Get the bucket based on the name of the person to find
	 * @param firstName the first name of the person to find
	 * @param lastName the last name of the person to find
	 * @return the hash bucket that name would be found in
	 */
	private HashBucket<DirectoryEntry> getBucket(DirectoryEntry entry) {
		//AE; get the bucket index based on the hash code and number of buckets
		int bucketIndex = entry.hashCode() % numberOfBuckets;
		//AE; get the bucket where the entry is 
		HashBucket<DirectoryEntry> bucket = hashTable[bucketIndex];
		
		return bucket;
	}

	@SuppressWarnings("unchecked") //AE; this is safe since we setting all values to null
	public void clear() {
		numberOfEntries = 0; //AE; set number of entries to zero
		//AE; initialize a new hashTable (this is full of null entries)
		hashTable = new HashBucket[numberOfBuckets];
		//AE; for each bucket, initialize a new hash bucket
		for(int i = 0; i < numberOfBuckets; i++) {
			hashTable[i] = new HashBucket<DirectoryEntry>();
		}		
	}

	public int getCount() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		if (numberOfEntries == 0)
			return true;
		else
			return false;
	}

	public DirectoryEntry[] toArray() {
		if (numberOfEntries == 0) return null; //AE; return null if the directory is empty
		DirectoryEntry[] finalList = new DirectoryEntry[numberOfEntries]; //AE; create an array for directory entries
		
		int i = 0;
		//AE; loop through each bucket
		for(int b = 0; b < numberOfBuckets; b++) {
			//AE; get all the items from that bucket
			Comparable<DirectoryEntry>[] tempList = hashTable[b].toArray();
			//AE; loop through each entry returned
			for(int e = 0; e < tempList.length; e++) {
				finalList[i] = (DirectoryEntry)tempList[e]; //AE; add it to the final array
				i++; //AE; increment the counter
			}
		}
		return finalList;
	}

}
