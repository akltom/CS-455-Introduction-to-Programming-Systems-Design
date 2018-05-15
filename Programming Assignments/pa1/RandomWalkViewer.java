// Name: King Lun Au
// USC loginid: kingluna
// CS455 PA1
// Spring 2016

import javax.swing.JFrame;
import java.util.Scanner;


/**
   RandomWalkViewer Class, display a frame with graphic component for the walking path of drunkard.
*/
public class RandomWalkViewer 
{
	public static void main(String[] args){
		int stepsNumber;
		int pixelWindow = 400;
		JFrame frame = new JFrame(); // Construct a frame object and configure it
		frame.setSize(pixelWindow, pixelWindow); 
		frame.setTitle("RandomWalk"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Scanner in = new Scanner(System.in);  
		System.out.println("Enter number of steps: "); //Get the # of steps from users
		stepsNumber = in.nextInt(); // Define a variable to hold the input value
		while ( stepsNumber <= 0){ // Avoid zero and negative numbers
			System.out.println("ERROR: Number entered must be greater than 0."); 
			stepsNumber = in.nextInt(); 
		}
		
		RandomWalkComponent component = new RandomWalkComponent(stepsNumber);
		frame.add(component); // Add the component to the frame
		
		frame.setVisible(true); 
	}
}
