package com.nathan.leetcode.utils;

/**
 * Created by Nathan on 11/12/16.
 */
public class BubbleSort {

    public static void sort(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) return;
        int n = A.length;


        for (int i = 0; i < n; i++) {
            boolean swap = false;
            for (int j = n - 1; j > i; j--) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                    swap = true;
                }
            }
            if (!swap) break;
        }


    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
