package com.nathan.bittiger.rotationOfString;

/**
 * Created by Nathan on 9/17/2016.
 */
public class Solution {

    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s1.length() == 0|| s2 == null || s2.length() == 0) return false;

        String s = s1 + s1;

        int left = 0, right = s1.length();


        while (right <= s.length()) {
            if (s.substring(left++, right++).equals(s2)) {
                return true;
            }
        }
        return false;

        //return s.contains(s2);
    }

    public static void main(String[] args) {

        String s1 = "stackoverflow";
        String s2 = "stackoverflow";
        String s3 = "ackoverflowst";
        String s4 = "folwstackover";

        System.out.println(isRotation(s1, s2));
        System.out.println(isRotation(s1, s3));
        System.out.println(isRotation(s1, s4));

    }

}
