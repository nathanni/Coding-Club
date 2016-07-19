package com.nathan.leetcode.utils;

/**
 * Created by Nathan on 4/24/2016.
 */
public class Shuffle {

    public static void main(String[] args) {
        int[] nums = new int[]{4123, 1, 123, 1, 2, -3, 123, 423};
        shuffle(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private static void shuffle(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = (int) (i + Math.random() * (nums.length - i));

            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;

        }

    }
}
