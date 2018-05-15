//4
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;

public class Birthday3 {
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
		
		GregorianCalendar today = new GregorianCalendar (2016, 1, 22); // GregorianCalendar today = new GregorianCalendar()
		int currentmonth = today.get(GregorianCalendar.MONTH);
		int currentday = today.get(today.DAY_OF_MONTH);
		int currentyear = today.get(today.YEAR); ///////
		
		if ((MONTH>currentmonth)|| (DAY>currentday)&&(MONTH ==currentmonth)) {
			int age1 = currentyear-YEAR-1;
			System.out.println("Your birthday has not yet happened this year.");
			System.out.println("You're "+age1+ "years old.");
		}
		else if (((MONTH<currentmonth)) || (DAY<currentday)&&(MONTH ==currentmonth)) {
			int age2 = currentyear-YEAR;
			System.out.println("Your birthday has already happened this year.");
			System.out.println("You're "+age2+ "years old.");
		}
		else if ((DAY==currentday)&&(MONTH ==currentmonth)) {
			int age3 = currentyear-YEAR;
			System.out.println("Your birthday has already happened this year.");
			System.out.println("You're "+age3+ "years old.");
		}
		
	}
}
