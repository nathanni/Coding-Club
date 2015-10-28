package com.nathan.leetcode.easy;


/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.*/

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    
    for(int i = 0, j = 0, k = m + n -1; i < m + n;) {
      if(less(nums1[i], nums2[j])) {
        ++i;
      } else {
        nums1[k--] = nums1[i];
        nums1[i++] = nums2[j++];
      }
      
      if(j == n) {
        ++k;
        for(int l = i; l < m+ n; l++, k--) {
          nums1[l] = nums1[k];
        }
        break;
      }
    }
  }

  private boolean less(int i, int j) {
    return i <= j ? true: false;
  }
}
