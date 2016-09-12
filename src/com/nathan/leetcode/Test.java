package com.nathan.leetcode;

public class Test {

    public static void main(String[] args) {

        Test test = new Test();


        System.out.println(test.reversePairs(new int[]{2, 4, 1, 3, 5}));

    }

    public long reversePairs(int[] A) {
        if (A == null || A.length == 0) {
            return (long)0;
        }

        long result = reverseHelper(A, 0, A.length - 1);
        return result;
    }

    private long reverseHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return (long)0;
        }
        int middle = start + (end - start) / 2;

        long pairsLeft = reverseHelper(nums, start, middle);
        long pairsRight = reverseHelper(nums, middle + 1, end);
        return mergePairs(nums, start, middle, end) + pairsLeft + pairsRight;
    }

    private long mergePairs(int[] nums, int start, int middle, int end) {
        int pairs = 0;
        int left = start;
        int right = middle + 1;

        int[] temp = new int[nums.length];

        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }


        for (int k = start; k <= end; k++) {
            if (left > middle) nums[k] = temp[right++];
            else if (right > end) nums[k] = temp[left++];
            else if (temp[left] > temp[right]) {
                pairs += middle - left + 1;
                nums[k] = temp[right++];
            } else {
                nums[k] = temp[left++];
            }
        }

        return pairs;



    }

}