package com.nathan.leetcode.easy;


/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?*/

public class ValidAnagram {
  
  public static void main(String[] args) {
    System.out.println(isAnagram("ba", "aa"));
  }
  
  
  //if unicode, we can sort two arrays first, then compare.
  
  
  //array solution: suppose the string contains only lowercase alphabets.
  public static boolean isAnagram(String s, String t) {
    
    if(s.length() != t.length()) {
      return false;
    }
    
    int [] arr = new int[26]; //we only have lowercase alphabets
    
    for(char c:s.toCharArray()) {
      ++arr[c-'a'];
    }
    
    for(char c:t.toCharArray()) {
      --arr[c-'a'];
      if(arr[c-'a'] < 0) {
        return false;
      }
    }
    
    return true;
  }
}
