package com.nathan.amazon;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by nni on 11/22/2016.
 */
public class Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(isValid("asd}"));
    }
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {

            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                //如果有可能出现额外的字母
                if (c == ')' || c == ']' || c =='}') {
                    if (stack.isEmpty() || stack.pop() != c) return false;
                }

            }
        }
        return stack.isEmpty();

    }
}
