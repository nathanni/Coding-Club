package com.nathan.leetcode.easy;

/*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class RemoveDuplicatesFromSortedArray {
  
  public static void main(String[] args) {
    int [] nums ={};
    System.out.println(removeDuplicates(nums));
    for(int i:nums) {
      System.out.print(i+" ");
    }
  }
  public static int removeDuplicates(int[] nums) {
    if(nums == null || nums.length == 0)
      return -1;

    int n  = 0;
    int temp = Integer.MIN_VALUE;
    for(int i : nums) {
      if (i != temp) {
        nums[n++] = i;
        temp = i;
      }
    }

    
    return n;
  }
}
