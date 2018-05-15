// 3
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;

public class Birthday {
	public static void main(String[] args) {
	//Scanner x = new Scanner(System.in); // put external stuff
	// inside to the scanner system for reading
	
	Scanner x = new Scanner(System.in);
	System.out.println("Enter your birth month[1..12]: ");
	int MONTH = x.nextInt();
	
	Scanner y = new Scanner(System.in);
	System.out.println("Enter your birth day of month: ");
	int DAY = y.nextInt();
	
	Scanner z = new Scanner(System.in);
	System.out.println("Enter your birth year [4-digit year]: ");
	int YEAR =z.nextInt();
	
	GregorianCalendar today = new GregorianCalendar (2015, 9, 3);
	int currentmonth = today.get(today.MONTH);
	int currentday = today.get(today.DAY_OF_MONTH);
	if ((MONTH>currentmonth)| (DAY>currentday)&&(MONTH ==currentmonth)) {
		System.out.println("Your birthday has not yet happened this year.");
	}
	else if (((MONTH<currentmonth)) | (DAY<currentday)&&(MONTH ==currentmonth)) {
		System.out.println("Your birthday has already happened this year.");
	}
	
	
	}
}
