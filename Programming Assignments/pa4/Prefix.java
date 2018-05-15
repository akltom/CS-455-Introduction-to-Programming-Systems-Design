// Name: King Lun
// USC loginid: kingluna	
// CS 455 PA4
// Spring 2016

import java.util.ArrayList;

   /**
      Prefix class

      This corresponds to the idea of a prefix in the problem description. That is, a sequence of words 
      that use as a basis to choose the next word to generate. This sequence consists of the prefixLength 
      previous words I have just generated. 
   */

public class Prefix {
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

	private ArrayList<String> prefixArrayList;
	
	/**
		Returns a new Prefix that contains an empty array list.
		@return an Prefix
	*/
	
	public Prefix() {
		prefixArrayList = new ArrayList<String>();
	}
	
	/**
		Returns an existed Prefix that contains an array list.
		@return an existed Prefix
	*/
	
	public Prefix(ArrayList<String> arrayList) {
		prefixArrayList = arrayList;
	}
	
	/**
		Returns the prefix as a string, given the index of that prefix.
		@return an Prefix in string form
	*/
	public String get(int index) {
		return prefixArrayList.get(index); // return the prefix that we generate from the array list
	}
	
	/**
	   Add a new prefix into the array list to store.
    */

	public void addPrefix(ArrayList<String> wordSampleArrayList, int wordIndex, int preLength) {
		for(int i = wordIndex; i < wordIndex + preLength;i++) {
			prefixArrayList.add(wordSampleArrayList.get(i)); 
		}
	}
	
	/**
		Check if these two objects are the same or not.
		@return an true or false
	*/
	
	public boolean equals(Object anotherObject) {
		if (anotherObject == null) { // Check if another object is empty
			return false;
		}
		else if (!(anotherObject instanceof Prefix)) { // Check if they are the same type
			return false;	
		}
		Prefix previObject = (Prefix) anotherObject;
		boolean determine = toString().equals(previObject.toString());
		return determine;
	}
		
	/**
	   Re-define the hash map for Prefix.
	   @return the hash code integer
	*/
	public int hashCode(){    
		return toString().hashCode();
	}

	/**
	   Return the size of the prefix array list.
	   @return the size of the prefix array list
	*/
	public int size() {
		   return prefixArrayList.size();
	}
	
	/**
	   Go through the for loop of the prefix array list, return the string of the Prefixes 
	   @return the String of the Prefixes
	*/
	
	public String toString() {
		int i;
		String outputString = "";
		for(i = 0; i < prefixArrayList.size() - 1; i++) { // Print the first to the second last elements
			outputString = outputString + prefixArrayList.get(i) + " ";
		}
		outputString = outputString + prefixArrayList.get(i); // Print the last element
		return outputString;
	}	
	
	
	/**
	   Input a word and put into the end of this Prefix, generate a new word based on the previous.
	   @return the Prefix that has been modified
	*/
	
	public Prefix shiftIn(String nextWord) {
		ArrayList<String> nextPrefixList = new ArrayList<String>();
		for(int i = 0; i < prefixArrayList.size(); i++) {  
			nextPrefixList.add(prefixArrayList.get(i));	  
		}
		nextPrefixList.add(nextWord); // Add the new element into the local array
		Prefix newPrefix = new Prefix(nextPrefixList);
		return newPrefix;	
	}
	
	
	/**
	   Take out the first word of this Prefix, generate a new word based on the previous.
	   @return the Prefix that has been modified
    */
	
	public Prefix shiftOut(){
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i<prefixArrayList.size(); ++i) {
			temp.add(prefixArrayList.get(i));
		}
		temp.remove(0);
		Prefix renewPrefix = new Prefix (temp);
		return renewPrefix;
	}
		
}
