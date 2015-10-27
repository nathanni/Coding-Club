package com.nathan.leetcode.easy;


/*Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
public class RemoveElement {
  
  
  public static void main(String[] args) {
    int[] nums = {6,6,6,6,6,5123,2,1,5,6,24,6,7,213,4,5,7,6,6,6,2123};
    System.out.println(removeElement(nums, 6));
    for(int i : nums) {
      System.out.print(i + " ");
    }
    
    
  }
  
  public static int removeElement(int[]nums, int val) {
    int i = 0;
    for(int n : nums) {
      if(n != val) {
        nums[i++] = n;
      }
    }
    
    return i;
  }
  
  
  //my solution, too complex
  public static int removeElement2(int[] nums, int val) {
    
    int pos = -1; //value position
    int instance = 0; //count how many instance 
    int length = nums.length;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == val) {
        if(pos == -1) pos = i;
        else ++instance;
        --length; 
      } else if(pos != -1) {
          exchange(nums, i, pos);
          pos = i-instance;
          //exchange when pos is not -1
      }
      
    }
    return length;
    
  }

  private static void exchange(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
    
  }
  
 
}
