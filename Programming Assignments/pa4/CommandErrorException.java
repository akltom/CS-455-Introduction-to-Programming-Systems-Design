// Name: King Lun
// USC loginid: kingluna	
// CS 455 PA4
// Spring 2016

import java.io.IOException;

/**
   This class is created to take care of all the command error exception in the 
   methods, and be able to throw back the exception to the main.
 */
public class CommandErrorException extends IOException {
	public CommandErrorException() {}
	public CommandErrorException(String message) {
		super(message);
	}
}

