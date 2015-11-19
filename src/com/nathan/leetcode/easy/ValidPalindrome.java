package com.nathan.leetcode.easy;

/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

//leetcode solution slower than mine
 class Solution {
  public boolean isPalindrome(String s) {
     String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
      String rev = new StringBuffer(actual).reverse().toString();
      return actual.equals(rev);        
  }
}

public class ValidPalindrome {
  
  public static void main(String[] args) {
    
    System.out.println(isPalindrome(".a"));
  }
  public static boolean isPalindrome(String s) {
    if(s == null || s.isEmpty()) return true;
    
    int head =0, tail = s.length()-1;
    while(head <= tail) {
      while(!Character.isLetterOrDigit(s.charAt(head))) {
        head++;
        if(head == s.length()) return true;
      }  
      while(!Character.isLetterOrDigit(s.charAt(tail))) {
        tail--;
        if(tail == 0) return true;
      }
      if(Character.toLowerCase(s.charAt(head++)) != Character.toLowerCase(s.charAt(tail--))) return false;
    }
    return true;
    
    
/*     char [] charArr = s.toCharArray();
     for(int i = 0, j = charArr.length -1; i < charArr.length; i++,j--) {
       while(!Character.isLetterOrDigit(charArr[i])) {
         i++;
         if(i == charArr.length) return true;
       }
       while(!Character.isLetterOrDigit(charArr[j])) {
         j--;
         if(j == 0) return true;
       }
       if(Character.toLowerCase(charArr[i]) != Character.toLowerCase(charArr[j])) return false;
       if(i >= j) break;
     }
     return true;*/
  }
}
