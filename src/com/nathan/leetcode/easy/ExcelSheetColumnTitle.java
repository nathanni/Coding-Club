package com.nathan.leetcode.easy;
/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB */
public class ExcelSheetColumnTitle {
  public static void main(String[] args) {
    System.out.println(convertToTitle(53));
  }
  public static String convertToTitle(int n) {
    int num;
    char c; 
    StringBuilder sb = new StringBuilder();
    while(n != 0) {
      num = n % 26;
      //special case for number 'Z'
      if(num == 0) {
        c = 'Z';
        n = n /26 - 1;
      } else {
        c = (char) ('A' + num -1);
        n = n /26;
      }
      sb.insert(0, c);
    } 
    return sb.toString();
    
  }
}
