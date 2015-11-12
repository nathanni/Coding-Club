package com.nathan.leetcode.utils;

public class U {

  public static boolean less(int a, int b) {
    return a <= b ? true : false;
  }

  public static void exch(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  public static void print(int [] a) {
    for(int i : a) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
  
}
