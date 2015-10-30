package com.nathan.leetcode.easy;

import java.util.HashMap;

/*Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.*/

public class ContainsDuplicateII {

  public static void main(String[] args) {

    int[] nums = {1,3,2,6,1};
    System.out.println(containsNearbyDuplicate(nums,4));
  }

  public static boolean containsNearbyDuplicate(int[] nums, int k) {

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (hashMap.containsKey(nums[i])) {
        if (i - hashMap.get(nums[i]) <= k) {
          return true;
        }
      }
      hashMap.put(nums[i], i);
    }
    return false;
  }
}
