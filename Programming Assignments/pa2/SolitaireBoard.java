// Name: King Lun Au	
// USC loginid: kingluna	
// CSCI455 PA2
// Spring 2016
/*
   class SolitaireBoard
   The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
   by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
   for CARD_TOTAL that result in a game that terminates.
   (See comments below next to named constant declarations for more details on this.)
 */

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES
   
   public static final int MAX_PILES_NUMBER = CARD_TOTAL;
   // Set a maximum number of pile number to avoid users accidently input pile numbers that 
   // greater than CARD_TOTAL
   
   private int[] pilesArray = new int[CARD_TOTAL];
   // Create an array to store the piles from the index of 0 to number of piles - 1 
   
   /**
      Representation invariant:
      <put rep. invar. comment here>
    */
   
   // <add instance variables here>
   private int pilesNumber;
   private String numberString;
   private String PilesString;
   /**
     Initialize the board with the given configuration.
     PRE: SolitaireBoard.isValidConfigString(numberString)
     
     Write a method that generate a filled array, which get a string from the user initially.
     
     First, check if the Pre-condition is satisfied. 
     Then, create a array that with a maximum capacity of 
     
   */
   public SolitaireBoard(String numberString) { // Option 1:Take from user
	   	   assert isValidConfigString(numberString);  // Pre-condition
		   this.numberString = numberString;
		   Scanner in = new Scanner (this.numberString);
		   int currentSize = 0;
		   while(in.hasNextInt() && currentSize < pilesArray.length) 
		   {  
			   pilesArray[currentSize] = in.nextInt();
			   ++currentSize;
		   }	   
		   pilesNumber = currentSize;
		   assert isValidSolitaireBoard();  
   } 
		   
   /**
      Create a random initial configuration.
      
      Initially I create a empty array, then the method generate some random numbers from the 
      range of 1 to 45 in the first run. After the first run, that generated variable will be
      add into a value calls "sumSolt", it store all the random numbers that I generate. 
      Every index will assign into the array with their corresponding values. Finally, assign 
      the number of index is equal to "pilesNum" and leave for future use.
   */
   	public SolitaireBoard() { // Option 2: random numbers
   		int currentSize = 0;
   		int sum = 0;
   		Random randNumber = new Random();
   		int randomInt = randNumber.nextInt(CARD_TOTAL)+1; 
   		
   		while (sum < CARD_TOTAL )
   		{
   			if (randomInt != 0)
   			{
   				pilesArray[currentSize] = randomInt;
   				sum += randomInt;         
   				currentSize++;
   			}
   			
   			if (sum != CARD_TOTAL) // Check if the sum reach to maximum capacity (45 in this case)
   			{
   				randomInt = randNumber.nextInt(CARD_TOTAL - sum + 1); // If not, then the possible vale that can be generated would be reduced
   			}
   		}
   		pilesNumber = currentSize; 
   		assert isValidSolitaireBoard();  
   }
  
   /**
      Play one round of Bulgarian solitaire.  Updates the configuration according to the rules of Bulgarian
      solitaire: Takes one card from each pile, and puts them all together in a new pile.
    */
   public void playRound() 
   {
	   int counter = 0;
       int nonZeroCounter = 0;
	   int j;
       for (j = 0; j < pilesNumber; j++) 
       {
    	   pilesArray[j] = pilesArray[j]-1;
       }
       while (counter < pilesNumber)  
       {
           if (pilesArray[counter] != 0) 
           {
        	   pilesArray[nonZeroCounter] = pilesArray[counter];
               counter++;
               nonZeroCounter++;
           }
           else 
           {
               counter++;
           }
       }
       pilesNumber = nonZeroCounter;
	   pilesArray[pilesNumber] = j;
	   pilesNumber++;
	   assert isValidSolitaireBoard();
	   
   }
	   
   /**
      Return true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
    */
   
   public boolean isDone() {
	   
	   HashSet<Integer> hashArray= new HashSet<Integer>();
	   int i;
	   boolean flag = false;
	   if (pilesNumber != NUM_FINAL_PILES)
	   {
		   return false;
	   }
	   for (i = 0; i<pilesNumber; ++i)
	   {
		   flag = hashArray.add(pilesArray[i]); 
		   if(flag == false) // if there are any duplicated value, return false
		   { 
			   return false;
		   }
	   }
	   assert isValidSolitaireBoard();
	   return true;
	  
	  }
	   
   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
      
      Set a if, else statement within a for loop. 
    */
   
   public String configString() {
	   PilesString = new String(); // Can also be written as = ""
       for (int i = 0; i < pilesNumber; i++) 
       {
           if (i == 0) // For the first index, input the first element without + sign
           {
        	   PilesString = PilesString + pilesArray[i];
           }
           else // Input the other elements without adding + sign in the end
           {
        	   PilesString = PilesString + " " + pilesArray[i];
           }
       }
       assert isValidSolitaireBoard();
       return PilesString;   // dummy code to get stub to compile
      
   }
   
   
   /**
      Returns true iff configString is a space-separated list of numbers that
      is a valid Bulgarian solitaire board assuming the card total SolitaireBoard.CARD_TOTAL
   */
   
   
   
   
   public static boolean isValidConfigString(String configString) {
		  int index = 0; 
		  int temp;
		  Scanner in = new Scanner(configString);
	      String sumString = "";
	      int[] numArray = new int [CARD_TOTAL];
	      if(configString.length()<0 || configString.charAt(index) == ' ')  // Avoid negative numbers or empty
	      {
	    	  return false;
	      }
	      
	      while (in.hasNext() )
	      {
	    	  sumString = in.next();
	    	  
	    	  for(int i = 0; i< sumString.length(); i++)
	    	  {
	    		  if(! Character.isDigit(sumString.charAt(i))) // Avoid English or other characters
	    		  {
	    			  return false;
	    		  }
	    	  }
	    	  
	    	  if (index > MAX_PILES_NUMBER - 1)    // Avoid any piles numbers that is greater than 45
	    	  {
	    		  return false;
	    	  }
	    	  temp = Integer.valueOf(sumString); // Convert the string into a integer
	    	  numArray[index] = temp;
	    	  ++index; 
	      }
	      
	      return isValidConfiguration(numArray, index);
   }
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
    */
   
   
   private boolean isValidSolitaireBoard() { // Check for every run
	   
	   return isValidConfiguration(pilesArray, pilesNumber); 
   }
   
   private static boolean isValidConfiguration(int[] pilesArray, int pilesNumber) {
       int sum=0;  
       for (int i = 0; i < pilesNumber; i++) 
       {
           if (pilesArray[i] > 0) 
           {
               sum += pilesArray[i]; // If that is positive number , add into the sum
           } 
           else 
           {
        	   return false;
           }
       }
       if (sum != CARD_TOTAL) // Check if the sum of all the cards are equal to 45
       {
           return false;
       }
       
       return true;
   }
    // <add any additional private methods here>
   
   
}