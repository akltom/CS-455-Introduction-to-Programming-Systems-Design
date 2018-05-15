// Name: King Lun Au
// USC loginid: kingluna
// CS455 PA1
// Spring 2016

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/**
RandomWalkComponent class, extends JComponent.
Constructor initializes any necessary data.
Draws the random walk of the path that taken by the drunkard.
*/
public class RandomWalkComponent extends JComponent{
	public static final int STARTING_LOC = 200;
	public static final int STEP_SIZE = 5;
	private int numberSteps; 
	public RandomWalkComponent(int numberSteps) { 
		this.numberSteps = numberSteps; 
	}
	
	/**
	paintComponent class is to display the random walk.
	Check and ensure that users enter a positive number of steps.
	@param g the object graph paintComponent method works on
    */
	public void paintComponent(Graphics g) {
	 	// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g; // Draw a two dimensional graphics object g2
		ImPoint startloc = new ImPoint(STARTING_LOC,STARTING_LOC);
		ImPoint endloc = new ImPoint (STARTING_LOC,STARTING_LOC);
		Drunkard drunkdude = new Drunkard(startloc, STEP_SIZE);   
		
		for(int i = 0; i < numberSteps; i++) {
			startloc = endloc; // Set the end of first point equal to the beginning of second point
			drunkdude.takeStep(); // Call takeStep method to run to new location
			endloc = drunkdude.getCurrentLoc();
			Line2D.Double segment = new Line2D.Double(startloc.getPoint2D(), endloc.getPoint2D());
			g2.draw(segment);
		}
	}

}