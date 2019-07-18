package com.nathan.leetcode.easy;

import java.util.Arrays;

class TwoSum {

    class MyInteger implements Comparable<MyInteger> {
        int idx;
        int value;

        public MyInteger(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int compareTo(MyInteger o) {
            if (o == null) return 1;
            return this.value - o.value;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[2];
        }

        MyInteger[] myIntegers = new MyInteger[nums.length];

        for (int i = 0; i < nums.length; i++) {
            myIntegers[i] = new MyInteger(i, nums[i]);
        }

        Arrays.sort(myIntegers);

        int left = 0;
        int right = myIntegers.length - 1;

        while (left < right) {
            if (myIntegers[left].value + myIntegers[right].value == target) {
                return new int[]{myIntegers[left].idx, myIntegers[right].idx};
            }

            if (myIntegers[left].value + myIntegers[right].value < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[2];
    }
}