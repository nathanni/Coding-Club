package com.nathan.bittiger.gasStation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nni on 9/20/2016.
 */
public class Solution {

    public static int canCompleteCircle(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        if (gas.length != cost.length) return -1;

        int sum = 0;
        int curr = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                index = i + 1;
                curr = 0;
            }
        }

        return sum >= 0 ? index : - 1;




    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/com/nathan/bittiger/gasStation/input"));

        int n = sc.nextInt();
        int[] gas = new int[n];
        int[] cost = new int[n];

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

        System.out.println(canCompleteCircle(gas, cost));
        sc.close();

    }
}
