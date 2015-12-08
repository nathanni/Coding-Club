package com.nathan.leetcode.easy;

/*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.*/

public class FirstBadVersion {
  
  public static void main(String[] args) {
    System.out.println(firstBadVersion(2126753390));
  }
  public static int firstBadVersion(int n) {
    
    int start = 1;
    int end = n;

    while(end > start) {
      n = start + (end - start) / 2;
      
      if(isBadVersion(n)) end = n;
      else start = n + 1;
    }
    return start;

    
  }

  private static boolean isBadVersion(int pos) {
    
    return pos >= 1702766719;
  }
}
