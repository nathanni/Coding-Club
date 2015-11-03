package com.nathan.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/

public class WordPattern {
  
  public static void main(String[] args) {
    String pattern = "abba", str = "dog dog dog dog";
    System.out.println(wordPattern(pattern, str));
  }
  
  //leetcode 1 map solution
  public static boolean wordPattern(String pattern, String str) { 
    String [] arr = str.split(" ");
    if(arr.length != pattern.length()) {
      return false;
    }
    
    Map index = new HashMap(); 
    for(int i = 0; i < arr.length; i++) {
      if(!Objects.equals(index.put(pattern.charAt(i), i), index.put(arr[i], i))) {
        return false;
      }
    }
    
    return true;
  }
  
  
  public static boolean wordPattern2(String pattern, String str) {
    String [] arr = str.split(" ");
    if(arr.length != pattern.length()) {
      return false;
    }
    
    HashMap<Character, String> hashMap = new HashMap<>();
    HashSet<String> hashSet = new HashSet<>();
    
    for(int i = 0; i < pattern.length(); i++) {
      if(hashMap.containsKey(pattern.charAt(i))) {
        if(hashMap.get(pattern.charAt(i)).compareTo(arr[i]) !=0) {
          return false;
        }
      } else {
        hashMap.put(pattern.charAt(i), arr[i]);
        hashSet.add(arr[i]);
      }
    }
    
    return hashMap.size() == hashSet.size();
  }
}
