package com.nathan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int[] arr = {2, 1, 1, 0};

        List<Integer> result = test.countSmaller(arr);
        for (Integer i : result) {
            System.out.println(i);
        }
    }


    public List<Integer> countSmaller(int[] nums) {



        Integer[] arr = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();


        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            sorted.add(index, nums[i]);
            arr[i] = index;
        }
        return Arrays.asList(arr);
    }

    public int findIndex(List<Integer> sorted, int target) {
        int start = 0, end = sorted.size() - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (sorted.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (sorted.get(start) >= target) return start;
        else if (sorted.get(end) >= target) return end;
        else return end + 1;


    }

}