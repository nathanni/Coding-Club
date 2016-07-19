package com.nathan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nathan on 4/7/2016.
 */
public class TestSubsets {

    public static void subsets(int[] num) {
        if (num == null || num.length == 0)
            return;

        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);

        subsetsHelper(list, num, 0);


    }

    public static void subsetsHelper(ArrayList<Integer> list, int[] num, int pos) {
        System.out.println(list);

        for (int i = pos; i < num.length; i++) {
            list.add(num[i]);
            subsetsHelper(list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,2});
    }

}
