package com.nathan.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 11/22/16.
 */
public class Window_Sum {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(5);
        A.add(1);
        A.add(-5);
        A.add(6);
        A.add(99);
        A.add(12);
        A.add(5);
        A.add(13);
        A.add(523);
        A.add(5);
        A.add(3);
        A.add(11);
        A.add(0);
        A.add(-33);
        A.add(5);

        List<Integer> res1 = getSum(A, 3);
        List<Integer> res2 = getSum2(A, 3);

        System.out.println(res1);
        System.out.println(res2);
    }


    public static List<Integer> getSum(List<Integer> A, int k) {

        if (A == null || A.size() == 0 || k <= 0) return new ArrayList<>();


        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {

            if (i >= k) {
                sum -= A.get(i - k);
            }


            sum += A.get(i);
            if (i >= k - 1) {
                res.add(sum);
            }

        }
        return res;
    }

    public static List<Integer> getSum2(List<Integer> A, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        int len = A.size();
        for (int i = 0; i + k - 1 < len; ++i) {
            int sum = 0;
            for (int j = 0; j < k; ++j) {
                sum += A.get(i + j);
            }
            res.add(i, sum);
        }
        return res;
    }
}
