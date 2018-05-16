
// Name:
// Loginid:
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

void initList(ListType &list) {
  list = NULL;
}


void printAll(const ListType list) {

  if (list == NULL) {
    cout << "<empty>";
  }

  Node *p = list;
  while (p != NULL) {
    cout << p->key << " " << p->value << endl;
    p = p->next;
  }
  cout << endl;
}

//string toString(const ListType &list) {
//    if (list == NULL) {
//        return "";
//    } else {
//        ListType p = list;

        // Uses sstream to make a string.
 //       ostringstream oss;
 //       while (p != NULL) {
 //           oss << "    " << p->key << " : " << p->value << endl;
 //           p = p->next;
 //       }
 //       return oss.str();
 //   }
//}



bool insert(ListType &list, const string &key, int value) {
   if (list == NULL) {
       insertAtFront(list, key, value);
   } 
   else {
       ListType p = list;
       while (p->next != NULL) {
           p = p->next;
       }
       p->next = new Node(key, value);
   }
   return true;
}

void insertAtFront(ListType &list, const string &key, int value) {
   list = new Node(key, value, list);
}


bool remove(ListType &list, const string &key) {
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

int *lookup(ListType & list, const string &key) {
//    if(list == key){
//        return NULL;
//    }
    Node * p = list;
    while(p != NULL){
        if(p -> key == key){
            return &(p->value);
        }
        else{
            p = p -> next;
        }
    }
    return NULL;
}




int sizeOfList(const ListType &list) {
    int count = 0;
    ListType p = list;
    while (p != NULL) {
        count++;
        p = p->next;
    }
    return count;
}

