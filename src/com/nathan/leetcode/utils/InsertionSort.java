package com.nathan.leetcode.utils;

public class InsertionSort {

    public static void sort(int[] A) {

        if (A == null || A.length == 0) return;

        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return;
    }


    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
