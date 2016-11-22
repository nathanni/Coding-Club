package com.nathan.amazon;

/**
 * Created by Nathan on 11/21/16.
 */
public class Arithmetic_Sequence {


    public static void main(String[] args) {
        int[] A = {0,1,2,3,2,1,4,5,6,7,1,3,4,5,6,-1,2,5,8,8,8,8,8,7,6,5,4,3};
        int[] B = {1,2,3};
        System.out.println(getLAS(A));
        System.out.println(getLAS(B));
        System.out.println(getLAS2(A));
        System.out.println(getLAS2(B));
    }

    public static int getLAS(int[] A) {
        if (A == null || A.length < 3) return 0;

        int res = 0;
        int diff = Integer.MIN_VALUE;
        int currDiff = 0;
        int start = 0;

        for (int i = 1; i < A.length; i++) {
            currDiff = A[i] - A[i - 1];
            if (diff == currDiff) {
                res += i - start - 1 > 0 ? i - start - 1: 0;
            } else {
                start = i - 1;
                diff = currDiff;
            }
        }
        return res;

    }

    public static int getLAS2(int[] A) {
        if (A.length < 3) return 0;

        int res = 0;
        int diff = Integer.MIN_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 1; i < A.length; i++){
            int currDiff = A[i] - A[i - 1];
            if (diff == currDiff){
                // 比较难想到的一步！！！
                count += i - start - 1 > 0 ? i - start - 1 : 0;
            } else {
                start = i - 1;
                diff = currDiff;
                res += count;
                count = 0;
            }
        }
        res += count;
        return res;
    }
}
