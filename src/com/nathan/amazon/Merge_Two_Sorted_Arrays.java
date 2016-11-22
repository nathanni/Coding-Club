package com.nathan.amazon;

/**
 * Created by nni on 11/22/2016.
 */
public class Merge_Two_Sorted_Arrays {

    public static void main(String[] args) {
        int[] A ={3,5,7,8,14};
        int[] B = new int[10];
        B[0] =-64;
        B[1] = 0;
        B[2] = 6;
        B[3] = 9;
        B[4] = 15;

        int[] res = helper(A, B, 5);

        for (int i : res) {
            System.out.print(i + " ");
        }

    }

    public static int[] helper(int[] A, int[] B, int m) {

        if (A.length + m != B.length) return new int[]{};


        int i = m - 1;
        int j = m - 1;
        int k = B.length - 1;

        while (i >= 0 || j >= 0) {
            if (i < 0) {
                B[k--] = B[j--];
            } else if (j < 0) {
                B[k--] = A[i--];
            } else {
                if (A[i] < B[j]) {
                    B[k--] = B[j--];
                } else {
                    B[k--] = A[i--];
                }
            }
        }

        return B;




    }
}
