package com.nathan.leetcode.easy;

/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.*/

public class MergeSortedArray {

  public static void main(String[] args) {
    int[] nums1 = { 0,0};
    int[] nums2 = { 1 };
    merge(nums1, 0, nums2, 1);
    for (int i : nums1) {
      System.out.print(i + " ");
    }
  }

  
  //leetcode solution,  compare from the end of the array
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n -1;
    while(i >= 0 && j >= 0) {
      if(nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
    
    while(j >= 0) {
      nums1[k--] = nums2[j--];
    }
    
    
  }
  
  //original stupid solution,  although no extra space, but code is too complex
  public static void merge1(int[] nums1, int m, int[] nums2, int n) {
    
    if(m == 0) {
      for(int i = 0; i < n; i ++) {
        nums1[i] = nums2[i];
      }
      return;
    }
    
    if(n == 0) {
      return;
    }

    // move nums1 to this end of the array, suppose the nums1 length is m+n
    for (int i = m - 1, j = m + n - 1; i >= 0; i--, j--) {
      nums1[j] = nums1[i];
    }

    for (int i = n, j = 0, k = 0; j < n;) {
      if (less(nums1[i], nums2[j])) {
        nums1[k++] = nums1[i++];
      } else {
        nums1[k++] = nums2[j++];
      }

      if (i == m + n) {
        while (j < n) {
          nums1[k++] = nums2[j++];
        }
        break;
      }
    }

  }

  private static boolean less(int i, int j) {
    return i <= j ? true : false;
  }
}
