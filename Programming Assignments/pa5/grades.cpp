// Name: King Lun Au
// Loginid: kingluna
// CSCI 455 PA5
// Spring 2016

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>



  // Prints out a brief command summary of what the commands are.
  void help() {
	cout << "Here are the commands for the program:" << endl;
  	cout << "insert name score: Insert this name and score in the grade table. If this name was already present, print a message to that effect, and don't do the insert." << endl;   
  	cout << "change name newscore: Change the score for name. Print an appropriate message if this name isn't present." << endl;
  	cout << "lookup name: Lookup the name, and print out his or her score, or a message indicating that student is not in the table." << endl;
  	cout << "remove name: Remove this student. If this student wasn't in the grade table, print a message to that effect." << endl;
  	cout << "print: Prints out all names and scores in the table." << endl;
  	cout << "size: Prints out the number of entries in the table." << endl;
  	cout << "stats: Prints out statistics about the hash table at this point. (Calls hashStats() method) " << endl;
  	cout << "help: Prints out a brief command summary." << endl;
  	cout << "quit: Exits the program." << endl;
  }
  
  // Insert the name and the scores for that student.
  void insertNameAndScore(Table * grades) {
  	 string key;
  	 string valueString;
  	 cin >> key;
  	 cin >> valueString;
  	 int value = atoi(valueString.c_str());
  	 grades->insert(key, value);
  }
  
  // Given the student name from the user, change the scores of the student.
  void changeNewScores(Table * grades){
  	string key;
  	string valueString;
  	cin >> key;
  	cin >> valueString;
  	int value = atoi(valueString.c_str()); // Convert the input string into integer.
  	int * oldValueOfKey = grades->lookup(key);  // Call the lookup function and return the current value of that key.
  	if (oldValueOfKey == NULL) {
    	cout << "This name isn't present, can not change the grades. " << endl;
    }
    else {
     	*oldValueOfKey = value; // Replace the old scores with the new one.
     	cout << "The grade had been changed successfully. " << endl;
	}
  }

  // Look up the scores based on the input key from the user.
  void lookUp(Table * grades) {
    string key;
    cin >> key;
    int * value = grades->lookup(key);
    if (value == NULL) {
    	cout << "This student is not in the table. " << endl;
    } 
	  else {
        cout << "The grade of this studnet is: " << *value << endl;
      }
  }

  // Remove the key of this student in the list.
  void removeKey(Table *grades) {
  	string key;
  	cin >> key;
    int *value = grades->lookup(key);
    	if (value == NULL) {
        	cout << "This student wasn't in the grade table, can not remove value. " << endl;
        } 
		else {
        	grades->remove(key);
            cout << "Remove successfully. " << endl;
        }
  }
  
  // Print out all the buckets with corresponding entries.
  void print(Table *grades){
  	grades->printAll();
  }
  
  // Return the number of the total entries.
  void size(Table *grades){
  	cout << "The number of entries in the table: " << grades->numEntries() << endl;
  }
 
  // Display the stats that summarize the current statistic of the table.
  void stats(Table *grades) {
  	grades->hashStats(cout);
  }
  
  // A function that process the program based on the given command.
  // Run functions that defined above and quit the program if the user types "quit".
  void processCommand(Table *grades) {
  	bool isQuit = false;
  	string command = "";
  	cout << "cmd> " << endl;
  	cin >> command;
  	while (isQuit != true) {
  		if (command == "help") {
  			help();
  		}
  		else if (command == "insert") {
  			insertNameAndScore(grades);
		}
    	else if (command == "change") {
    		changeNewScores(grades);
		}
		else if (command == "lookup") {
			lookUp(grades);
		}
		else if (command == "remove") {
			removeKey(grades);
		}
		else if (command == "print") {
			print(grades);
		}
		else if (command == "size") {
			size(grades);
		}
		else if (command == "stats") {
			stats(grades);
		}
		else if (command == "quit") {
			isQuit = true;
		}
    	else {
    		cout << "This is an invalid command. " << endl;
		}
		
		if (command != "quit") {
			cout << "cmd> " << endl;
  			cin >> command;
  		}
	}	
}

int main(int argc, char * argv[]) {

  // gets the hash table size from the command line

  int hashSize = Table::HASH_SIZE;

  Table * grades;  // Table is dynamically allocated below, so we can call
                   // different constructors depending on input from the user.

  if (argc > 1) {
    hashSize = atoi(argv[1]);  // atoi converts c-string to int

    if (hashSize < 1) {
      cout << "Command line argument (hashSize) must be a positive number" 
	   << endl;
      return 1;
    }

    grades = new Table(hashSize);

  }
  else {   // no command line args given -- use default table size
    grades = new Table();
  }


  grades->hashStats(cout);

  // add more code here
  // Reminder: use -> when calling Table methods, since grades is type Table*

  processCommand(grades);
  
}
