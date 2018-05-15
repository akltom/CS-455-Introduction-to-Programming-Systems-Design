// ectest.cpp
// CSCI 455 Spring 2016, Extra Credit assignment

// Note: this uses separate compilation.  You put your code in listFuncs.cpp
// Code in this file calls those funcs.
// You do not need to modify or submit this file.


#include <iostream>
#include <cctype>
#include <cassert>
#include <string>

// for istringstream
#include <sstream>

#include "ecListFuncs.h"

using namespace std;


int promptForInt (string prompt);
void buildList(ListType & theList);
void doHelp();
void doSplitEvenOdd(ListType & list);
void doInsertInOrder(ListType & list);
bool readAndDispatchCommand(ListType & theList);

//*************************************************************************


/* a little test program */

int main ()
{

  bool keepgoing = true;

  ListType theList = NULL;

  doHelp();

  do {

    keepgoing = readAndDispatchCommand(theList);

    cout << "The list: ";
    printList (theList);

  } while (keepgoing);

  return 0;
}


/*
 * reads a command and executes it.
 * The command execution updates and/or uses theList, thus it's passed
 * by reference here.
 * Returns false iff the command entered was q (quit)
 */
bool readAndDispatchCommand(ListType & theList) {

  char cmd;

  cout << "\nPlease enter a command [b, f, o, i, s, e, p, h, q]: ";
  cin >> cmd;

  if (cmd == 'b') {
    clearList(theList);
    cout << "Please enter a sequence of ints followed by <nl> (e.g:1 2 3): ";
    buildList(theList);
  }
  else if (cmd == 'f') {
    int val = promptForInt ("Value to insert");
    insertFront (theList, val);
  }
  else if (cmd == 's') {
    insertionSort(theList);
  } 
  else if (cmd == 'o') {
    cout << "The elements in the list are ";
    if (!isInOrder(theList)) {
      cout << "NOT ";
    }
    cout << "in increasing order." << endl;
  }
  else if (cmd == 'e') {
    doSplitEvenOdd(theList);
  }
  else if (cmd == 'i') {
    doInsertInOrder(theList);
  }
  else if (cmd == 'p') {
    cout << "Print list: " << endl;
    printList(theList); cout << endl;
  }
  else if (cmd == 'q') {
    return false;
  }
  else {
    doHelp();
  }
    
  return true;
    
}


/*
 * promptForInt: Prompts for and reads an integer.
 */
int promptForInt (string prompt)
{
  int value;

  cout << prompt << ": ";
  cin >> value;
  return value;
}



// build the list in forward order
// old value of theList is destroyed.
// (needs to be O(n))

// Note: this code uses istringstream: this is the analogous feature
//     to using a Scanner on a String in Java.
void buildList(ListType & theList) {

  string lineStr;

  getline(cin, lineStr);  // consume rest of previous line

  getline(cin, lineStr);

  if (lineStr.empty()) {
    theList = NULL;
    return;
  }

  istringstream istr(lineStr);

  Node *last = NULL;
  int i;

  istr >> i;   // first one is a special case
  theList = new Node(i);
  last = theList;

  while (istr >> i) { // comes out false if we reach end of string (i.e., eoln)
    last->next = new Node(i);
    last = last->next;
  }

}


// prints a command summary
void doHelp() {
  cout << "Valid commands are" << endl;
  cout << "         b(uild new list), f(insert in front), " << endl;
  cout << "         o(is in order?), i(nsert in order), s(insertion sort), " <<endl;
  cout << "         e(split even odd), p(rint), h(elp), q(uit)." << endl;
}



// test splitEvenOdd function on list and print results
void doSplitEvenOdd(ListType & list) {
  ListType list1 = NULL;
  ListType list2 = NULL;

  splitEvenOdd(list, list1, list2);
  cout << "Odd-located elements: ";
  printList(list1);
  cout << "Even-located elements: ";
  printList(list2);
  cout << "(The list should be empty now.)" << endl;
}


// do I/O and test of insertInOrder on list
void doInsertInOrder(ListType & list) {
  if (!isInOrder(list)) {
    cout << "Sorry, cannot complete insertInOrder operation, because list is not in order." 
	 << endl;
    return;
  }
  int val = promptForInt ("Value to insert");
  insertInOrder (list, new Node(val));
}


//*****************************************************************
// utility list funcs and Node methods
// (function comments for these are in listFuncs.h)

void insertFront(ListType &list, int val) {
  list = new Node(val, list);
}


void printList(ListType list) {

  if (list == NULL) {
    cout << "<empty>";
  }

  Node *p = list;
  while (p != NULL) {
    cout << p->data << " ";
    p = p->next;
  }
  cout << endl;
}


void clearList(ListType &list) {

  Node *rest = list;

  while (list != NULL) {
    rest = list->next;  // rest is all but the first element
    delete list;  // reclaims one node only
    list = rest;
  }

}

Node::Node(int item) { 
  data = item;
  next = NULL;
}

Node::Node(int item, Node *n) {
  data = item;
  next = n;
}
