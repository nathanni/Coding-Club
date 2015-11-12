package com.nathan.leetcode.utils;

public class SelectionSort {
  
  
  
  

  public static void sort(int[] a) {
    int n = a.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (U.less(a[j], a[i])) {
          U.exch(a, i, j);
        }
      }
    }
  }

}
