package com.nathan.leetcode.utils;

public class QuickSort {
  
  public static void main(String[] args) {
    int [] a= {2,1,5};
    partition(a, 0, 2);
    U.print(a);
  }
  
  
  public static void sort(int [] a) {
    
  }
  
  public static int partition(int [] a, int lo, int hi ) {
    int i = lo;
    int j = hi + 1;
    
    while(true) {
      
      while(U.less(a[++i], a[lo])) {
        if(i == hi) break;
      }
      
      while(U.less(a[lo], a[--j])) {
        if(j == lo) break;
      }
      
      if (i >= j) break;
      
      U.exch(a, i, j);
    }
    
    U.exch(a, lo, j);
    return j;
  }

}
