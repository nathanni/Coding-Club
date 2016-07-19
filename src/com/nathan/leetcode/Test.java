package com.nathan.leetcode;

import java.util.ArrayList;

/**
 * Created by Nathan on 5/16/2016.
 */
public class Test {

    public static void main(String[] args) {


        int []matrix = {1,2,7,8,5};

        Test test = new Test();

        test.intervalMinNumber(matrix);
    }

    private int [] nums;
    private int [] tree;
    public ArrayList<Integer> intervalMinNumber(int[] A) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }

        tree = new int[A.length + 1];
        nums = A;


        for (int i = 1; i < tree.length; i++) {

            tree[i] = Integer.MAX_VALUE;

            for (int j = i - lowbit(i); j < i; j++) {
                tree[i] = Math.min(tree[i], A[j]);
            }
        }

//        for (Interval query : queries) {
//            int num = Math.min(min(query.start), min(query.end));
//            result.add(num);
//        }

        return result;
    }

    public void update(int index, int val) {

        nums[index] = val;

        for (int i = index + 1; i < tree.length; i += lowbit(i)) {
            tree[i] = Math.min(tree[i], val);
        }
    }

    public int min(int index) {
        int ret = 0;
        for (int i = index + 1; i > 0; i -= lowbit(i)) {
            ret = Math.min(ret, tree[i]);
        }

        return ret;
    }

    public int lowbit(int x) {
        return x & -x;
    }
}
