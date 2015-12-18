package com.nathan.leetcode.medium;

import java.util.Arrays;

/**
 * Created by nni on 12/18/2015.
 */

/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?*/
public class MissingNumber {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        System.out.println(missingNumber2(nums));
    }


    /*XOR*/
    public static int missingNumber1(int[] nums) {
        int result = nums.length;
        int i = 0;

        for(int num : nums) {
            result ^= num;
            result ^= i++;
        }
        return result;
    }

    /*SUM*/
    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = (0+n)*(n+1)/2;
        for(int num : nums) {
            sum -= num;
        }
        return sum;
    }

    /*BINARY*/
    public int missingNUmber3(int[] nums) {
        Arrays.sort(nums);
        int left = 0; int right = nums.length; int mid = ( left + right) /2;
        while(left < right) {
            mid = (left + right) /2;
            if(nums[mid] > mid) right =mid;
            else left = mid +1;
        }

        return left;
    }



}
