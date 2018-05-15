// Name: King Lun Au
// Loginid: kingluna
// CSCI 455 PA5
// Spring 2016


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
#include <string>
using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;


// all the part above are given 

//*************************************************************************

//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.
   
   
// Initialize the list that point to NULL.
void initList(ListType &list);

// Take a key and value from the user, insert that node into the list. 
// If that key is not on the list, the node will be added, the function will return true, and print corresponding messages to the user.
// If that key is already on the list, the node will not be added, the function will return false, and print corresponding messages to the user.
bool insertInList(ListType & list, const string &key, int value); 

// Print out all the entries in the list.
void printAllList(const ListType list);

// Take a key from the user, remove that node into the list. 
// If that key is not on the list, the node will not be removed, the function will return true, and print corresponding messages to the user.
// If that key is on the list, the node will be removed, the function will return true, and print corresponding messages to the user.
bool removeNode(ListType & list, const string & key); 

// Take a key from the user, look up the value of that key.
// If that key is on the list, return the corresponding value.
// If that key is not on the list, return nothing.
int *lookUpList(ListType & list,const string &key); 

// Return the size of the list.
int sizeOfList(const ListType &list); 

// Return the number of entries of the list.
int getNumEntries (const ListType &list);

// keep the following line at the end of the file
#endif
