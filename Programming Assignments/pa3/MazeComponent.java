// Name: King Lun Au		
// USC loginid: kingluna
// CS 455 PA3
// Spring 2016

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
   MazeComponent class
   
   A component that displays the maze and a path through it if one has been found.
*/
public class MazeComponent extends JComponent
{
   private Maze maze;
   
   private static final int START_X = 10; // where to start drawing maze in frame
   private static final int START_Y = 10;
   private static final int BOX_WIDTH = 20;  // width and height of one maze unit
   private static final int BOX_HEIGHT = 20;
   private static final int INSET = 2;  
   					// how much smaller on each side to make entry/exit inner box

   /**
      Constructs the component.
      @param maze   the maze to display
   */
   public MazeComponent(Maze maze) 
   {      
	   this.maze = maze; 
   }

   
   /**
     Draws the current state of maze including a path through it if one has
     been found.
     @param g the graphics context
   */
   public void paintComponent(Graphics g)
   {
	   Graphics2D g2 = (Graphics2D) g;
	   MazeCoord startPoint = maze.getEntryLoc(), endPoint = maze.getExitLoc();
	   int a = 0, b = 0, xStart = startPoint.getCol(), yStart = startPoint.getRow(), xEnd = endPoint.getCol(), yEnd = endPoint.getRow(); // Set up the counter, and x and y value of start point and end point.
	   while ( a < maze.numRows() ) {
		   while( b <maze.numCols() ) {
			   	MazeCoord mazeCoordinate = new MazeCoord(a,b);
			   	Rectangle rectBox = new Rectangle(START_X + BOX_WIDTH * b, START_Y + BOX_HEIGHT * a, BOX_WIDTH, BOX_HEIGHT);
			   	if (maze.hasWallAt(mazeCoordinate)){ // If this is a wall, fill it in with black color.
			   		g2.setColor(Color.BLACK);			   		
			   	}
			   	else { // Otherwise, the rest of the boxes are free.
			   		g2.setColor(Color.WHITE);		            
			   	}
			   	g2.fill(rectBox);
			   	b++;
		   } 
		   b = 0; // Set the index b equal to 0 for a new row.
		   a++;
	   }
	   g2.setColor(Color.yellow); // Draw a yellow block that represents the start point.
	   g2.fillRect(START_X + xStart * BOX_WIDTH + INSET, START_Y + yStart * BOX_HEIGHT + INSET , BOX_WIDTH-2*INSET , BOX_HEIGHT-2*INSET );
	   g2.setColor(Color.green); // Draw a green block that represents the end point.
	   g2.fillRect(START_X + xEnd * BOX_WIDTH + INSET, START_Y + yEnd * BOX_HEIGHT + INSET, BOX_WIDTH-2*INSET, BOX_HEIGHT-2*INSET);
	   Rectangle box = new Rectangle(START_X, START_Y, BOX_WIDTH * maze.numCols(), BOX_HEIGHT * maze.numRows());
	   g2.setColor(Color.BLACK); 
	   g2.draw(box); // Draw the outer black line that form the boundary.  
	   paintPath(g);
   } 
   
   /**
   A function that uses to construct and print a blue line from starting point to the end point.
   This function will be called in paintComponent function.
   @param g the graphics context
   */
   public void paintPath(Graphics g)
   {
	   Graphics2D g2 = (Graphics2D) g;   
       LinkedList<MazeCoord> aFootPath = maze.getPath();
       ListIterator<MazeCoord> iter = aFootPath.listIterator();
       
       if(!iter.hasNext()) return; // If there are nothing in the text file, return nothing.
       
       MazeCoord lastPoint = iter.next();
       while(iter.hasNext()) 
       {
    	   MazeCoord currentPoint = iter.next();
           int x = currentPoint.getCol() * BOX_WIDTH + START_X + BOX_WIDTH/2 ; // Get the X and Y values of a point by multiplying the component with the given unit.
           int y = currentPoint.getRow() * BOX_HEIGHT + START_Y + BOX_HEIGHT/2 ;
           int lastX = lastPoint.getCol() * BOX_WIDTH + START_X + BOX_WIDTH/2; // Get the X and Y values of the last point by multiplying the component with the given unit.
           int lastY = lastPoint.getRow() * BOX_HEIGHT + START_Y + BOX_HEIGHT/2;
           
           g2.setColor(Color.BLUE);
           g2.drawLine(x, y, lastX, lastY); // Draw a line between current point and the previous point.
           lastPoint = currentPoint;
       }
	 
   }
   
}
