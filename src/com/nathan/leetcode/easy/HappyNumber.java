package com.nathan.leetcode.easy;

import java.util.HashSet;

/*Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1*/


//C solution without hashset
/*int digitSquareSum(int n) {
  int sum = 0, tmp;
  while (n) {
      tmp = n % 10;
      sum += tmp * tmp;
      n /= 10;
  }
  return sum;
}

bool isHappy(int n) {
  int slow, fast;
  slow = fast = n;
  do {
      slow = digitSquareSum(slow);
      fast = digitSquareSum(fast);
      fast = digitSquareSum(fast);
      if(fast == 1) return 1;
  } while(slow != fast);
   return 0;
}*/







public class HappyNumber {
  
  public static void main(String[] args) {
    System.out.println(isHappy(3));
  }
  public static boolean isHappy(int n) {
    
    HashSet<Integer> hashSet = new HashSet<>();
    
    if(n <= 0) {
      return false;
    }
    
    while(n != 1) {
      int m = n;
      n = 0;
      while (m > 0) {
        n += (m%10) * (m%10);
        m = m / 10;
      }
      if(!hashSet.add(n)) {
        return false;
      }
      
    }
    
    return true;
    
    
  }
  

}
