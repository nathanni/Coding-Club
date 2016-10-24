package com.nathan;

/**
 * Created by nni on 10/24/2016.
 */
public class BinarySearchInRecursion {
    public int findPosition(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) return -1;


        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (start + 1 >= end) {
            if (nums[start] == target) return start;
            else if (nums[end] == target) return end;
            else return - 1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] >= target) {
            return binarySearch(nums, target, start, mid);
        } else {
            return binarySearch(nums, target, mid, end);
        }
    }
}
