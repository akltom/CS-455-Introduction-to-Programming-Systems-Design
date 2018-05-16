import java.util.Scanner;
import java.util.ArrayList;

public class ReadTester {
	public static void main(String[] args){
		while (true){
		System.out.println("Enter a space separated list of numbers:  " );
		Scanner in = new Scanner (System.in);
		String line = in.nextLine(); // 
		
		Scanner lineScanner =  new Scanner (line); // read the line
		ArrayList<Integer> arraylist= new ArrayList<>();
		
		while (lineScanner.hasNextInt())
			
		{
			 arraylist.add(lineScanner.nextInt());
		}
		
		System.out.println(" The numbers were:" );
		System.out.println(arraylist );
		}
	}
}
