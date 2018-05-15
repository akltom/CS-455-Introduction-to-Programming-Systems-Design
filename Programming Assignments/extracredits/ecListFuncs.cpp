/*  Name: King Lun Au
 *  loginid: kingluna
 *  CS 455 Spring 2016, Extra Credit assignment
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


bool isInOrder(ListType list) {
    int cmp = INT_MIN;
    ListType p = list;
    while(p != NULL) {
		if(p->data < cmp) {
			return false;
		}
		cmp = p->data;
		p = p->next;
	}
	return true;
    
}



void insertInOrder(ListType & list, Node *itemP) {
  assert(isInOrder(list));     // checks the preconditions
  assert(itemP->next == NULL);
  // add the rest of the code after this line

    if (list == NULL) { // If the list has 0 elements
  		list = itemP;
  	}
  	else if (list->data > itemP->data) { // If the list has 2 elements, the input is less than the current list 
		itemP->next = list;
  		list = itemP;
  	}
  	else {
  		ListType p = list;
  		while (p->next != NULL) {
  			if (p->next->data > itemP->data) {  
				itemP->next = p->next; // Connect the remained list after that itemP value
				p->next = itemP;  // Add the itemP after a value in the list
				return;
  			}
  		p = p->next;		
  		}	
  	p->next = itemP;
  	}

}



void insertionSort(ListType &list) {
	ListType item = NULL;
	ListType tempList = NULL;
	ListType p = list;
	if (list == NULL) {
		return;
	}
	while (p->next != NULL) {
		item = p;
		p = p->next;
		item-> next = NULL;
		insertInOrder(tempList, item);
		
	}
	item = p; // Run forthe last time
	p = p->next;
	item-> next = NULL;
	insertInOrder(tempList, item);
	list = tempList;
}
	


void splitEvenOdd(ListType &list, ListType &a, ListType &b){ 
	ListType p = list;
	ListType aHead = NULL; // The first integer from the list
	ListType bHead = NULL; // The second integer from the list
	ListType aTemp = NULL; // A temp to run the program, because useing a and b will generate their addresses (&a, &b) in the parameters, which will be wrong in main.
	ListType bTemp = NULL;
	if (p == NULL) { // If the list is empty
		return;
	}
	
	aHead = p; // The first integer
	bHead = p->next; // The second integer
	
	if (bHead == NULL) { // If the list contain only one element
		return;
	}
	
	p = p->next->next; // We have considered first 2 nodes, so start from 3rd node
	
	a = aHead;
	aTemp = aHead;
	b = bHead;
	bTemp = bHead;
	 
	int t = 1; // To make alternate
	
	for(; p != NULL; p =p->next, t*=-1) { // First one empty, which I use above t=1 for initializing, [p =p->next, t*=-1 are doing in the same time, as , included]
		if (t == 1 ) {
			aTemp->next = p;  // 
			aTemp = aTemp->next;
		}
		else {
			bTemp->next = p;
			bTemp = bTemp->next;
		}
	}
	aTemp->next = NULL;
	bTemp->next = NULL;
	list = NULL;
}
