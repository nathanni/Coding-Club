package com.nathan.leetcode.others;

/**
 * Created by Nathan on 5/5/2016.
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("helo World"));
    }

    public static String reverseString(String s) {

        if (s == null || s.length() == 0 || s.length() == 1) return s;

        StringBuilder sb = new StringBuilder();

        sb.append(reverseString(s.substring(1))).append(s.charAt(0));

        return sb.toString();


    }

}
