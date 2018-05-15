//Name: King Lun Au
//USC loginid: kingluna
//CS455 PA1
//Spring 2016

/**
DrunkardTester class
    Test a point for the "drunkard" class, display the expected and actual output.
    Print error messages if the path is moving in x and y direction simultaneously.
*/
public class DrunkardTester {
	/**
	Test driver for Drunkard class.
	Create a starting point, and four Drunkard objects that have different step size and step number.
	@param args not used.
	*/
	public static void main(String[] args) { 
		ImPoint testingPoint = new ImPoint(200, 200); // Set up a point that located in the middle of pixel window
		theDrunkardTester(testingPoint, 10, 10);  
		theDrunkardTester(testingPoint, 20, 20);
		theDrunkardTester(testingPoint, 30, 30);
		theDrunkardTester(testingPoint, 40, 20);
	}
	
	/**
	Test the Drunkard methods with inputs of stepSize and stepNumber.
	Check if the steps taken are valid or non-valid. 
	@param testingPoint: Contain a x value and a y value.
    @param stepSize: The size of each step.
    @param stepNum: The total number of steps that the drunkard will take.
	*/
	private static void theDrunkardTester(ImPoint testingPoint, int stepSize, int stepNumber) {
		System.out.println("Drunkard starts at:"+" "+"("+testingPoint.getX()+","+testingPoint.getY()+")"+"; step size is "+stepSize);
		System.out.println("get starting loc [expected:("+testingPoint.getX()+","+testingPoint.getY()+"]:"+" "+"("+testingPoint.getX()+","+testingPoint.getY()+")"); 
		Drunkard drunkard = new Drunkard(testingPoint, stepSize); // Call the Drunkard class
		int i;
 	
		for (i=0; i<stepNumber; i++){ 
			int xBefore = drunkard.getCurrentLoc().getX(); // Get the original point of x value
			int yBefore = drunkard.getCurrentLoc().getY(); // Get the original point of y value
			drunkard.takeStep();  
			int xAfter = drunkard.getCurrentLoc().getX(); // The x value after taking a step
			int yAfter = drunkard.getCurrentLoc().getY(); // The y value after taking a step
			if (Math.abs(xAfter-xBefore) == stepSize && yAfter == yBefore){ 
 			//If x is changed and y remains constant 
				System.out.println("took step to"+" "+"("+xAfter+","+yAfter+")"+ " SUCCEEDED");
			}
			else if ((Math.abs(yAfter-yBefore) == stepSize) && xAfter == xBefore){  
 			//If y is changed and x remains constant 
				System.out.println("took step to"+" "+"("+xAfter+","+yAfter+")"+ " SUCCEEDED");	
			}
			else{
 			//If both x and y direction are changed, which is Fail! (should never be happen in this program)
				System.out.println("took step to"+" "+"("+xAfter+","+yAfter+")"+" FAILED: not a valid step");
			}
		}
	}
}
		


