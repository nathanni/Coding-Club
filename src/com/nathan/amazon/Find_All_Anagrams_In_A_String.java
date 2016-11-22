package com.nathan.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nni on 11/22/2016.
 */
public class Find_All_Anagrams_In_A_String {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return new ArrayList<>();

        int[] hash = new int[256];

        for (char c: p.toCharArray()) {
            hash[c]++;
        }
        List<Integer> res = new ArrayList<>();

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if (count == 0 && right - left == p.length()) {
                res.add(left);
            }

            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return res;



    }
}
