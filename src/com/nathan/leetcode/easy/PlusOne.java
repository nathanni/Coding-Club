package com.nathan.leetcode.easy;

/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/

public class PlusOne {

  public static void main(String[] args) {

    int[] nums = { 9 ,2,1,3,9};

    int[] nums1 = plusOne(nums);

    for (int i : nums1) {
      System.out.print(i + " ");
    }
  }

  public static int[] plusOne(int[] digits) {

    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] += 1;

      if (digits[i] == 10) {
        digits[i] = 0;
      } else {
        return digits;
      }

    }

    int[] newDigtis = new int[digits.length + 1];
    newDigtis[0] = 1;
    return newDigtis;

  }
}
