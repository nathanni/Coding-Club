package com.nathan.amazon;

/**
 * Created by Nathan on 11/21/16.
 */
public class Rotate_Image {

    public static void main(String[] args) {
        Rotate_Image rotate_image = new Rotate_Image();
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{1,2}};
        print(matrix);
        System.out.println();
        print(rotate_image.solution(matrix, 1));
        System.out.println();
        print(rotate_image.solution(matrix, 2));
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] solution(int[][] matrix, int flag) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return matrix;


        int[][] res = transform(matrix);

        flip(res, flag);
        return res;



    }

    private void flip(int[][] res, int flag) {

        int m = res.length;
        int n = res[0].length;
        //clock wise
        if (flag == 1) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n / 2; j++) {
                    swap(res, i, j, i, n - j - 1);
                }
            }
        // anti clock wise
        } else {
            for (int i = 0; i < m / 2; i++) {
                for (int j = 0; j < n; j++) {
                    swap(res, i, j, m - i - 1, j);
                }
            }
        }


    }

    private void swap(int[][] res, int i1, int j1, int i2, int j2) {
        int tmp = res[i1][j1];
        res[i1][j1] = res[i2][j2];
        res[i2][j2] = tmp;
    }

    private int[][] transform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ret = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = matrix[j][i];
            }
        }
        return ret;
    }
}
