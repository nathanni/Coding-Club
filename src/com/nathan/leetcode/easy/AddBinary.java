package com.nathan.leetcode.easy;


/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/

public class AddBinary {
  public static void main(String[] args) {
    System.out.println(addBinary("0", "0"));

  }
  public static String addBinary(String a, String b) {
    int aLength = a.length();
    int bLength = b.length();
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while(Math.max(aLength, bLength) > 0) {
      int aNum = aLength > 0 ? (a.charAt(aLength---1) - '0') : 0;
      int bNum = bLength > 0 ? (b.charAt(bLength---1) - '0') : 0;
      int cNum = aNum + bNum + carry;
      sb.append(cNum%2);
      carry = cNum / 2;
    }
    
    return (carry == 1)?sb.append(1).reverse().toString():sb.reverse().toString();
  }
}
