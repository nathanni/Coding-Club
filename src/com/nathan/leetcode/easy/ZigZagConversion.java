package com.nathan.leetcode.easy;

public class ZigZagConversion {
  
  public static void main(String[] args) {
    String s = convert("A", 2);
    System.out.println(s);
  }
  
  //leetcode elegant solution 
  public String convert2(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
}
  

  public static String convert(String s, int numRows) {
    
    if(s == null) return null;
    if(numRows <= 1) return s;
    
    //calculate how many columns we gonna have
    int numColumns = s.length() / (numRows + numRows -2) *2 + (s.length() % (numRows + numRows -2) > numRows?2:1);
    
    int index = 0;
    char[][] arr = new char[numRows][numColumns];
    for(int j = 0; j < numColumns; j++) {
      if( j % 2 == 0) {
        for(int i = 0; i < numRows && index<s.length(); i++)
          arr[i][j] = s.charAt(index++);
      } else {
        for(int i = numRows -2; i > 0 && index<s.length(); i--) {
          arr[i][j] = s.charAt(index++);
        }
      }
      
    }
    
    StringBuilder sb = new StringBuilder();
    for(int i =0; i < arr.length; i++) {
      for(int j =0; j < arr[i].length; j++) {
          sb.append(arr[i][j]);
      }
    }
    return sb.toString().replaceAll("\\x00", "");
    
    
  }
  
}
