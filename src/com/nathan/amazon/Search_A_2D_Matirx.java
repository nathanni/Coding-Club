package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Search_A_2D_Matirx {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = m * n - 1;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            int x = mid / n;
            int y = mid % n;

            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] < target) {
                start = mid;
            } else {
                end = mid;
            }


        }

        if (matrix[end / n][end % n] == target) return true;
        else if (matrix[start / n][start % n] == target) return true;
        else return false;

    }
}
