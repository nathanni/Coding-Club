package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Search_A_2D_Matirx_II {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0 ) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;

    }

    //求 target 数量
    public int searchMatrix2(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) return 0;
        if (matrix[0] == null || matrix[0].length == 0) return 0;

        int i = 0;
        int j = matrix[0].length - 1;

        int count = 0;

        while (i < matrix.length && j >= 0 ) {
            if (matrix[i][j] == target) {
                count++;
                i++;
                j--;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return count;

    }
}
