package com.nathan.leetcode.easy;
/*Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Hint:

A naive implementation of the above process is trivial. Could you come up with others methods?
What are all the possible results?
How do they occur, periodically or randomly?
You may find this Wikipedia article useful.  DIGITAL ROOT */
public class AddDigits {

  // O(1)
  public int addDigits(int num) {
    if (num >= 9 && num % 9 == 0)
      return 9;
    else
      return num % 9;
  }

  // Use loop
  public int addDigits2(int num) {
    int result = 0;
    if (num / 10 < 1)
      return num;
    while (num / 10 >= 1) {
      result += num % 10;
      num = num / 10;
    }
    result += num;
    return addDigits(result);
  }
}
