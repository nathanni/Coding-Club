package com.nathan.leetcode.easy;

import com.nathan.leetcode.utils.Stack;

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/

public class ValidParentheses {
  public boolean isValid(String s) {

    if (s.length() % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    
    return stack.isEmpty();

  }
}
