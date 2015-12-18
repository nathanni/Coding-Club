package com.nathan.leetcode.medium;

/**
 * Created by nni on 12/18/2015.
 */


/*Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)*/

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = {0,1};
        int [] arr= productExceptSelf(nums);
        for(int n : arr) {
            System.out.println(n);
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        if(nums.length == 0 || nums == null) return nums;

        int n = nums.length; //array length
        int [] arr = new int[n];
        arr[0] = 1;

        for(int i = 1; i < n; i ++) {
            arr[i] = arr[i-1] * nums [i-1];
        }


        for(int i = n-2; i >=0 ; i--) {
            arr[i] = arr[i] * nums[i+1];
            nums[i] = nums[i] * nums[i+1];
        }

        return arr;
    }

}
