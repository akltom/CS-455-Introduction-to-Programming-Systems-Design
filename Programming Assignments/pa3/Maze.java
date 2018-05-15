// Name: King Lun Au
// USC loginid: kingluna
// CS 455 PA3
// Spring 2016

import java.util.LinkedList;


/**
   Maze class

   Stores information about a maze and can find a path through the maze
   (if there is one).

   Assumptions about structure of the maze, as given in mazeData, startLoc, and endLoc
   (parameters to constructor), and the path:
     -- no outer walls given in mazeData -- search assumes there is a virtual 
        border around the maze (i.e., the maze path can't go outside of the maze
        boundaries)
     -- start location for a path is maze coordinate startLoc
     -- exit location is maze coordinate exitLoc
     -- mazeData input is a 2D array of booleans, where true means there is a wall
        at that location, and false means there isn't (see public FREE / WALL 
        constants below) 
     -- in mazeData the first index indicates the row. e.g., mazeData[row][col]
     -- only travel in 4 compass directions (no diagonal paths)
     -- can't travel through walls
*/

public class Maze 
{
	   
	   public static final int START_SEARCH_COL = 0;
	   public static final int START_SEARCH_ROW = 0;
	   
	   public static final boolean FREE = false;
	   public static final boolean WALL = true;

	   private final boolean[][] initMazeData;
	   private final boolean[][] visitData;
	   
	   private LinkedList<MazeCoord> onePath;
	   
	   private final MazeCoord currPoint;
	   private final MazeCoord endPoint;
	   
	   private boolean pathFound = false;
	   /**
	      Constructs a maze.
	      @param mazeData the maze to search.  See general Maze comments for what
	      goes in this array.
	      @param startLoc the location in maze to start the search (not necessarily on an edge)
	      @param endLoc the "exit" location of the maze (not necessarily on an edge)
	      PRE: 0 <= startLoc.getRow() < mazeData.length and 0 <= startLoc.getCol() < mazeData[0].length
	         and 0 <= endLoc.getRow() < mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length

	   */
	   public Maze(boolean[][] mazeData, MazeCoord startLoc, MazeCoord endLoc) 
	   {
		   initMazeData = mazeData;  // Initialize "initMazeDate" array, by taking the 2D array "mazeaData" that contain "true" or false. 
		   visitData = new boolean[mazeData.length][mazeData[0].length];
		   onePath = new LinkedList<MazeCoord>();
		   currPoint = new MazeCoord(startLoc.getRow(), startLoc.getCol());
		   endPoint = new MazeCoord(endLoc.getRow(), endLoc.getCol());
	   }


	   /**
	   Returns the number of rows in the maze
	   @return number of rows
	   */
	   public int numRows() 
	   {
		   return initMazeData.length;  
	   }

	   /**
	   Returns the number of columns in the maze
	   @return number of columns
	   */   
	   public int numCols() 
	   {
		   return initMazeData[0].length;   
	   } 
	   
	   /**
	      Returns true iff there is a wall at this location
	      @param loc the location in maze coordinates
	      @return whether there is a wall here
	      PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
	   */
	   public boolean hasWallAt(MazeCoord loc) 
	   {
		   int column = loc.getCol();
		   int row = loc.getRow();
		   
		   if (initMazeData[row][column]==WALL ) // Check if the current point is wall or not. 
		   {
			   return true;
		   }
		   else {
	           return false;
		   }
	   }

	   /**
	      Returns the entry location of this maze.
	    */
	   public MazeCoord getEntryLoc() 
	   {
	      return currPoint;   
	   }
	   
	   
	   /**
	   Returns the exit location of this maze.
	   */
	   public MazeCoord getExitLoc() 
	   {
	      return endPoint;   
	   }
	   
	   /**
	      Returns path through the maze. First element is starting location, and
	      last element is exit location.  If there was not a path, or if this is called
	      before search, returns empty list.

	      @return the maze path
	    */
	   public LinkedList<MazeCoord> getPath() 
	   {
		   LinkedList<MazeCoord> copy = onePath;
		   return copy;
	   }
	   
	   
	   /**
	      Find a path through the maze if there is one.
	      @return whether path was found.
	   */  
	   
	   public boolean search() 
	   {   
		   if(!pathFound) 
		   {
			   pathFound = getSearch(currPoint);
		   }
		   return pathFound;
	   }
	    
	   /**
	      The getSearch function is the main recursive search that call the function itself. The purpose of it
	      is to identify the direction that the current points are going to.
	      The Base Cases contain several conditions and check if the points are satisfied those conditions.
	      The Recursive Cases use the recursive call to find a path to the end, and return true if it does. 
	   */  
	   
	   private boolean getSearch(MazeCoord currPoint) 
	   {
		   int row = currPoint.getRow();
	   	   int colum = currPoint.getCol(); 
	   	   if ( row < 0 || colum < 0 || (row > numRows()-1) || (colum > numCols()- 1) || initMazeData[row][colum] == WALL || visitData[row][colum]) { // Check if the point is outside of boundaries, is it a wall, or if it had been visited before             
	   		   return false;  
		   }
	   	   if(row == endPoint.getRow() && colum == endPoint.getCol()) {
	   		   onePath.add(currPoint);
	   		   return true;
	   	   }
	   	   visitData[row][colum] = true; // Change the boolean condition to "Have Visited" 
	   	   if(colum < numCols() - 1 && getSearch(new MazeCoord(row, colum + 1)) ) { // right
	   		   onePath.add(new MazeCoord(row,colum));
	   		   return true;
	   	   }
	   	   else if(colum > 0 &&(getSearch(new MazeCoord(row, colum - 1))))  { // left
	   		   onePath.add(new MazeCoord(row,colum));
	   		   return true;
	   	   }  
	   	   else if (row < numRows() - 1 && getSearch(new MazeCoord(row + 1, colum))) { // down
	   		   onePath.add(new MazeCoord(row,colum));
	   		   return true;
	   	   }
	   	   else if(row > 0 && getSearch(new MazeCoord(row - 1, colum))) { // up
	   		   onePath.add(new MazeCoord(row,colum));
	   		   return true;
	   	   }
	   	   visitData[row][colum] = false;  // Reset the boolean condition for a new point as "Have not Visited" 
	   	   return false;
	   }	  
}
   	  

