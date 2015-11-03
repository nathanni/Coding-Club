package com.nathan.leetcode.easy;
/*
Write a function to find the longest common prefix string amongst an array of strings.*/

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length <= 0) return "";
    

    String prefix = "";
    for (int j = 0; j < strs[0].length(); j++) {
      prefix = strs[0].substring(0, j+1);
      for (int i = 0; i < strs.length; i++) {
        if (!strs[i].startsWith(prefix)) {
          return strs[0].substring(0, j);
        }
      }
    }
    return prefix;
  }
}
