// Name: King Lun Au
// USC loginid: kingluna
// CSCI455 PA2
// Spring 2016


/**
   <add main program comment here>
 */

import java.util.Scanner;


public class BulgarianSolitaireSimulator {

	public static void main(String[] args) {

		boolean singleStep = false;
		boolean userConfig = false;

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-u")) {  // Type the numbers
				userConfig = true;
			}
			else if (args[i].equals("-s")) {  // Generate random numbers
				singleStep = true;
			}
		}

		// <add code here>	
		
		SolitaireBoard oneBoard;
		if(userConfig != true){ // If the user is not clicked the "-u"(typing), then the program goes to generate numbers 
			oneBoard = new SolitaireBoard();
		}
		else{ // The user wants to type
			oneBoard = new SolitaireBoard(typeString());
		}
		runOneTime(oneBoard, singleStep);
	}

	// <add private static methods here>

	private static String typeString(){
		String configString = "";
		Boolean tester = false;
		Scanner in = new Scanner(System.in);
		System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
		System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).);" );
		System.out.println("Please enter a space-separated list of positive" + " integers followed by newline:");
		while(!tester){  
			configString = in.nextLine();
			System.out.println("ERROR: Each pile must have at least one" + " card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL);
			tester = SolitaireBoard.isValidConfigString(configString);
			if(!tester) 
			{
				System.out.println("Please enter a space-separated list of positive" + " integers followed by newline:");
			}
		}
		return configString;
	    }
	
	private static void runOneTime (SolitaireBoard oneBoard, Boolean singleStep){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Initial configuration: " + oneBoard.configString());
		int index = 1; 
		while (!oneBoard.isDone()) 
		{
			oneBoard.playRound();
			System.out.println("[" + index + "] " + "Current configuration: " + oneBoard.configString());
			if(singleStep){
				System.out.println("<Type return to continue>");
				in.nextLine();
			}
			index++;
		}
		if (oneBoard.isDone()){
			System.out.println("Done!");
		 }
	 }
}