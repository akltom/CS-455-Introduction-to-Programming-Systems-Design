// ecListFuncs.h
// CSCI 455 Spring 2016, Extra Credit assignment
// You do not need to modify or submit this file.

#ifndef EC_LIST_FUNCS_H
#define EC_LIST_FUNCS_H

#include <iostream>
#include <cctype>
#include <string>

using namespace std;


//*************************************************************************
// Node type used for lists
struct Node {
  int data;
  Node *next;

  Node(int item);
  Node(int item, Node *n);

};


typedef Node * ListType;

//*************************************************************************
// Utility functions used by the test driver code
//    (these are defined in ectest.cpp)

// inserts val at the front of list
// PRE: list is a well-formed list
void insertFront(Node *&list, int val);

// makes list into an empty list
//   reclaiming memory used by nodes 
// PRE: list is a well-formed list
// POST: list' is NULL
void clearList(Node * &list);

// prints list elements, space separated, ending with '\n'
// prints empty list as "<empty>"
// PRE: list is a well-formed list
void printList(Node *list);



//*************************************************************************
// Functions you need to write for this assignment:
//   (implementations go in listFuncs.cpp)



/*
 * isInOrder
 *
 * Pre: list is a well-formed list.
 *
 * returns true iff the elements in the list are in increasing order
 *  (duplicate elements allowed)
 *
 * Examples:
 *  list                   isInOrder(list)
 *
 *    ()                    true
 *    (2)                   true
 *    (7 2 2 3)             false
 *    (2 2 3 7)             true
 *    (2 2 3 3 3 4 4 4 4)   true
 *    (-12 0 7 10)          true
 *    (-12 0 7 5)           false
 */
bool isInOrder(ListType list);



/*
 * insertInOrder
 *
 * PRE: list is a well-formed list and isInOrder(list) [see function above]
 *  and itemP is a pointer to a single node (i.e., itemP->next == NULL)
 *
 * inserts the new node into the ordered list.
 *
 * POST: list' includes itemP, and isInOrder(list)
 * (so a client should not change the node pointed to by itemP after using this
 *  function, because it will invalidate the list)
 *
 * NOTE: this function does not create any new nodes.
 *
 * Examples:
 *
 *  list          itemP    list'
 *    ()          (2)      (2)
 *    (7)         (2)      (2 7)
 *    (1 3 5)     (4)      (1 3 4 5)
 *    (1 3 5)     (-12)    (-12 1 3 5)
 *    (1 3 5 9)   (12)     (1 3 5 9 12)
 *    (1 3 5 9)   (3)      (1 3 3 5 9)
 */
void insertInOrder(ListType & list, Node *itemP);



/*
 * insertionSort
 *
 * PRE: list is a well-formed list
 *
 * sorts the list in increasing order using the insertion sort algorithm
 *
 * POST: isInOrder(list)
 *
 * NOTE: this function does not create or delete any nodes, but relinks up the
 * nodes in the original list.
 *
 * Examples:
 *
 *  list            list'
 *    ()            ()
 *    (7)           (7)
 *    (1 3 5)       (1 3 5)
 *    (8 2 7 9 5)   (2 5 7 8 9)
 *    (3 1 3 12 2)  (1 2 3 3 12)
 */
void insertionSort(ListType &list);



/*
 * splitEvenOdd
 *
 * PRE: list is a well-formed list
 *
 * splits list into two sub-lists. "a" will contain the first, third,
 * fifth, etc.  element from list.  And "b" will contain the second,
 * fourth, sixth, etc. element from list.  So, if there are an odd number
 * of nodes in list, "a" will end up with one more node than "b".  This
 * operation will destroy the list, because it reuses nodes from the
 * original list.  After the operation, list will be NULL.
 *
 * NOTE: this function does not create or delete any nodes, but reuses
 * nodes from the original list.
 *
 * Examples:
 *
 *  list           a        b
 *    ()           ()      ()
 *    (7)          (7)     ()
 *    (7 2)        (7)     (2)
 *    (1 3 5)      (1 5)   (3)
 *    (1 2 3 4)    (1 3)   (2 4)
 *    (1 2 3 4 5)  (1 3 5) (2 4)
 */
void splitEvenOdd(ListType &list, ListType &a, ListType &b);

//*************************************************************************

#endif
