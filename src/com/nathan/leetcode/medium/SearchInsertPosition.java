package com.nathan.leetcode.medium;

/**
 * Created by nni on 12/18/2015.
 */

/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Subscribe to see which companies asked this question*/
public class SearchInsertPosition {
    public static void main(String[] args) {
        int [] nums = {1} ;
        System.out.println(searchInsert(nums,1));
    }
    public static int searchInsert(int[] nums, int target) {

        int left = 0; int right = nums.length -1;

        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > target) right = mid -1;
            else if(nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return target> nums[left]?left +1:left;


    }
}
