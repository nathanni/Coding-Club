package com.nathan.leetcode.easy;

import java.util.Arrays;
import java.util.Hashtable;

/*Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.*/
public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 223, 2123, 12, 32, 2123 };
    System.out.println(containsDuplicate(nums));
    System.out.println(containsDuplicate2(nums));
  }

  public static boolean containsDuplicate(int[] nums) {
    if (nums.length < 2) {
      return false;
    } else {
      int i, j = 0;
      Arrays.sort(nums);
      for (i = 0; i < (nums.length - 1); i++) {
        if (nums[i] == nums[i + 1]) {
          j = 1;
          break;
        }
      }
      if (j == 1) {
        return true;
      } else {
        return false;
      }
    }
  }

  // use hash table
  public static boolean containsDuplicate1(int[] nums) {
    Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
    for (int i : nums) {
      if (hashtable.containsKey(i)) {
        return true;
      } else {
        hashtable.put(i, true);
      }
    }
    return false;
  }

  // Time Limit Exceeded
  public static boolean containsDuplicate2(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;

  }

  // only for the nums array whose values are not larger than 32(int, 32 bits)
  public static boolean containsDuplicate3(int[] nums) {
    int checker = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((checker & (1 << nums[i])) != 0) {
        return true;
      }
      checker |= 1 << nums[i];
    }
    return false;
  }
}
