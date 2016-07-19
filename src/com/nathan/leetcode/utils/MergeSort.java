package com.nathan.leetcode.utils;

/**
 * Created by Nathan on 4/24/2016.
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] arr = new int[] {1,7,5,2,2123,1,77,0};
        sort(arr);
        for(int i : arr) {
            System.out.println(i);
        }

    }

    public static void sort(int [] nums) {
        int [] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);

    }

    private static void mergeSort(int[] nums, int[] temp, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;

        mergeSort(nums, temp, lo, mid);
        mergeSort(nums, temp, mid + 1, hi);
        merge(nums, temp, lo, mid, hi);
    }

    private static void merge(int[] nums, int[] temp, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            temp[k] = nums[k];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) nums[k] = temp[j++];
            else if (j > hi) nums[k] = temp[i++];
            else if (temp[i] <= temp[j]) nums[k] = temp[i++];
            else nums[k] = temp[j++];
        }
    }

}
