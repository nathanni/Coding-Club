package com.nathan.leetcode.medium;


/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/

public class MinimumPathSum {
  
  public static void main(String[] args) {

  }
  
  
  //no extra space, DP solution
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    
    for(int i = 0; i < m; i ++) {
      for(int j = 0; j < n; j++) {
        if(i == 0 && j ==0) {
          continue;
        } else if(i == 0) {
          grid[i][j] += grid[i][j-1];
        } else if(j == 0) {
          grid[i][j] += grid[i-1][j];
        } else {
          grid[i][j] = min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
        }
      }
    }
    
    return grid[m-1][n-1];  
    
  }
  
  //orginal solution, extra space
  
  public int minPathSum2(int[][] grid) {
    
    int m = grid.length;
    int n = grid[0].length;
    int [][] f = new int[m][n];
    
    for(int i = 0; i < m; i ++) {
      for(int j = 0; j < n; j++) {
        if(i == 0 && j ==0) {
          f[i][j] = grid[i][j];
        } else if(i == 0) {
          f[i][j] = f[i][j-1] + grid[i][j];
        } else if(j == 0) {
          f[i][j] = f[i-1][j] + grid[i][j];
        } else {
          f[i][j] = min(f[i-1][j],f[i][j-1]) + grid[i][j];
        }
      }
    }
    
    return f[m-1][n-1];
    
  }

  private int min(int i, int j) {
    return i <= j ? i:j;
  }
}
