

#include <iostream>
#include <fstream>
#include <vector>
#include <string>
// for setw
#include <iomanip>
//#include <climits>
//cout << INT_MAX << endl;
using namespace std;

vector<int> readVals();
void printVals(vector<int> v);
vector<int> valsGT0(vector<int> v);
int findLast(vector<int> v, int target);
void testFindLast(vector<int> v, int target);

int main(int argc, char *argv[]) {
  vector<int> myVector = readVals();
  vector<int> filteredVector = valsGT0(myVector);
  cout << "Filtered vector " << endl;
  printVals(filteredVector);
  cout << "Original vector " << endl;
  printVals(myVector);
  testFindLast(myVector,123 );
  testFindLast(myVector,-43 );
  testFindLast(myVector,41 );
  testFindLast(myVector,-135 );
  testFindLast(myVector,-50 );
  testFindLast(myVector,103 );
  return 0;
}

vector<int> readVals() {
  vector<int> data;
  int input;
  cout << "Vector:";
  while (cin >> input) {
    data.push_back(input);
    cout << " " << input;
  }
  if (!cin.eof()) {
    cout << "ERROR: failed because input value was non-numeric" << endl;
    exit(1);
  }
  cout << endl;
  return data;
}

void printVals(vector<int> v) {
  cout << "index: ";
  for (size_t i = 0; i < v.size(); ++i) {
    cout << setw(5) << i;
  }
  cout << endl;
  cout << "value: ";
  for (size_t i = 0; i < v.size(); ++i) {
    cout << setw(5) << v[i];
  }
  cout << endl;
}

// returns a vector of values from v that are greater than 0
// these values are in the same relative order as they are in v.
vector<int> valsGT0(vector<int> v) {
  vector<int> result;
  for (size_t i = 0; i < v.size(); i++) {
    if (v[i] > 0) {
      result.push_back(v[i]);
    }
  }
  return result;
}

void testFindLast(vector<int> v, int target) {
  cout << "find " << target << endl;
  cout << target << " at index "  << findLast(v,target) << endl;
}

/**
 * returns location of last instance of target in v or -1 if not found
 */ 
int findLast(vector<int> v, int target) {
  for (int i = v.size() - 1; i >= 0; i--) {
    if (target == v[i]) {
      return i;
    }
  }
  return -1;
}

