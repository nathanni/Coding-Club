package com.nathan.crackingcodinginterview.others;

/**
 * Created by nni on 5/12/2016.
 */
public class MergeSortedArrayII {

    public static void main(String[] args) {
        int [] A = {1};
        int [] B = {1};
        int [] arr = mergeSortedArray(A, B);
    }
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here

        if ((A == null || A.length == 0) && (B == null || B.length == 0)) return null;
        if (A == null || A.length == 0) return B;
        if (B == null || A.length == 0) return A;


        int m = A.length;
        int n = B.length;

        int [] newArr = new int[m + n];

        int i = 0, j = 0;

        for (int k = 0; k < newArr.length; k++) {

            if (i == m) {
                newArr[k] = B[j++];
            } else if (j == n) {
                newArr[k] = A[i++];
            }
            else {
                newArr[k] = A[i] <= B[j] ? A[i++] : B[j++];
            }
        }

        return newArr;
    }
}
