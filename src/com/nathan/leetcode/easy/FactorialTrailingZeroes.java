package com.nathan.leetcode.easy;

/*Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    
    int zeroes = 0;
    
    while( n/5 > 0) {
      zeroes += n /5;
      n /= 5;
    }
    
    return zeroes;
    
  }
}
