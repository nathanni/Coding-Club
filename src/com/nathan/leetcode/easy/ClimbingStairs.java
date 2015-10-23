package com.nathan.leetcode.easy;

public class ClimbingStairs {

  /*
   * You are climbing a stair case. It takes n steps to reach to the top.
   * 
   * Each time you can either climb 1 or 2 steps. In how many distinct ways can
   * you climb to the top?
   */

  
  //Dynamic Programming
  public static int climbStairs(int n) {
    //need this for outofbonds exception.  
    if (n == 0 || n == 1 || n == 2 || n == 3)
      return n;

    int[] a = new int[n];

    a[0] = 1;
    a[1] = 2;
    a[2] = 3;

    for (int i = 3; i < n; i++) {
      a[i] = a[i - 1] + a[i - 2];
    }
    return a[n - 1];

  }
}
