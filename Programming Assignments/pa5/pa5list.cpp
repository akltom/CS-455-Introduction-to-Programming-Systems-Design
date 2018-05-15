// Name:
// loginid:
// CS 455 Lab 13 / PA5

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile (and lab 13 Makefile) includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {

  ListType list;

  initList(list);

  cout << "an empty list: ";
  printAllList(list);


  insertInList(list, "King", 32);
  insertInList(list, "Sam", 50);
  insertInList(list, "Lay",  25);
//  cout << "a list: ";
  printAllList(list);
  
  removeNode (list, "King");
  printAllList(list);
  
  int* value = lookUpList(list, "Sam");
  cout << value << endl;
  
  int size = sizeOfList(list);
  cout << size << endl;
  
}
