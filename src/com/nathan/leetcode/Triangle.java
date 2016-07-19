package com.nathan.leetcode;

/**
 * Created by Nathan on 5/2/2016.
 */
public class Triangle {

    public static void main(String[] args) {
        int [][] nums = {{-10}};

        int minPath = minimumTotal(nums);
        System.out.println(minPath);
    }

    private static int min = Integer.MAX_VALUE;
    public static int minimumTotal(int[][] triangle) {
        // write your code here

        int[][] hash = new int[triangle.length][];

        for (int i = 0; i < hash.length; i++) {
            hash[i] = new int[i+1];

            for(int j = 0; j < hash[i].length; j++) {
                hash[i][j] = Integer.MAX_VALUE;
            }
        }

        int sum = 0;

        dfs(hash, sum, triangle, 0, 0);

        return min;


    }

    public static void dfs(int[][] hash, int sum, int[][] triangle, int row, int col) {

        if (row == triangle.length) return;

        if ( hash[row][col] != Integer.MAX_VALUE) {
            min = Math.min(sum, min);
            return;

        }

        hash[row][col] = sum + triangle[row][col];


        if (row == triangle.length - 1) {
            min = Math.min(sum, min);
            return;
        }

        dfs(hash, hash[row][col], triangle, row + 1, col);
        dfs(hash, hash[row][col], triangle, row + 1, col + 1);

    }
}
