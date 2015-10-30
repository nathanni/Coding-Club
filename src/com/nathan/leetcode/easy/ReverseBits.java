package com.nathan.leetcode.easy;

/*Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer*/

public class ReverseBits {

  public static void main(String[] args) {
    int i = 1 ;
    System.out.println(reverseBits(i));
  }

  public static int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res = (res << 1) | (n & 1);
      n = n >>> 1;
    }
    return res;
  }

  // my original
  // you need treat n as an unsigned value
  public static int reverseBits2(int n) {

    int[] bits = new int[32];
    for (int i = 0, j = 0; i < 32; i++, j++) {
      bits[j] = ((1 << i) & n) >> i;
    }

    int num = 0;
    for (int i = 31, j = 0; i >= 0; i--, j++) {
      num = num | (bits[i] << j);
    }

    return num;
  }
}
