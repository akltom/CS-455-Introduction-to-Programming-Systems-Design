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
  printAll(list);


  insert(list, "King", 32);
  insert(list, "Sam", 50);
  insert(list, "Lay",  25);
//  cout << "a list: ";
  printAll(list);
  
  remove (list, "King");
  printAll(list);
  
  int* value = lookup(list, "Sam");
  cout << value << endl;
  
  int size = sizeOfList(list);
  cout << size << endl;
  
}
