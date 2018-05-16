#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

vector<int> readVals();
void printVals(vector<int> v);

int main(int argc, char *argv[]) {
/*
  if (argc != 2) {
    cout << "usage: ./testVec filename" << endl;
    return 0;
  }
  string name = argv[1];
  ifstream infile;
  infile.open(name.c_str(), ios::in);
  if (!infile) {
    cout<<"file not found\n";
    return -1;
  }
  vector<int> myVector = readVals(infile);
*/
  vector<int> myVector = readVals();
  printVals(myVector); 
  //infile.close();
  return 0;
}

vector<int> readVals() {
  vector<int> data;
  int input;
  while (cin >> input) {
    data.push_back(input);
  }
  if (!cin.eof()) {
    cout << "ERROR: failed because input value was non-numeric" << endl;
    exit(1);
  }
  return data;
}

void printVals(vector<int> v) {
  for (size_t i = 0; i < v.size(); ++i) {
    cout << v[i] << " ";
  }
  cout << endl;
}


