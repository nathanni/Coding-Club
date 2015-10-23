package com.nathan.leetcode.medium;

import java.util.Arrays;


/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
*/public class KthLargestElementInAnArray {
  
  public static void main(String[] args) {
    int [] nums = {1,3,4,5,2,1};
    
    System.out.println(findKthLargestElement(nums, 3));
    System.out.println(findKthLargestElement2(nums, 3));
  }
  

  //O(n) Quick Select
  public static int findKthLargestElement(int[] nums, int k) {

    shuffle(nums);
    int lo = 0;
    int hi = nums.length - 1;
    k = nums.length - k;
    while (hi > lo) {
      int j = partition(nums, lo, hi);
      if (k < j) {
        hi = j - 1;
      } else if (k > j) {
        lo = j + 1;
      } else {
        return nums[k];
      }
    }

    return nums[k];

  }

    
  //knuth shuffle
  private static void shuffle(int[] nums) {
    
    for(int i = 0 ; i < nums.length; i++) {
      int randomNum = i + (int)Math.random() * (nums.length-i);
      exchange(nums, nums[i], nums[randomNum]);
    }
    
    
  }


  public static int partition(int[] nums, int lo, int hi) {
    int i = lo, j = hi +1;
    
    while(true) {
      
      while(less(nums[++i], nums[lo])) {
        if(i >= hi) 
          break;
      }
      
      while(less(nums[lo], nums[--j])) {
        if(j <= lo) {
          break;
        }
      }
      
      if(i >= j)
        break;
      
      exchange(nums, i, j);

    }
    
    exchange(nums, lo, j);
    
    return j;
  }
  
  public static void exchange(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
  }
  
  public static boolean less(int first, int second) {
    return first < second ? true: false;
  }

  
  
  
  
  
  //Sort O(nlogn + n)
  public static int findKthLargestElement2(int[] nums, int k) {
    Arrays.sort(nums);
    
    return nums[nums.length - k];
/*    if( k == 1) {
      return nums[0];
    }
    int n = 1;
    for(int i = 0; i < nums.length - 1; i++) {
      if(nums[i] != nums[i+1]) {
        ++n;
      }
      if(n == k) {
        return nums[i+1];
      }
    }
    
    return -1;*/
  }
}
