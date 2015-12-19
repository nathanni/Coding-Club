package com.nathan.leetcode.medium;

/**
 * Created by Nathan on 12/17/2015.
 */

//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//        For example:
//
//        Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
//
//        Note:
//        The order of the result is not important. So in the above example, [5, 3] is also correct.
//        Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

public class SingleNumberIII {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,2};

        int [] arr = singleNumber(nums);
        for(int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] singleNumber(int[] nums) {

        int result = 0;
        for(int num :nums) {
            result ^= num;
        }

  /*      A Corner Case:
        When diff == numeric_limits<int>::min(),
        -diff is also numeric_limits<int>::min(). Therefore,
        the value of diff after executing diff &= -diff is still numeric_limits<int>::min().
        The answer is still correct.*/
        result &= -result;
        //result &= ~(result -1)


        int [] arr = {0,0};

        for(int num : nums) {
            if( (num & result) == 0) {
                arr[0] ^= num;
            } else {
                arr[1] ^= num;
            }
        }

        return arr;

    }
}
