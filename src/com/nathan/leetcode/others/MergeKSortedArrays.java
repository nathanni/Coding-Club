package com.nathan.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 5/13/2016.
 */
public class MergeKSortedArrays {

    public static void main(String[] args) {
        int [][] arr= new int [][]{{1,3,5,7},{2,4,6},{0,8,9,10,11}};
        List<Integer> list = mergekSortedArrays(arr);
        for(Integer i : list) {
            System.out.println(i);
        }
    }

    public static List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here

        if (arrays == null || arrays.length == 0) return null;



        while(arrays.length > 1) {
            int n = arrays.length;
            int[][] newArr = new int [n / 2 + n % 2][];

            for (int i = 0, j = 0; i + 2 < n; i += 2 , j++) {
                int [] mergeArr= merge(arrays[i], arrays[i + 1]);
                newArr[j] = mergeArr;
            }

            if (n % 2 == 1) {
                newArr[newArr.length - 1] = arrays[n - 1];
            }

            arrays = newArr;

        }


        List<Integer> list = new ArrayList<Integer>();

        int [] result = arrays[0];

        for (int i = 0; i < result.length; i ++) {
            list.add(result[i]);
        }

        return list;
    }

    private static int[] merge(int[] left, int[] right){

        if ((left == null || left.length == 0) && (right == null || right.length == 0)) return null;
        if (left == null || left.length == 0) return right;
        if (right == null || right.length == 0) return left;

        int m = left.length;
        int n = right.length;
        int [] arr = new int[m + n];

        for (int i = 0, j = 0, k = 0; k < m + n; k++) {
            if (i == m) {
                arr[k] = right[j++];
            } else if (j == n) {
                arr[k] = left[i++];
            } else {
                arr[k] = left[i] <= right[j] ? left[i++] : right[j++];
            }
        }

        return arr;

    }
}
