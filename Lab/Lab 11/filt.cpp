#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

vector<int> readVals(ifstream &infile);
void printVals(vector<int> v);
vector<int> valsGT0(vector<int> v);

int main(int argc, char *argv[]) {
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
  printVals(myVector);
  vector<int> filteredVector = valsGT0(myVector);
  printVals(filteredVector);
  infile.close();
  return 0;
}

vector<int> readVals(ifstream &infile) {
  vector<int> data;
  size_t input;
  while (infile >> input) {
    data.push_back(input);
  }
  return data;
}

void printVals(vector<int> v) {
  for (size_t i = 0; i < v.size(); ++i) {
    cout << v[i] << " ";
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

