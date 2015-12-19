package com.nathan.leetcode.medium;


/*Given an array of integers, every element appears twice except for one. Find that single one.*/

/*Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

public class SingleNumber {

  public static void main(String[] args) {
    int n =0;
    n = n | (1<<999999);
    System.out.println(n);
  }

  // A XOR A = 0,   XOR operation is commutative
  // SO  if there is an array [2,1,1,3,2,4,5,6,5,4,6]
  // 2^1^1^3^2^4^5^6^5^4^6 = (2^2)^(1^1)^(4^4)^(5^5)^(6^6)^3 = 3
  public int singleNumber(int[] nums) {
    int result = nums[0];
    for(int i = 1; i < nums.length; i++) {
      result ^= nums[i];
    }

    return result;

  }
}
