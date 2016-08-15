package com.nathan.leetcode.utils;

/**
 * Created by Nathan on 8/14/2016.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {7, 123, 6, 5, 2, 1, 2, 0, -123, 22222, 2, 1, 5, 234, 1, 23, 6, -1, 321};
        sort(a);
        U.print(a);

    }


    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        heapify(nums);


        for (int j = nums.length - 1; j > 1; j--) {
            int temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;
            siftdown(nums, 0, j);
        }
    }

    private static void heapify(int[] nums) {

        for (int i = nums.length / 2; i >= 0; i--) {
            siftdown(nums, i, nums.length);
        }
    }

    private static void siftdown(int[] nums, int i, int len) {

        while (i < len) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            int largest = i;

            if (left < len && nums[i] < nums[left]) {
                largest = left;
            }
            if (right < len && nums[largest] < nums[right]) {
                largest = right;
            }

            if (largest == i) break;

            swap(nums, i, largest);

            i = largest;


        }
    }

    private static void swap(int[] nums, int i, int smallest) {

        int temp = nums[i];
        nums[i] = nums[smallest];
        nums[smallest] = temp;
    }


}
