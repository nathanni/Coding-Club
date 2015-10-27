package com.nathan.leetcode.easy;

/*Given an integer, write a function to determine if it is a power of two.*/

public class PowerOfTwo {
  
  //fastest solution in leetcode 
  public boolean isPowerOfTwo(int n) {
    return n <=0 ?false:((n&(n-1)) == 0);
  }
  
  
  //my solution
  public boolean isPowerOfTwo2(int n) {
    if(n <=0 ) return false;
    
    
    for(int i = 0; i < 32; i++) {
      if( n == 1<<i) {
        return true;
      }
    }
    
    return false;
    
  }
}
