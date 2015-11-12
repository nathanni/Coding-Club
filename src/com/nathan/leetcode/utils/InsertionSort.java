package com.nathan.leetcode.utils;

public class InsertionSort {

  public static void sort(int[] a) {
    
    for(int i = 0; i < a.length; i++) {
      for(int j = i; j > 0; j--) {
        if(U.less(a[j], a[j-1])){
          U.exch(a, j-1, j);
        }
      }
    }
  }

}
