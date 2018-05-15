// Name: King Lun Au
// USC loginid: kingluna
// CS455 PA1
// Spring 2016

/**
Drunkard class
    Represents a "drunkard" doing a random walk on a grid.
*/

import java.util.Random; 

public class Drunkard { 
    private ImPoint startLoc;
    private int theStepSize;
    private Random randnum;
    private final static int NUMBER_DIRECTIONS = 4;
    private final static int NORTH = 0;
    private final static int SOUTH = 1;
    private final static int EAST = 2;
    private final static int WEST = 3;
/**
    Creates drunkard with given starting location and distance
    to move in a single step.
    @param startLoc starting location of drunkard
    @param theStepSize size of one step in the random walk
 */
	
    public Drunkard(ImPoint startLoc, int theStepSize) 
    { 
      this.startLoc = startLoc;
      this.theStepSize = theStepSize;   
      randnum = new Random();   
    }
   
 /**
    Takes a step of length step-size (see constructor) in one of
    the four compass directions.  Changes the current location of the
    drunkard.
 */
 
    public void takeStep() {
      
      int nextDirection = randnum.nextInt(NUMBER_DIRECTIONS); //Generate a direction from 0,1,2,3 

      if(nextDirection == NORTH) { 
        startLoc = startLoc.translate(0, theStepSize); 
      } 
      else if(nextDirection == SOUTH) { 
    	startLoc = startLoc.translate(0, (-theStepSize)); 
      } 
      else if(nextDirection == EAST) { 
        startLoc = startLoc.translate(theStepSize, 0);
      } 
      else if(nextDirection == WEST) { 
    	startLoc = startLoc.translate((-theStepSize), 0);
      }
    }

 /**
    gets the current location of the drunkard.
    @return an ImPoint object representing drunkard's current location
 */
    public ImPoint getCurrentLoc() { 
    	return new ImPoint(startLoc.getX(), startLoc.getY());
    }

}
