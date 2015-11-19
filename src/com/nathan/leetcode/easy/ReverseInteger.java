package com.nathan.leetcode.easy;

/*Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321*/

public class ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverse(1000000002));
  }

  public static int reverse(int x) {

/*    I got confused by the same question for really long, and know I got the answer. 
    (newResult - tail) / 10 != result is not universal for testing overflow.
    If the result of result*10 causes no overflow, but overflow only happens when it plus tail, 
    (newResult - tail) / 10 would still be the last-step result.
    That's why the method doesn't apply to puzzle 8. However, for this puzzle, such case is not possible.
    Because the largest number as an int is 2147483647. 
    The only cases that result in above-mentioned overflow are 2147483648 and 2147483649,
    but both would require original input(their reverse) to be out of int range.*/

int result = 0;
    while (x != 0) {
      int tail = x % 10;
      int newResult = result * 10 + tail;
      if((newResult - tail) / 10 != result) 
        return 0;
      result = newResult;
      x = x / 10;
    }

    return result;

  }
}
