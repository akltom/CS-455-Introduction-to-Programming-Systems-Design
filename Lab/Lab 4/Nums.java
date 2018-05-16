

/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/


//package lab4;

import java.util.ArrayList;

public class Nums {

         /**
    Create an empty sequence of nums.
  */
 public Nums () {
  nums = new ArrayList<Integer> ();
 } 

 /**
    Add a value to the end of the sequence.
  */
 public void add(int value) {
         nums.add(value);
 }


 /**
    Return the minimum value in the sequence.
    If the sequence is empty, returns Integer.MAX_VALUE
  */
 public int minVal() {
	 int min=Integer.MAX_VALUE; // set default
        
     for(int a=1;a<nums.size();a++){
    	 if(nums.get(a)<min)
	     {
    		 min = nums.get(a);
	     }
	 }
	 return min; 
 }
         
         
        
           // stub code to get it to compile

 


 /**
    Prints out the sequence of values as a space-separated list 
    on one line surrounded by parentheses.
    Does not print a newline.
    E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
 */
 public void printVals() {
         System.out.print("(");
         for(int i=0;i<nums.size();i++)
         {
        	 if(i==nums.size()-1)
             {
        		 System.out.print(nums.get(i));
             }
             else
             {
                 System.out.print(nums.get(i)+" "); 
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
         Nums second = new Nums();
         for(int b=0; b<nums.size();b++)
         {
                 if(nums.get(b)>threshold)
                 {
                         second.add(nums.get(b));
                 }
         }
        return second;  // stub code to get it to compile

 }

private ArrayList<Integer> nums;

}










