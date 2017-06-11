package com.nathan.leetcode.utils;


import java.util.Random;

public class QuickSort {
  
  public static void main(String[] args) {
    int [] a= {7,123,6,5,2,1,2,0,-123,22222,2,1,5,234,1,23,6,-1,321};
    sort(a);
    U.print(a);

  }

  public static void sort(int [] nums) {
    if(nums == null || nums.length == 0) return;

    shuffle(nums);
    quickSort(nums, 0, nums.length - 1);

  }

  public static void quickSort(int [] nums, int lo, int hi) {
    if (lo >= hi) return;

    int j = partition(nums, lo, hi);

    quickSort(nums, lo, j - 1);
    quickSort(nums, j + 1, hi);

  }

  public static int partition (int [] nums, int lo, int hi) {

    int pivot = nums[lo];

    while (lo < hi) {
      while (lo < hi && nums[hi] >= pivot) {
        hi--;
      }
      nums[lo] = nums[hi];

      while (lo < hi && nums[lo] <= pivot) {
        lo++;
      }

      nums[hi] = nums[lo];



    }

    nums[lo] = pivot;

    return lo;


  }


  public static void shuffle(int [] nums) {
    for (int i = 0; i < nums.length; i++) {
      int random = i + (int)(Math.random() * (nums.length - i));

      int temp = nums[i];
      nums[i] = nums[random];
      nums[random] = temp;
    }
  }

  public void shuffle2(int[] nums) {
    Random r = new Random();
    for (int i = 0; i < nums.length; i++) {
      int idx = i + r.nextInt(nums.length - i);
      int temp = nums[i];
      nums[i] = nums[idx];
      nums[idx] = temp;
    }
  }

}
