
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
    public static void main(String[] args) {

	Calendar Calendar1 = new GregorianCalendar(1995, 0, 20);    
	Calendar Calendar2 = new GregorianCalendar(1995, 1, 9);

	System.out.println(Calendar1.get(Calendar.MONTH)+1+"/"+Calendar1.get(Calendar.DAY_OF_MONTH)+"/"+Calendar1.get(Calendar.YEAR));

	System.out.println(Calendar2.get(GregorianCalendar.MONTH)+1+"/"+Calendar2.get(Calendar.DAY_OF_MONTH)+"/"+Calendar2.get(GregorianCalendar.YEAR));


    }

}
	
		      
