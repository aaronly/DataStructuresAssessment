package bhp1;

public class DirectoryPrototypes {

	public static void main(String[] args) {
		System.out.println(" ---------- Testing hash based directory ---------- ");
		System.out.println();
		testHashDirectory();
		System.out.println();

		System.out.println(" ---------- Testing tree based directory ---------- ");
		System.out.println();
		testTreeDirectory();
	}
	
	/**
	 *AE; Test the tree table based directory prototype
	 */
	private static void testTreeDirectory() {
		bstDirectory directory = new bstDirectory(); //AE; create a new binary search tree directory
		
		System.out.println("Test Case 1: Adding Bob Smith...");
		directory.add("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		
		System.out.println("Test Case 2: Adding Jane Williams...");
		directory.add("Jane", "Williams", "555-235-1112", "jw@something.com");
		
		System.out.println("Test Case 3: Adding Mohammed al-Salam...");
		directory.add("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		
		System.out.println("Test Case 4: Adding Pat Jones...");
		directory.add("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		
		System.out.println("Test Case 5: Adding Billy Kidd...");
		directory.add("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		
		System.out.println("Test Case 6: Adding H. Houdini...");
		directory.add("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
		
		System.out.println("Test Case 7: Adding Jack Jones...");
		directory.add("Jack", "Jones", "555-235-1117", "jjones@hill.com");
		
		System.out.println("Test Case 8: Adding Jill Jones...");
		directory.add("Jill", "Jones", "555-235-1118", "jillj@hill.com");
		
		System.out.println("Test Case 9: Adding John Doe...");
		directory.add("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		
		System.out.println("Test Case 10: Adding Jane Doe...");
		directory.add("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		
		System.out.println("Test Case 11: Finding Pat Jones...");
		DirectoryEntry entry = directory.lookup("Pat", "Jones");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    No result found.");
		
		System.out.println("Test Case 12: Finding Billy Kidd...");
		entry = directory.lookup("Billy", "Kidd");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    No result found.");
		
		System.out.println("Test Case 13: Deleting John Doe...");
		if (directory.remove("John", "Doe")) System.out.println("    Success");
		else System.out.println("    Failure");
		
		System.out.println("Test Case 14: Adding Test Case...");
		directory.add("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		
		System.out.println("Test Case 15: Adding Nadezhda Kanachekhovskaya...");
		directory.add("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		
		System.out.println("Test Case 16: Adding Jo Wu...");
		directory.add("Jo", "Wu", "555-235-1123", "wu@h.com");
		
		System.out.println("Test Case 17: Adding Millard Fillmore...");
		directory.add("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.com");
		
		System.out.println("Test Case 18: Adding Bob vanDyke...");
		directory.add("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		
		System.out.println("Test Case 19: Adding Upside Down...");
		directory.add("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		
		System.out.println("Test Case 20: Finding Jack Jones...");
		entry = directory.lookup("Jack", "Jones");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    No result found.");
		
		System.out.println("Test Case 21: Finding Nadezhda Kanachekhovskaya...");
		entry = directory.lookup("Nadezhda", "Kanachekhovskaya");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    No result found.");
		
		System.out.println("Test Case 22: Deleting Jill Jones...");
		if (directory.remove("Jill", "Jones")) System.out.println("    Success");
		else System.out.println("    Failure");
		
		System.out.println("Test Case 23: Deleting John Doe...");
		if (directory.remove("John", "Doe")) System.out.println("    Success");
		else System.out.println("    Failure");
		
		System.out.println("Test Case 24: Finding Jill Jones...");
		entry = directory.lookup("Jill", "Jones");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    Not Found");
		
		System.out.println("Test Case 25: Finding John Doe...");
		entry = directory.lookup("John", "Doe");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    Not Found");

	}
	
	/**
	 *AE; Test the hash table based directory prototype
	 */
 	private static void testHashDirectory() {
		HashDirectory directory = new HashDirectory(13); //AE; create a new hash table with 13 buckets
		
		System.out.println("Test Case 1: Adding Bob Smith...");
		directory.add("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		
		System.out.println("Test Case 2: Adding Jane Williams...");
		directory.add("Jane", "Williams", "555-235-1112", "jw@something.com");
		
		System.out.println("Test Case 3: Adding Mohammed al-Salam...");
		directory.add("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		
		System.out.println("Test Case 4: Adding Pat Jones...");
		directory.add("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		
		System.out.println("Test Case 5: Adding Billy Kidd...");
		directory.add("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		
		System.out.println("Test Case 6: Adding H. Houdini...");
		directory.add("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
		
		System.out.println("Test Case 7: Adding Jack Jones...");
		directory.add("Jack", "Jones", "555-235-1117", "jjones@hill.com");
		
		System.out.println("Test Case 8: Adding Jill Jones...");
		directory.add("Jill", "Jones", "555-235-1118", "jillj@hill.com");
		
		System.out.println("Test Case 9: Adding John Doe...");
		directory.add("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		
		System.out.println("Test Case 10: Adding Jane Doe...");
		directory.add("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		
		System.out.println("Test Case 11: Finding Pat Jones...");
		DirectoryEntry entry = directory.lookup("Pat", "Jones");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    No result found.");
		
		System.out.println("Test Case 12: Finding Billy Kidd...");
		entry = directory.lookup("Billy", "Kidd");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    No result found.");
		
		System.out.println("Test Case 13: Deleting John Doe...");
		if (directory.remove("John", "Doe")) System.out.println("    Success");
		else System.out.println("    Failure");
		
		System.out.println("Test Case 14: Adding Test Case...");
		directory.add("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		
		System.out.println("Test Case 15: Adding Nadezhda Kanachekhovskaya...");
		directory.add("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		
		System.out.println("Test Case 16: Adding Jo Wu...");
		directory.add("Jo", "Wu", "555-235-1123", "wu@h.com");
		
		System.out.println("Test Case 17: Adding Millard Fillmore...");
		directory.add("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.com");
		
		System.out.println("Test Case 18: Adding Bob vanDyke...");
		directory.add("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		
		System.out.println("Test Case 19: Adding Upside Down...");
		directory.add("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		
		System.out.println("Test Case 20: Finding Jack Jones...");
		entry = directory.lookup("Jack", "Jones");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    No result found.");
		
		System.out.println("Test Case 21: Finding Nadezhda Kanachekhovskaya...");
		entry = directory.lookup("Nadezhda", "Kanachekhovskaya");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    No result found.");
		
		System.out.println("Test Case 22: Deleting Jill Jones...");
		if (directory.remove("Jill", "Jones")) System.out.println("    Success");
		else System.out.println("    Failure");
		
		System.out.println("Test Case 23: Deleting John Doe...");
		if (directory.remove("John", "Doe")) System.out.println("    Success");
		else System.out.println("    Failure");
		
		System.out.println("Test Case 24: Finding Jill Jones...");
		entry = directory.lookup("Jill", "Jones");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    Not Found");
		
		System.out.println("Test Case 25: Finding John Doe...");
		entry = directory.lookup("John", "Doe");
		if (entry != null) System.out.println("    " + entry.toString());
		else System.out.println("    Not Found");

	}

}
