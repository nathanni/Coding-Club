package com.nathan.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].*/

public class SummaryRanges {
  public static void main(String[] args) {

    int [] nums = {-2147483648,-2147483647,2147483647};
    System.out.println(summaryRanges(nums));
  }

  public static List<String> summaryRanges(int[] nums) {
    
    if (nums == null || nums.length == 0) return new ArrayList<>();

    int startNum = nums[0];
    int endNum = nums[0];

    List<String> list = new ArrayList<>();

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i-1] + 1) {
        list.add(startNum == endNum ? startNum + "" : startNum + "->" + endNum);
        startNum = nums[i];
        endNum = nums[i];
      } else {
        endNum = nums[i];
      }
    }
    list.add(startNum == endNum ? startNum + "" : startNum + "->" + endNum);
    return list;

  }
}
