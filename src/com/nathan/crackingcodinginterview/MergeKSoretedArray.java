package com.nathan.crackingcodinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nni on 5/12/2016.
 */
public class MergeKSoretedArray {
    public static void main(String[] args) {
        int[][] arrs = new int [][] {{1,3,5,7},{2,4,6},{0,8,9,10,11}};
        List<Integer> list = mergekSortedArrays(arrs);
        for(Integer i : list) {
            System.out.println(i);
        }
    }

    public static  List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here

        if (arrays == null || arrays.length == 0) return null;

        int k = arrays.length;

        int[] list = helper(arrays, 0, k - 1);

        for(int i = 0; i <list.length; i++) {
            System.out.println(i);
        }

        ArrayList<Integer> result = new ArrayList<Integer>(list.length);

        for (int i = 0; i < list.length; i++) {
            result.add(list[i]);
        }
        return result;
    }

    public  static int[] helper(int[][] arrays, int start, int end) {

        if (start >= end) {
            return arrays[start];
        }

        int mid = start + (end - start) / 2;

        int[] left = helper(arrays, start, mid);
        int[] right = helper(arrays, mid + 1, end);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {


        int m = left.length;
        int n = right.length;

        int [] result = new int[m + n];

        for (int i= 0, j = 0, k = 0; k < result.length; k++) {

            if (i == m) {
                result[k] = right[j++];
            } else if (j == n) {
                result[k] = left[i++];
            }

            else {
                result[k] = left[i] <= right[j] ? left[i++] : right[j++];
            }
        }

        return result;
    }
}
