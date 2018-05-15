
// Name: King Lun Au
// Loginid: kingluna
// CSCI 455 PA5
// Spring 2016


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

// Initialize the list that point to NULL.
void initList(ListType &list) {
  list = NULL;
}


// Take a key and value from the user, insert that node into the list. 
// If that key is not in the list, the node will be added, the function will return true, and print corresponding messages to the user.
// If that key is already in the list, the node will not be added, the function will return false, and print corresponding messages to the user.
bool insertInList(ListType &list, const string &thisKey, int thisValue) {
  if (list == NULL) {
   	list = new Node(thisKey, thisValue);
   	cout << "The key and value have inserted successfully." << endl;
   	return true;
  }
  else {
    ListType p = list;
    while (p->next != NULL) {
       	if (p->key == thisKey) {
       	 	cout << "This name was already present in the table." << endl;
       	 	return false;
		}
        p = p->next;
    }
    if (p->key == thisKey) {
       	cout << "This name was already present in the table. " << endl;
       	return false;
	}
	p->next = new Node(thisKey, thisValue);
	return true;
  }
}

// Print out all the entries in the list.
void printAllList(const ListType list) {
  if (list == NULL) {
    cout << "<empty>";
  }
  Node *p = list;
  while (p != NULL) {
    cout << p->key << " " << p->value << " ";
    p = p->next;
  }
  cout << endl;
}

// Take a key from the user, remove that node into the list. 
// If that key is not on the list, the node will not be removed, the function will return true, and print corresponding messages to the user.
// If that key is on the list, the node will be removed, the function will return true, and print corresponding messages to the user.
bool removeNode(ListType &list, const string &key) {
   if (list == NULL) {
      return false;
   } 
   else {
   		ListType previous = NULL;
        ListType p = list;
        while (p->key != key) {
        	previous = p;
            p = p->next;
        }
        if (previous != NULL) {
           	previous->next = p->next;
            delete(p);
        } 
		else {
            list = p->next;
        }
    return true;
    }
}

// Take a key from the user, look up the value of that key.
// If that key is on the list, return the corresponding value.
// If that key is not on the list, return nothing.
int *lookUpList(ListType & list, const string &key) {
    Node * p = list;
    while(p != NULL) { 
        if(p -> key == key) {
            return & (p->value);
        }
        else {
            p = p -> next;
        }
    }
    return NULL; // Return nothing if the list is empty, or if that key is not on the list.
}

// Return the size of the list.
int sizeOfList(const ListType &list) {
    int counter = 0;
    ListType p = list;
    while (p != NULL) {
        counter++;
        p = p->next;
    }
    return counter;
}

// Return the number of entries of the list.
int getNumEntries (const ListType &list) { 
	int counter = 0;
	ListType p = list;
	if (list == NULL) {
		return counter;
	}
	while (p!=NULL) {
		p = p->next;
		counter ++;
	}
	return counter;
}



