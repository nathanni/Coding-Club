package com.nathan.leetcode.easy;

import java.util.HashMap;
import java.util.Objects;

/*Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.*/

public class IsomorphicStrings {
  public static void main(String[] args) {
    System.out.println(isIsomorphic("eaa", "add"));
  }
  
  public static boolean isIsomorphic(String s, String t) {
      int[] m = new int[512];
      for (int i = 0; i < s.length(); i++) {
          if (m[s.charAt(i)] != m[t.charAt(i)+256]) return false;
          m[s.charAt(i)] = m[t.charAt(i)+256] = i+1;
      }
      return true;
  }
  
  public static boolean isIsomorphic2(String s, String t) {
    
    HashMap<Character, Integer> hashMapS = new HashMap<>();
    HashMap<Character, Integer> hashMapT = new HashMap<>();
    
    for(int i = 0; i < s.length(); i++) {
      if(!Objects.equals(hashMapS.put(s.charAt(i), i), hashMapT.put(t.charAt(i), i))) {
        return false;
      }
    }
    return true;
    
    
  }
}
