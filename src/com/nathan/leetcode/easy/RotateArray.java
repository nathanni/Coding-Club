package com.nathan.leetcode.easy;


/*Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].*/

public class RotateArray {
  
  public static void main(String[] args) {
    int [] nums = {1,2,3,4,5,6,7};
    rotate3(nums, 3);
    
    for(int i : nums) {
      System.out.print(i + " ");
    }
    
    
  }
  
  
  
  //reverse solution
  public static void rotate3(int[]nums, int k) {
    
    if(k%nums.length == 0 ||  nums.length==0) return;
    k = k % nums.length;  //很重要 要取模 不然可能会溢出
    reverse(nums, 0, nums.length-k-1);
    reverse(nums, nums.length-k, nums.length-1);
    reverse(nums, 0, nums.length-1);
    
    
  }
  
  public static void reverse(int [] nums, int start, int end) {
    
    while(start<=end){
      int temp = nums[start];
      nums[start++] = nums[end];
      nums[end--] = temp;
    }
    
  }
  
  //in place  需要深刻理解
  public static void rotate2(int[] nums, int k) {
    if(nums.length == 0 || k % nums.length == 0) return;
    
    int n = nums.length;
    
    while(n > 1 && (k %= n) > 0) {
      int range = n - k;
      
      //put n - k elements to the final place in the end; start from the last element
      for(int i = 1; i <= range; i++) {
        int temp = nums[n-i];
        nums[n-i] = nums[n-i-k];
        nums[n-i-k] = temp;
      }
      
      n = k;
      k = n - (range%k);
    }
    
  }
  
  
  
  //create a new array , time o(N) 
  public static int[] rotate1(int[] nums, int k) {
    int [] rotatedNums = new int[nums.length];
    int j = k;
    int l = 0;
    for(int i = 0; i < rotatedNums.length; i++) {
      
      if(j > 0)
        rotatedNums[i] = nums[nums.length - j--];
      else {
        rotatedNums[i] = nums[l++];
      }
      
    }
    
    return rotatedNums;
  }
}
