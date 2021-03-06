package com.nathan.leetcode.utils;

public class SelectionSort {


    public static void sort(int[] A) {
        if (A == null || A.length == 0) return;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[k]) {
                    k = j;
                }
            }
            swap(A, k, i);
        }
        return;
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
