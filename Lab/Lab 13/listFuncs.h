// Name:
// Loginid:
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

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.


// insert a new pair into the table
   // return false iff this key was already present 
   //         (and no change made to table)
   
   
   
void initList(ListType &list);

//print all the elements in the list
void printAll(const ListType list); //1

//string toString(const ListType &list) ; 
   
bool insert(ListType & list, const string &key, int value); //2 (const int value)

void insertAtFront(ListType &list, const string &key, int value);  //3 (const int value)

//remove the element from the list  
bool remove(ListType & list, const string & key); // 4

// returns the address of the value or NULL if key is not present
int *lookup(ListType & list,const string &key); // 5 List here does not put const, because it will change over times

// Returns the size of the given list.
// PRE: Assuming the list size is <= INT_MAX.
int sizeOfList(const ListType &list); // 6


// keep the following line at the end of the file
#endif
