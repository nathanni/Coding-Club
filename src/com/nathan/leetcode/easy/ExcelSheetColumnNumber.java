package com.nathan.leetcode.easy;

/*Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 */

public class ExcelSheetColumnNumber {
  
  public static void main(String[] args) {
    
    System.out.println(titleToNumber("ABS"));
    
  }
  
  //need to add validation for non-letter
  public static int titleToNumber(String s) {
    char [] charArray = s.toCharArray();
    int num = 0;
    int j = 0;
    for(int i = charArray.length-1; i >=0; i--) {
      num += (int) ((charArray[i] - 'A' + 1) * Math.pow(26, j++)); 
    }
    
    return num;
  }
}
