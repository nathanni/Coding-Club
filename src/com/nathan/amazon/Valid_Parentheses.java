package com.nathan.amazon;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by nni on 11/22/2016.
 */
public class Valid_Parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {

            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();

    }
}
