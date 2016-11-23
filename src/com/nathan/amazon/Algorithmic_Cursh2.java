package com.nathan.amazon;

import java.util.Scanner;

/**
 * Created by Nathan on 11/22/2016.
 */
public class Algorithmic_Cursh2 {

    private static int max;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        String in = sc.nextLine();
        long max = 0;
        int len = 0;
        int operations  = 0;
        if (in != null) {
            String[] sArr = in.trim().split("\\s");
            len = Integer.parseInt(sArr[0]);
            operations = Integer.parseInt(sArr[1]);
        }

        //List<Point> points = new ArrayList<>();

        int[] start = new int[len + 1];
        int[] end = new int[len + 1];

        for (int i = 0; i < operations; i++) {
            in = sc.nextLine();
            String[] sArr = in.trim().split("\\s");
            start[Integer.parseInt(sArr[0])] += Integer.parseInt(sArr[2]);
            end[Integer.parseInt(sArr[1])] += Integer.parseInt(sArr[2]);
        }

        long sum = 0;

        for (int i = 1; i <= len; i++) {
            sum += start[i];

            max = Math.max(max, sum);

            sum -= end[i];
        }


        System.out.println(max);



    }


}