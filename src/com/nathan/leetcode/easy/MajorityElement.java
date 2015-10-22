package com.nathan.leetcode.easy;

import java.util.Arrays;

/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.*/

public class MajorityElement {
  
  public static void main(String[] args) {
    int [] nums = {7,3,2,3,2,2};
    System.out.println(majorityElement(nums));
  }
  
  
  //bit Manipulation 
  public static int majorityElement(int[] nums) {
    
    int major = 0;
    int mask = 1;
    
    int n = nums.length;
    for(int i = 0; i < 32; i++, mask <<= 1) {
      int count = 0;
      for(int j = 0; j < n; j++) {
        if((nums[j] & mask) > 0) {
          count ++;
        } 
        if(count > n/2) {
          major |= mask;
          break;
        }
      }
    }
    
    return major;
    
    
  }
  
  //Moore majority voting algorithm
  
  public static int majorityElement1(int[] nums) {
    
    if(nums == null) {
      return -1;
    }
    
    int candidate = 0;
    int count = 0;
    for (int i: nums) {
      if(count == 0) {
        candidate = i;
        count = 1;
      } else {
        if(candidate == i) {
          ++count;
        } else {
          --count;
        }
      }
    }
    
    count = 0;
    for(int i: nums) {
      if(candidate == i) {
        ++count;
      }
    }
    
    if(count > nums.length/2) {
      return candidate;
    } else {
      return -1;
    }
    
  }
  
  //my solution
  public static int majorityElement2(int[] nums) {
    if(nums == null) {
      return -1;
    }
    if(nums.length < 2) {
      return nums[0];
    }

    Arrays.sort(nums);
    int checker = 1;
    System.out.println((double)nums.length/2 );
    for(int i = 0 ; i < nums.length; i ++) {
      if(checker > (double)nums.length/2 ) {
        return nums[i];
      }
      
      if((i!=nums.length-1) && (nums[i] == nums[i+1])) {
        checker++;
      } else {
        checker = 1;
      }

    }
    
    return -1;
  }
  
  //2 line solution
  public int majorityElement3(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}
}
