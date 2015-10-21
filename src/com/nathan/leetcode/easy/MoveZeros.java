package com.nathan.leetcode.easy;

/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/

public class MoveZeros {
  
  public static void main(String[] args) {
    int[] arr = {0,1,0,3,2};
    print(arr);
    moveZeroes(arr);
    print(arr);
  }
  
    
  public static void print(int [] arr) {
    for(int i : arr) {
      System.out.print(i +" ");
    }
    System.out.println();
  }
  
  public static void moveZeroes(int[] nums) {
    int zeroCount = 0;
    int j = 0; //for in-place;
    
    for(int i = 0 ; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroCount ++;
      } else {
        nums[j++] = nums[i]; 
      }
    }
    
    for(int i = 0 ; i < zeroCount; i++) {
      nums[j++] = 0;
    }
    
  }
}
