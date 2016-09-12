package com.nathan.leetcode.medium;

/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more bittiger.

More bittiger:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

public class MaximumSubarray {
  public static void main(String[] args) {
    int [] a = {1,-2,3,10,-4,7,2,-5};
    int [] b = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(b));
  }
  //java solution, O(n), but seems like not accepted by Leetcode, need to be improved
  public static int maxSubArray(int[] nums) {
    int maxSum = 0;
    int sum = 0;
    int flag = 0;
    int maxNum = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        ++flag;
      }
      if (nums[i] > maxNum) {
        maxNum = nums[i];
      }
      sum += nums[i];
      if (sum >= maxSum) {
        maxSum = sum;
      } else if (sum < 0) {
        sum = 0;
      }
    }

    if (flag == nums.length) {
      return maxNum;
    }
    return maxSum;
  }
  
  
/*  //C solution, accepted by leetcode
  int maxSubArray( int* a, int n )
  {
    int sum = 0;             用于记录最大的连续子数组和 
    int flag  = 0;             用于记录负数的个数 
    int MaxNum  = *a;            用于记录数组中最大的数 
    int ThisSum = 0;             用于记录当前的连续子数组和 
    for ( int i = 0; i < n; ++i )
    {
      if ( a[i] < 0 )          如果无素为负数，则把flag的值加1 
        ++flag;
      if ( MaxNum < a[i] )     记录数组当前的最大值 
        MaxNum = a[i];
      ThisSum += a[i];         累加更新当前的子数组之和 
      if ( ThisSum > sum )
      {
        
         * 若当前连续子数组之和大于记录的子数组之和
         * 则设置最大连续子数组之和为当前的和
         
        sum = ThisSum;
      }else if ( ThisSum < 0 )
      {
        
         * 如果当前连续子数组之和小于0，则抛弃之前的连续子数组，
         * 从此元素的下一个元素重新计算连续子数组之和
         
        ThisSum = 0;
      }
    }
     若全是负数，最大值为数组中的最大无素 
    if ( flag == n )
      sum = MaxNum;
    return(sum);

    return(0);
  }*/
}
