
/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
import java.util.ArrayList;

public class Nums2 {
    /**
       Create an empty sequence of nums.
     */
    public Nums2 () {
       nums = new ArrayList<Integer>();
    }

    /**
       Add a value to the end of the sequence.
     */
    public void add(int value) {
        nums.add(value);
        if(value < minNum) {
            minNum = value;
        }
    }

    /**
       Return the minimum value in the sequence.
       If the sequence is empty, returns Integer.MAX_VALUE
     */
    public int minVal() {
        if(nums.size() != 0) {
            return minNum;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /**
       Prints out the sequence of values as a space-separated list 
       on one line surrounded by parentheses.
       Does not print a newline.
       E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
    */
    public void printVals() {
        int len = nums.size();
        System.out.print("(");
        for(int i = 0; i < len; i++) {
          System.out.print(nums.get(i));
          if(i < len - 1 ) {
            System.out.print(" ");
          }
        }
        System.out.println(")");
    }

    /**
       Returns a new Nums object with all the values from this Nums
       object that are above the given threshold.  The values in the
       new object are in the same order as in this one.
       E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
             returns      (19 21 19)
             myNums after call:  (3 7 19 4 21 19 10)
       This method does not modify the object the method is called on.
     */
    public Nums valuesGT(int threshold) {

        return new Nums();  // stub code to get it to compile

    }

    // private data section
    private ArrayList<Integer> nums;     // arraylist of number
    private int minNum;                  // record of the minimum number 
}

