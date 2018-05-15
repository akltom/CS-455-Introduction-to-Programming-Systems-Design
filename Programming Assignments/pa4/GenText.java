// Name: King Lun
// USC loginid: kingluna	
// CS 455 PA4
// Spring 2016

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;

   /**
      GenText class

      This contains the main method. This class will have a main that's responsible for processing the 
      command-line arguments, opening and closing the files, and handling any errors related to the above 
      tasks. All the other functionality will be delegated to other object(s) created in main and their 
      methods.
   */



public class GenText {
	
    /**
       Global Constants
    */
	public static final int DEBUG_MODE = 5; // In debug mode, the length of the input is 5
	public static final int REGULAR_MODE = 4; // In regular mode, the length of the input is 4
	public static final int MINIMUM_NUM_WORDS = 0;
	public static final int MINIMUM_PREFIX_LENGTH = 1;
	public static final int MAXIMUM_CHARACTER_PERLINE = 80;
	
	/**
	   Representation invariant:
	  -the keys(Prefix) in text are unique
	  -numWords >= 0
	  -prefixLength >=1
	  -prefixLength < number of words in sourceFile
	 */
	
   /**
      Instance variables
   */
	
	private static boolean isDebugMode;
	private static int debugModeIndex; 
	private static int prefixLength;
	private static int numWords;
	private static int numWordsSourceFile;
	private static String sourceFileName;
	private static String outFileName;
	private static String lastPrefixString;
	private static ArrayList<String> wordsSampleArray;
	private static Map<Prefix, ArrayList<String>> hashMap;
	
	public static void main(String[] args)  {
		try {
			checkCommandArgument(args);
			sourceFileName = args[debugModeIndex + 2];
			readSourceFile (sourceFileName);		
			checkCommandValue();
			getLastPrepix();
			buildHashMap();
			outFileName = args[debugModeIndex + 3 ];
			writeOutputFile (outFileName);
		}
		catch (CommandErrorException exception) {
			System.out.println(exception.getMessage() );
		}
		catch (FileNotFoundException exception) {
			System.out.println("ERROR: The source file does not exist");
		}
		catch (IOException exception){			
			System.out.println("Can't write to output file");
		}
	}
	
	/**
		Take the string that user inputs, check the command argument related errors, and throw an 
		exception to the main if there is any command error.
		
		Initialize the contents based on the input values and the debug status, and throw an exception if
		prefixLength or numWords arguments are not integers.
	*/
	private static void checkCommandArgument(String[] args) throws CommandErrorException, IOException {
		if (args.length < REGULAR_MODE || args.length > DEBUG_MODE){ // Check if the length of the input array is too many or too few
			throw new CommandErrorException("ERROR: missing or too many command-line arguments");
		}
		if (args.length == DEBUG_MODE && !args[0].equals("-d") ){ // Check if the user types -d currently in debug mode
			throw new CommandErrorException("ERROR: Invalid command option, debug mode should be " + "-d");
		}
		if (args.length == REGULAR_MODE && args[0].equals("-d")  ){ // Check if the user types -d, but with a command length of 4, (Missing one argument, should be 5 for debug mode )
			throw new CommandErrorException("ERROR: missing command-line arguments");
		}
		else{
			if (args.length == DEBUG_MODE) { // Debug Mode (length = 5)
				debugModeIndex = 1; // In debug mode, the starting index is 1 in the input array
				isDebugMode = true;
			}
			else { // Regular Mode (length = 4)
				debugModeIndex = 0; // In regular mode, the starting index is 0 in the input array
				isDebugMode = false;
			}
			try {
				prefixLength = Integer.parseInt(args[debugModeIndex]);
				numWords = Integer.parseInt(args[debugModeIndex + 1]);
			}
			catch (NumberFormatException exception) {  
				System.out.println("ERROR: prefixLength or numWords arguments are not integers"); 
				System.exit(0);
			}
		}
		
	}
	
	/**
    	Read the input source file, and store the words into a new array list.
    	
    	If the input file is not found, throw an exception to the main to catch the error.
    */
	
	private static void readSourceFile (String sourceFileName) throws FileNotFoundException {
		File sourceFile = new File(sourceFileName);
		Scanner in = new Scanner(sourceFile);
		wordsSampleArray = new ArrayList<String>();
		while (in.hasNext()) {
			wordsSampleArray.add(in.next()); // Fill in the array with contents of strings
		}
		numWordsSourceFile = wordsSampleArray.size();
		in.close();
	}
	
	/**
		Check if the values of the input are matched with the requirements, throw an exception if any of the 
		input value does not matched.
	*/
	
	private static void checkCommandValue() throws CommandErrorException {
		if(numWords < MINIMUM_NUM_WORDS){
			throw new CommandErrorException("ERROR: numWords must be equal or greater than 0");
		}
		if(prefixLength < MINIMUM_PREFIX_LENGTH){
			throw new CommandErrorException("ERROR: prefixLength must be equal or greater than 1");
		}
		if(prefixLength >= numWordsSourceFile){ 
			throw new CommandErrorException("ERROR: prefixLength must be less than the number of words in sourceFile");
		}
		
	}
	
	/**
		Generate the last prefix in the list.
	*/
	
	private static void getLastPrepix() {
		int lastPrefixIndex= numWordsSourceFile - prefixLength;
		String lastStr = "";
		int k = 0;
		for (k = lastPrefixIndex; k < wordsSampleArray.size() - 1; k++) {
			lastStr += wordsSampleArray.get(k) + " ";
		}
		lastStr += wordsSampleArray.get(k);
		lastPrefixString = lastStr;
	}
	
	/**
		Initialize the hash map with prefixes with their corresponding successors.
	*/
	
	private static void buildHashMap() {
		hashMap = new HashMap <Prefix, ArrayList<String>>(); 
		for(int index = 0; index < numWordsSourceFile-prefixLength; index++) { 
			Prefix prefix = new Prefix();
		    prefix.addPrefix(wordsSampleArray,index,prefixLength);
		    String successor = wordsSampleArray.get(index + prefixLength); // Return a successor with the corresponding prefix
		    ArrayList<String> successorsForOnePrefix; // Create a array list to store the successors
		    if(hashMap.containsKey(prefix)) { // Check if this prefix is already existed in the map key
		    	successorsForOnePrefix = hashMap.get(prefix); // Take the existed successors array list of this prefix
		    }
		    else  { // If the prefix is not currently inside the map key
		    	successorsForOnePrefix = new ArrayList<String>(); // Create a new array list so that we can add successors for this prefix 
		    }
		    successorsForOnePrefix.add(successor); 
		    hashMap.put(prefix, successorsForOnePrefix);  // Update the change in the map 
		}
		
	}
	
	/**
		Take the generated array list that contains a list of successors, and put them into a output text file 
		for displaying.
	*/
	private static void writeOutputFile (String outFileName) throws IOException {
		PrintWriter writefile = new PrintWriter(outFileName);
		RandomTextGenerator textGen = new RandomTextGenerator(lastPrefixString, hashMap, prefixLength, numWords, isDebugMode);
		ArrayList<String> outputArrayText = textGen.generateRandomText(numWords, writefile);
		int counter = 0;
		for (int i = 0; i< outputArrayText.size(); ++i) {
			String successorName = outputArrayText.get(i);
		    counter += (successorName.length() + 1);
		    if (counter > MAXIMUM_CHARACTER_PERLINE ) { // Check if the current line has more than 80 characters
		    	writefile.println(); // Go to the next line
		   		counter = 0; // Reset the counter to 80, so we can count the new line
		   		counter += (successorName.length() + 1); 
		    }
		    writefile.print(successorName + " ");
		}
		writefile.flush();
		writefile.close();
	}
	
}      
		
	

		
			
		

