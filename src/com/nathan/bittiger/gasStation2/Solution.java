package com.nathan.bittiger.gasStation2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nni on 9/20/2016.
 */
public class Solution {
    public static int canCompleteCircle(int[] gas, int[] cost, int m) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || m <= 0) return -1;
        if (gas.length != cost.length) return -1;

        int n = gas.length;
        int trip = 0;
        int sum = 0;
        int index = 0;

        for (int i = 0; i < n * 2 ; i++) {
            int curr = i %n;
            sum += gas[curr];
            sum = Math.min(m, sum);
            sum -= cost[curr];
            if (sum < 0) {
                index = i + 1;
                sum = 0;
                trip = 0;
            } else {
                if (++trip == n) break;
            }

        }

        return trip == n ? index: -1;




    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/gasStation2/input"));

        int n = sc.nextInt();
        int[] gas = new int[n];
        int[] cost = new int[n];

        int m = sc.nextInt();
        System.out.println(m);

        int index = 0;

        n = sc.nextInt();
        while (n != -1) {

            if (index % 2 == 0) {
                gas[index / 2] = n;
            } else {
                cost[index / 2] = n;
            }
            index++;
            n = sc.nextInt();


        }

        System.out.println(canCompleteCircle(gas, cost,m));
        sc.close();

    }
}
