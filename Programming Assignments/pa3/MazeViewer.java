//Name: King Lun Au		
//USC loginid: kingluna
//CS 455 PA3
//Spring 2016


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 * MazeViewer class
 * 
 * Program to read in and display a maze and a path through the maze. At user
 * command displays a path through the maze if there is one.
 * 
 * How to call it from the command line:
 * 
 *      java MazeViewer mazeFile
 * 
 * where mazeFile is a text file of the maze. The format is the number of rows
 * and number of columns, followed by one line per row, followed by the start location, 
 * and ending with the exit location. Each maze location is
 * either a wall (1) or free (0). Here is an example of contents of a file for
 * a 3x4 maze, with start location as the top left, and exit location as the bottom right
 * (we count locations from 0, similar to Java arrays):
 * 
 * 3 4 
 * 0111
 * 0000
 * 1110
 * 0 0
 * 2 3
 * 
 */

public class MazeViewer {
	
	private static final char WALL_CHAR = '1';
	private static final char FREE_CHAR = '0';
	
    public static void main(String[] args)  {

      String fileName = " ";

      try {

         if (args.length < 1) {
            System.out.println("ERROR: missing file name command line argument");
         }
         else {
            fileName = args[0];

            JFrame frame = readMazeFile(fileName);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
         }

      }
      catch (FileNotFoundException exc) {
         System.out.println("File not found: " + fileName);
      }
      catch (IOException exc) {
         exc.printStackTrace(); 
      }
   }

    /**
    readMazeFile reads in maze from the file whose name is given and 
    returns a MazeFrame created from it.
   
   @param fileName
             the name of a file to read from (file format shown in class comments, above)
   @returns a MazeFrame containing the data from the file.
        
   @throws FileNotFoundException
              if there's no such file (subclass of IOException)
   @throws IOException
              (hook given in case you want to do more error-checking.
               that would also involve changing main to catch other exceptions)
   */
   private static MazeFrame readMazeFile(String fileName) throws IOException {
	   File inFile = new File(fileName);
	   Scanner in = new Scanner(inFile);  // Read the file
	   String scanOneLine = in.nextLine();
	   Scanner inOneLine = new Scanner(scanOneLine); //Read the line(s) from that file. 
	   int numRow = inOneLine.nextInt(), numColu = inOneLine.nextInt();  // Read the # of row and column, which is the first and second integer from the first line of text file respectively. 
	   boolean[][] maze = new boolean[numRow][numColu]; 
	   for (int i = 0; i < numRow; ++i) {
		   String stringRow = in.nextLine();  // Read the characters from the line.
		   for (int j = 0; j < numColu; ++j) {
			   char tempChar = stringRow.charAt(j);
		       if (tempChar == FREE_CHAR) {
		    	   maze [i][j] = false;  // If we read '0', make it as false, put it into a new boolean 2-D array.
		       }
		       else if (tempChar == WALL_CHAR) {
		    	   maze [i][j] = true; // If we read '1', make it as true, put it into a new boolean 2-D array.
		       }
		   }  
	   }
	   String scanEntryPoint = in.nextLine();
	   Scanner entryPointLine = new Scanner(scanEntryPoint);  
	   int xEntryPoint = entryPointLine.nextInt(), yEntryPoint = entryPointLine.nextInt();  // Read the x and y value of the entry point.
	   String scanEndPoint = in.nextLine();
	   Scanner endPointLine = new Scanner(scanEndPoint);
	   int xEndPoint = endPointLine.nextInt(), yEndPoint = endPointLine.nextInt();  // Read the x and v value of the end point. 
	   MazeCoord startPoint = new MazeCoord(xEntryPoint,yEntryPoint), endPoint = new MazeCoord(xEndPoint,yEndPoint); // Generate the x and y coordinate of the starting point and end point.
	   inOneLine.close();
	   entryPointLine.close();
	   endPointLine.close();
	   in.close();
       return new MazeFrame(maze, startPoint, endPoint);
    }
}