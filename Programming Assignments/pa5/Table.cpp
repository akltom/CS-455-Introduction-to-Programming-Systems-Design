// Name: King Lun Au
// Loginid: kingluna
// CSCI 455 PA5
// Spring 2016

// Table.cpp  Table class implementation


/*
 * Modified 11/22/11 by CMB
 *   changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

#include <cstdlib>

// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

// create an empty table, i.e., one where numEntries() is 0
// (Underlying hash table is HASH_SIZE.)
Table::Table() {
  hashTable = new ListType[HASH_SIZE]();
  hashSize = HASH_SIZE; // Initialize the hash size by deafult size.
  for(int i = 0; i < hashSize; i++) {  
  	hashTable[i] = NULL; 
  }
}

// create an empty table, i.e., one where numEntries() is 0
// such that the underlying hash table is hSize
Table::Table(unsigned int hSize) {
  hashSize = hSize; 
  hashTable = new ListType[hashSize](); // Initialize the hash size by input value.
  for(int i = 0; i < hashSize; i++) {  
  	hashTable[i] = NULL;
  }
}

// insert a new pair into the table
// return false iff this key was already present 
//         (and no change made to table)
bool Table::insert(const string &key, int value) {
  int keyIndex = hashCode(key);
  return insertInList(hashTable[keyIndex],key,value) ;
}

// returns the address of the value or NULL if key is not present
int * Table::lookup(const string &key) {
  int keyIndex = hashCode(key);
  int * valueOfKey;
  if(hashTable[keyIndex] == NULL) {   // If Node* doesn't point to any where, which means no entry.
  	return NULL;
  }
  else { // If Node* can point to a key.
  	valueOfKey = lookUpList(hashTable[keyIndex], key);  
  }
  return valueOfKey;
}

// remove an element
// false iff element wasn't present
bool Table::remove(const string &key) {
  int keyIndex = hashCode(key);
  bool deter = removeNode(hashTable[keyIndex], key); // Determine if I can remove the node successfully
  if (deter == true) { // If the key can be removed, return true.
    return true;
  } 
  else { 
  	return false;
  }
}

// print out all the entries in the table, one per line.
// Sample output:
//   joe 32
//   sam 273
//   bob 84
void Table::printAll() const {
  for(int i = 0; i < hashSize ; i++) {
    printAllList(hashTable[i]);
  }	
}

// number of entries in the table
int Table::numEntries() const {
  int numEntr = 0;
  for (int i = 0; i < hashSize; i++) {
  	numEntr += getNumEntries (hashTable[i]); // Get the number of entries for each bucket, and sum up all the bucket eventually.
  }
  return numEntr;      
}

// hashStats: for diagnostic purposes only
// prints out info to let us know if we're getting a good distribution
// of values in the hash table.
// Sample output from this function
//   number of buckets: 997
//   number of entries: 10
//   number of non-empty buckets: 9
//   longest chain: 2
void Table::hashStats(ostream &out) const {
  out << "grades " << hashSize << endl;
  out << "number of buckets: " << hashSize << endl;
  out << "number of entries: " << Table::numEntries() << endl;
  out << "number of non-empty buckets: " << Table::findNumNonEmpBuckets() << endl;
  out << "longest chain: " << Table::findLongestChain() << endl;
}

// add definitions for your private methods here

// Find and return the number of non-empty buckets.
int Table::findNumNonEmpBuckets() const {
  int numNonEmptyBucket = 0;
  int zero = 0; // Mean there are zero entry in that bucket 
  int numEntrPerBucket;
  for (int i = 0; i < hashSize; i++) {
  	numEntrPerBucket = getNumEntries (hashTable[i]); 
    if (numEntrPerBucket > zero) { // If there are entries in that bucket, count it
        numNonEmptyBucket++ ; 
	}
  }
  return numNonEmptyBucket;
}

// Find and return the number of longest chain.
int Table::findLongestChain() const {
  int numLongestChain = 0;
  int numEntrPerLine;
  for (int i = 0; i < hashSize; i++) {
  	numEntrPerLine = getNumEntries (hashTable[i]);
    if (numLongestChain < numEntrPerLine) {
        numLongestChain = numEntrPerLine;
    }
  }
  return numLongestChain;
}


