package com.nathan.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class PascalTriangle {
  
  
  //leetcode most vote solution
/*  two loops, one go through the row, one go through the column

  database: pretty straight forward, ArrayList

  calculate element value: K(i)(j)=K(i-1)(j-1)+K(i-1)(j) except for the first and last element*/

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    if (numRows <=0){
        return triangle;
    }
    for (int i=0; i<numRows; i++){
        List<Integer> row =  new ArrayList<Integer>();
        for (int j=0; j<i+1; j++){
            if (j==0 || j==i){
                row.add(1);
            } else {
                row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
            }
        }
        triangle.add(row);
    }
    return triangle;
}
  
  //my solution 
  public static List<List<Integer>> generate2(int numRows) {
    if(numRows < 0)
      return null;
    
    Integer [][] arr = new Integer[numRows][];
    List<List<Integer>> list = new ArrayList<>();
    
    for(int i = 0; i < numRows; i ++) {
      arr[i] = new Integer[i+1];
      arr[i][0] = 1; // first element
      arr[i][i] = 1; // last element
      for(int j = 1; j < i; j++) {
        arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
      }
      list.add(Arrays.asList(arr[i]));
    }
    
    return list;
    
  }
}
