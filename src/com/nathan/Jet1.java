package com.nathan;

/**
 * Created by nni on 10/19/2016.
 */
public class Jet1 {

    public static void main(String[] args) {
        Jet1 test2 = new Jet1();

        int[][] matrix = {{1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};
        int[] res = test2.findRectangle(matrix);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] findRectangle(int[][] matrix) {

        int x = 0, y = 0, width, height;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int pos = binarySearch(matrix[i]);
            if (pos != -1) {
                x = i;
                y = pos;
                break;
            }
        }

//        boolean found = false;
//
//        for (int i = 0; i < m; i++) {
//            if (found) break;
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    x = i;
//                    y = j;
//                    found = true;
//                    break;
//                }
//            }
//        }

        int start = y, end = n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[x][mid] <= 0) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[x][end] == 0) width = end - y + 1;
        else width = start - y + 1;

        start = x;
        end = m - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][y] <= 0) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[end][y] == 0) height = end - x + 1;
        else height = start - x + 1;

        return new int[]{x, y, width, height};


    }

    private int binarySearch(int[] A) {
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] < A[end]) {
                end = mid;
            } else if (A[mid] > A[end]) {
                start = mid;
            } else {
                end--;
            }
        }

        if (A[start] == 0) return start;
        else if (A[end] == 0) return end;
        else return -1;

    }
}
