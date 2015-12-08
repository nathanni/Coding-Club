package com.nathan.leetcode.easy;

/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.*/

public class StringToIntegerATOI {

  public static void main(String[] args) {

    System.out.println(myAtoi("                 -  12123123124234234234233+ass    a1234asds"));
  }

  public static int myAtoi(String str) {

    // return 0 if str is empty
    if (str == null || str.length() == 0)
      return 0;

    int index = 0, sign = 1, total = 0;

    // eliminate white space
    while (str.charAt(index) == ' ' && index++ < str.length());

    //determine sign
    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
      sign = str.charAt(index) == '+' ? 1 : -1;
      index++;
    }

    //convert number and avoid overflow. 
    while (index < str.length()) {
      int digit = str.charAt(index++) - '0';
      if (digit < 0 || digit > 9) break;

      //overflow handle, very important
      if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      total = total * 10 + digit;
    }

    return total * sign;

  }
}
