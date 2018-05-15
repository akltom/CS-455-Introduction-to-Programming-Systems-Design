// Name: King Lun Au
// USC loginid: kingluna
// CS455 PA1
// Spring 2016


/**
ImPointTester     
    console-based test program for ImPoint class.
    Uses hard-coded data, prints expected and actual output.

 author: CMB

Note: "private static" methods below are how we define helper
functions for other static functions.  Need to be static because
main is static.  Don't need to be public because they are only
ever called by main (not from outside the class).
*/

import java.util.Random;


public class ImPointTester {

 /**
    Test driver for ImPoint class.
    @param args not used
 */
 public static void main(String[] args) {


	imPointTest(100, 82);

	imPointTest(0, 0);

	imPointTest(50, 60);

 }
		
 /**
    Test all ImPoint methods on (x,y)
  */
 private static void imPointTest(int x, int y) {
	
	ImPoint loc = new ImPoint(x, y);

	System.out.println("Testing with x=" + x + " y=" + y);

	System.out.println("Testing toString...");
	// the following line implicitly calls toString
	System.out.println("loc= " + loc);

	System.out.println("Testing getX, getY...");
	System.out.println("x=" + loc.getX() + " y=" + loc.getY());

	System.out.println("Point2D version: " + loc.getPoint2D());

	testTranslate(loc, 5,10);

	testTranslate(loc, -20, 15);

	System.out.println();

 }

 /**
    Test translate method on loc to be translated by deltaX and deltaY
  */
 private static void testTranslate(ImPoint loc, int deltaX, int deltaY) {

	int oldX = loc.getX();
	int oldY = loc.getY();

	ImPoint p2 = loc.translate(deltaX, deltaY);

	System.out.println("Testing translate by (" + deltaX + "," + deltaY + ") ...");
	System.out.println("Old point [expected:(" + oldX + "," + oldY+")]: "
			   + loc + ".");
	System.out.println("New point [expected:("
			   + (oldX+deltaX) + "," + (oldY+deltaY) + ")]: " 
			   + p2 + ".");
	System.out.println("Point2D version of new point: " + p2.getPoint2D());
 }

}

