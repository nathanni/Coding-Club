package com.nathan.amazon;

/**
 * Created by nni on 11/21/2016.
 */
public class Maximum_Minimum_Path {

    public static void main(String[] args) {
        int[][] grid = {{8, 4, 7}, {6, 5, 9}};
        int[][] grid2 = {{8, 4, 3, 5}, {6, 5, 9, 8}};
        System.out.println(maxMinPath2(grid));
        System.out.println(maxMinPath2(grid2));
    }

    public static int maxMinPath(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        if (grid[0] == null || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;


        //f[i][j] 表示 到i,j 这个点的所有路径里面的最小值的最大值
        //所以f[i][j] 等于从上面过来和左边过来的f[][], 在和本身的取小, 因为如果本身小的话, 本身会是那个最小值.
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                } else {
                    int left = j - 1 >= 0 ? f[i][j - 1] : Integer.MIN_VALUE;
                    int up = i - 1 >= 0 ? f[i - 1][j] : Integer.MIN_VALUE;
                    f[i][j] = Math.min(Math.max(left, up), grid[i][j]);
                }
            }
        }
        return f[m - 1][n - 1];


    }


    //DFS TOP DOWN
    private static int max;
    public static int maxMinPath2(int[][] grid) {

        max = Integer.MIN_VALUE;
        dfs(grid, 0, 0, Integer.MAX_VALUE);

        return max;
    }

    private static void dfs(int[][] grid, int i, int j, int min) {
        if (i >= grid.length || j >= grid[0].length) return;


        min = Math.min(grid[i][j], min);

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            max = Math.max(max, min);
        }

        dfs(grid, i + 1, j, min);
        dfs(grid, i, j + 1, min);

    }
}
