package com.nathan.amazon;

import java.util.Arrays;

/**
 * Created by Nathan on 11/21/16.
 */
public class Day_Change_Cell_Growth {

    public static void main(String[] args) {
        int[] days = {1, 0, 0, 0, 0, 1, 0, 0};

        int[] s1 = solution(days, 5);
        int[] s2 = solution2(days, 5);
        print(s1);
        print(s2);

    }

    public static void print(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static int[] solution (int[] days, int n) {
        if (days == null || days.length == 0 || n <= 0) return days;

        int len = days.length;

        int[] ret = new int[len + 2];

        for (int i = 1; i <= len; i++) {
            ret[i] = days[i - 1];
        }


        for (int i = 0; i < n; i++) {
            int prev = ret[0];
            for (int j = 1; j <= len; j++) {
                int tmp = ret[j];
                ret[j] = prev ^ ret[j + 1];
                prev = tmp;
            }

        }

        return Arrays.copyOfRange(ret, 1, len + 1);


    }

    public static int[] solution2(int[] days, int n) {
        if (days == null || n <= 0) return days;
        int length = days.length;
        //两边添加0
        int[] rvalue = new int[length + 2];
        rvalue[0] = rvalue[length+1] = 0;
        int pre;
        for (int i = 1; i <= length; i++)
            rvalue[i] = days[i-1];
        for (int i = 0; i < n; i++) {
            pre = rvalue[0];
            for (int j = 1; j <= length; j++) {
                int temp = rvalue[j];
                rvalue[j] = pre ^ rvalue[j+1];
                pre = temp;
            }
        }
        return Arrays.copyOfRange(rvalue, 1, length+1);
    }

}
