package com.nathan.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/

public class RomanToInteger {
  
  public static void main(String[] args) {
    String s = "MCMLIV";
    
    System.out.println(romanToInt(s));
  }
  
  
  //array solution, fast than hashtable
  public static int romanToInt(String s) {
    if(s == null || s.length() == 0) return 0;
    int num = 0;
    int [] romanNumeric = new int[26];
    
    romanNumeric['I' - 'A'] = 1;
    romanNumeric['V' - 'A'] = 5;
    romanNumeric['X' - 'A'] = 10;
    romanNumeric['L' - 'A'] = 50;
    romanNumeric['C' - 'A'] = 100;
    romanNumeric['D' - 'A'] = 500;
    romanNumeric['M' - 'A'] = 1000;
    
    int prevValue = romanNumeric[s.charAt(0) - 'A'];
    
    for(char c:s.toCharArray()) {
      int currValue = romanNumeric[c-'A'];
      if(currValue > prevValue) {
        int temp = currValue - prevValue;
        num = num - prevValue + temp;
      } else {
        num += currValue;
      }
      prevValue = currValue;
      
    }
    return num;
    
  }
  
  //Hash Table
  public static int romanToInt2(String s) {
    
    if(s == null || s.length() == 0) return 0;
    
    int num = 0;
    Map<Character, Integer> romanNumeric = new HashMap<>();
    romanNumeric.put('I', 1);
    romanNumeric.put('V', 5);
    romanNumeric.put('X', 10);
    romanNumeric.put('L', 50);
    romanNumeric.put('C', 100);
    romanNumeric.put('D', 500);
    romanNumeric.put('M', 1000);
    
    // need to add validation
    
    int prevValue = romanNumeric.get(s.charAt(0));
    
    for(char c:s.toCharArray()) {
      int currValue = romanNumeric.get(c);
      if(currValue > prevValue) {
        int temp = currValue - prevValue;
        num = num - prevValue + temp;
      } else {
        num += currValue;
      }
      prevValue = currValue;
      
    }
    return num;
    
  }
  
}
