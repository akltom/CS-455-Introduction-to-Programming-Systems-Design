// Name: King Lun
// USC loginid: kingluna	
// CS 455 PA4
// Spring 2016

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Map;
import java.io.PrintWriter;

   /**
      Random TextGenerator class
     
      This contains most of the program logic and data structures, and two methods. I create it with 
      some form of the source text and other arguments. Then it has another method to generate random text 
      from that source.
*/

public class RandomTextGenerator {
	/**
	   Representation invariant:
	  -the keys(Prefix) in text are unique
	  -numWords >= 0
	  -prefixLength >=1
	  -prefixLength < number of words in sourceFile
	 */
	
    /**
	   Private instance variable
    */
	
	private Map<Prefix, ArrayList<String>> prefixMap;
	private ArrayList<String> successorArrayList;
	private Random rand;
	private int prefixLength;
	private int numWords;
	private boolean isDebugMode;
	private String lastPrefix;

	public RandomTextGenerator(String lastPrefix, Map<Prefix, ArrayList<String>> prefixMap, int prefixLength, int numWords, boolean isDebugMode) {
		this.lastPrefix = lastPrefix;
		this.prefixMap = prefixMap;		
		this.prefixLength = prefixLength;
		this.numWords = numWords;
		this.isDebugMode = isDebugMode;
		successorArrayList = new ArrayList<String>();
		if (isDebugMode == false) { // Regular Mode
			rand = new Random();
		}
		else { // Debug Mode
			rand = new Random(1);
		}
	}
	
	/**
	   Generate a random Prefix from the prefix map.
	   First, get all the keys from the prefix map. Then, randomly select a index of prefix. Use iterator
	   to go through the set and find that Prefix location, and finally return that Prefix.
	   @return the generated Prefix
    */
	
	public Prefix generatePrefix()
	{
		int i = 0;   
		Prefix prefix = new Prefix(); 
		Set<Prefix> prefixSet = prefixMap.keySet(); // Get the keys from the map and put it into a set
		Iterator<Prefix> iter = prefixSet.iterator();
		int prefixIndex = rand.nextInt(prefixSet.size()); // Randomly generate a index of prefix
		while (i <= prefixIndex && iter.hasNext()) { // Go through the set until we are in the location of that index
			prefix = iter.next();
			i++;
		} 
		return prefix;
	}
		
	/**
	   Take a prefix and generate it's successor each time. For each successor that we generate, we store into 
	   a temporary array, and return it in the end.
	   If we are in the debug mode, we print out the debug statements.
	   @return a array list that contains all the successors that we generate
	*/
	
	public ArrayList<String> generateRandomText(int numWords, PrintWriter writefile) { 
		Prefix prefix = this.generatePrefix();
		for(int j=0; j <= numWords-1;j++) { // Keep running until we reach to the user input 
			ArrayList<String> successors = prefixMap.get(prefix);
			int successorIndex = rand.nextInt(successors.size());
			String successorName = successors.get(successorIndex);
			successorArrayList.add(successorName); // Add the successor into the temporary array list
			if (isDebugMode == true) {
				System.out.println("DEBUG: chose a new initial prefix: " + prefix.toString());
				System.out.println("DEBUG: prefix:" + prefix.toString());
				System.out.print("DEBUG: successors: ");
				for(int i = 0; i < successors.size(); i++) {
					System.out.print(successors.get(i) + " ");
				}
				System.out.println("");
				System.out.println("DEBUG: word generated: " + successorName);
			}
			Prefix tempNewPrefix = prefix.shiftOut(); 
			prefix = tempNewPrefix.shiftIn(successorName); // Update the prefix with the previous successor
			if (prefix.toString().equals(lastPrefix)) { // Check if we are in the last prefix
				prefix = this.generatePrefix();   // If is, generate a random new prefix
				if(isDebugMode == true ) {
					System.out.println("DEBUG: successors: <END OF FILE>"); 
				}
			}
		 }
	return successorArrayList;
	}
}
