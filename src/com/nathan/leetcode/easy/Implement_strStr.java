package com.nathan.leetcode.easy;

/*Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.*/

public class Implement_strStr {
  
  public static void main(String[] args) {
    System.out.println(strStr("ffuckk", "ckke"));
  }
  public static int strStr(String haystack, String needle) {
    if(needle.equals("") || needle == null) return 0;
    if(haystack == null || haystack == "" || needle.length() > haystack.length()) return -1;
    
    for(int i = 0, j = 0; i < haystack.length();) {
      if(haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      } else if(j ==0) {
          i++;
        } else {
          i = i - j +1;
          j = 0;
        }
      
      if(j == needle.length()) return i- j;
      if(j == 0 &&((haystack.length() - i) < needle.length())) return -1;
      
    }
    return -1;
  }
}
